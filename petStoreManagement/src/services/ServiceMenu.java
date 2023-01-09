package services;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Scanner.*;

import customers.Customer;
import customers.CustomerManagement;
import customers.CustomerMenu;
import pets.PetManagement.*;
import customers.IdGenerator;
public class ServiceMenu {
    private static void showMenuService() {
        System.out.println("*************************************************");
        System.out.println("*           ENTER YOUR REQUEST BY NUMBER        *");
        System.out.println("*       1. Add new service.                     *");
        System.out.println("*       2. Search service's information.        *");
        System.out.println("*       3. Edit service's information.          *");
        System.out.println("*       4. Remove service.                      *");
        System.out.println("*       5. Display all service.                 *");
        System.out.println("*       6. Return main Menu.                    *");
        System.out.println("*************************************************");
    }

    static Scanner input = new Scanner(System.in);
    ServiceManagement serviceManagement = ServiceManagement.getServiceManagement();
    Map<String, Service> serviceList = serviceManagement.getServiceList();

    public void handleServiceInput() {
        int choice = -1;

        while(choice != 8){
            showMenuService();
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    addNewService();
                    break;
                case 2:
                    searchService();
                    break;
                case 3:
                    editService();
                    break;
                case 4:
                    removeService();
                    break;
                case 5:
                    serviceManagement.displayAllService();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Your choice is not on the menu :) ");
                    showMenuService();
                    choice = 8;
                    break;
            }
        }
    }




    public String getInputServiceName() {
        System.out.print("Enter service name: ");
        String serviceName = input.nextLine();
        return serviceName;
    }

    public float getInputPrice() {
        System.out.print("Enter price: ");
        float price = input.nextFloat();
        input.nextLine();
//        nextInt khong bat su kien enter nen no se chay tiep nhung het nhung su kien
//        nextLine ke tiep, vi no ngam hieu la cung 1 line
        return price;
    }
    public String getInputDescription() {
        System.out.print("Enter description: ");
        String description = input.nextLine();
        return description;
    }

    public int getInputAge() {
        System.out.print("Enter age: ");
        int age = input.nextInt();
        input.nextLine();
//
        return age;
    }


    public String checkIdExist(String id) {
        if (!serviceList.containsKey(id)) {
            while (serviceList.containsKey(id)) {
                System.out.println("Your Id is exist, please try other id");
                System.out.println("Ids are exist: ");
                for (Map.Entry<String, Service> entry : serviceList.entrySet()) {
                    String key = entry.getKey();
                    System.out.print(key + " ");
                }
                System.out.println();
                id = serviceIdGenerator();
            }
        }
        return id;
    }

    public String serviceIdGenerator(){
        IdGenerator generator = new IdGenerator();
        System.out.println("Please enter package's initial");
        Scanner input = new Scanner(System.in);
        String prefixInput = input.nextLine();
        String suffixInput = generator.generateSuffix();
        generator.init(prefixInput, suffixInput, 1);
        String serviceId = generator.generate();
        System.out.println(serviceId);
        return serviceId;
    }
    public void addNewService() {

        String serviceId = serviceIdGenerator();

        System.out.println("Please enter new service's information");
        serviceId = checkIdExist(serviceId);

        String serviceName = getInputServiceName();
        float price = getInputPrice();
        String description = getInputDescription();

        Service newService = new Service(serviceId, serviceName, price, description);

        serviceManagement.add(serviceId, newService);
//        for (Map.Entry<String, Customer> entry : customerList.entrySet()) {
//            System.out.println(entry);
//        }
        System.out.println("New service added: " + newService);
    }

    public void removeService() {
        String removedId;
        System.out.println("Enter service's id: ");
        removedId = input.nextLine();

        if (serviceList.containsKey(removedId)) {
            System.out.println("Are you sure? (Y/N)");
            String isSure = input.nextLine().trim().toLowerCase();
            if(isSure.equals("y")) {
                System.out.println("Service with id " + removedId + " is deleted");
                serviceList.remove(removedId);
            }
        } else {
            System.out.println("Service with id " + removedId + " doesn't exit");
        }
    }
    public void modifyNavigation(String action){
        if(action == "edit"){
            System.out.println();
            System.out.println("Press 1 if you want to " + action + " name");
            System.out.println("Press 2 if you want to " + action + " price");
            System.out.println("Press 3 if you want to " + action + " description");

        }
        if(action == "search") {
            System.out.println("Press 1 if you want to " + action + " by Id");
            System.out.println("Press 2 if you want to " + action + " by Name/Name");
        }


        System.out.println("Press 9 if you want to go back to main menu");
        System.out.println("Enter your choice: ");
    }

    public void searchService() {
        int choice = -1;
        while(choice != 8){
            modifyNavigation("search");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter service's Id: ");
                    String searchId = input.nextLine().trim();
                    System.out.println(serviceManagement.searchById(searchId));
                    break;
                case 2:
                    System.out.println("Enter service's name: ");
                    String searchName = input.nextLine().trim();
                    System.out.println(serviceManagement.searchByName(searchName));
                    break;
                case 9:
                    choice = 8;
                    break;
                default:
                    System.out.println("Your choice is not on the menu");
                    modifyNavigation("search");
                    break;
            }
        }

    }


    public void editService() {
        System.out.println("Enter service's Id that you want to edit");
        String id = input.nextLine();
        Service editService = serviceList.get(id);
        int choice = -1;
        if(!serviceList.containsKey(id)){
            System.out.println("Customer doesn't exist");
        } else {
            while(choice != 8){
                System.out.println("Customer's info " + editService);
                modifyNavigation("edit");
                choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Enter service's name: ");
                        String editAddress = input.nextLine().trim();
                        serviceManagement.editName(editService, editAddress);
                        System.out.println("Customer's info after edit: " + serviceList.get(id));
                        break;
//            case 2:
//                System.out.println("Enter customer's petId: ");
//                String editPetId = input.nextLine().trim();
//                customerManagement.editPetId(editCustomer, editPetId);
//                System.out.println("Customer's info after edit: ");
//                System.out.println(customerList.get(id));
//                break;
                    case 2:
                        System.out.println("Enter service's price: ");
                        float editPrice = input.nextFloat();
                        input.nextLine();
                        serviceManagement.editPrice(editService, editPrice);
                        System.out.println("Service's info after edit: " + serviceList.get(id));
                        break;
                    case 3:
                        System.out.println("Enter service's description: ");
                        String editDescription = input.nextLine().trim();
                        serviceManagement.editDescription(editService, editDescription);
                        System.out.println("Service's info after edit: " + serviceList.get(id));
                        break;
                    case 9:
                        choice = 8;
                        break;
                    default:
                        System.out.println("Your choice is not on the menu");
                        modifyNavigation("edit");
                        break;
                }
            }
        }

    }

    public static void main(String[] args) {
        ServiceMenu menu = new ServiceMenu();
        menu.handleServiceInput();
    }
}
