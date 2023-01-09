package customers;

import java.util.Map;
import java.util.Scanner;
import java.util.Scanner.*;
import customers.CustomerManagement;
import customers.IdGenerator;

public class CustomerMenu {
    private static void showMenuCustomer() {
        System.out.println("*************************************************");
        System.out.println("*           ENTER YOUR REQUEST BY NUMBER        *");
        System.out.println("*       1. Add new customer.                    *");
        System.out.println("*       2. Search customer's information.       *");
        System.out.println("*       3. Edit customer's information.         *");
        System.out.println("*       4. Remove Customer.                     *");
        System.out.println("*       5. Display all customer.                *");
        System.out.println("*       6. Return main Menu.                    *");
        System.out.println("*************************************************");
    }

    static Scanner input = new Scanner(System.in);
    Map<String, Customer> customerList = CustomerManagement.getCustomerMagagement().getCustomerList();
    CustomerManagement customerManagement = CustomerManagement.getCustomerMagagement();

     public void handleCustomerInput() {
         int choice = -1;

        while(choice != 8){
    showMenuCustomer();
    System.out.println("Enter your choice: ");
    choice = input.nextInt();
    input.nextLine();
    switch (choice) {
        case 1:
            addNewCustomer();
            break;
        case 2:
            searchCustomer();
            break;
        case 3:
            editCustomer();
            break;
        case 4:
            removeCustomer();
            break;
        case 5:
            customerManagement.displayAllCustomer();
            break;
        case 6:
            break;
        default:
            System.out.println("Your choice is not on the menu :) ");
            showMenuCustomer();
            choice = 8;
            break;
    }
}
}




    public String getInputName() {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        return name;
    }

    public String getInputPetId() {
        System.out.print("Enter PetId: ");
        String petId = input.nextLine();
        return petId;
    }
    public String getInputGender() {
        System.out.print("Enter gender: ");
        String gender = input.nextLine();
        return gender;
    }
    
    // public String getInputPetId() {
    //     System.out.print("Enter PetId: ");
    //     String petId = input.nextLine();
    //     return petId;
    // }

    public int getInputAge() {
        System.out.print("Enter age: ");
        int age = input.nextInt();
        input.nextLine();
//        nextInt khong bat su kien enter nen no se chay tiep nhung het nhung su kien
//        nextLine ke tiep, vi no ngam hieu la cung 1 line
        return age;
    }

    public String getInputAddress() {
        System.out.print("Enter address: ");
        String address = input.nextLine();
        return address;
    }

    public String getInputPhoneNumber() {
        System.out.print("Enter PhoneNumber: ");
        String phoneNumber = input.nextLine();
        return phoneNumber;
}

    public String checkIdExist(String id) {
        if (!customerList.containsKey(id)) {
            while (customerList.containsKey(id)) {
                System.out.println("Your Id is exist, please try other id");
                System.out.println("Ids are exist: ");
                for (Map.Entry<String, Customer> entry : customerList.entrySet()) {
                    String key = entry.getKey();
                    System.out.print(key + " ");
                }
                System.out.println();
                id = customerIdGenerator();
            }
        }
        return id;
    }

    public String customerIdGenerator(){
        IdGenerator generator = new IdGenerator();
        System.out.println("Please enter package's initial");
        Scanner input = new Scanner(System.in);
        String prefixInput = input.nextLine();
        String suffixInput = generator.generateSuffix();
        generator.init(prefixInput, suffixInput, 1);
        String customerId = generator.generate();
        System.out.println(customerId);
        return customerId;
    }
    public void addNewCustomer() {

        String customerId = customerIdGenerator();

        System.out.println("Please enter new Customer's information");
        customerId = checkIdExist(customerId);

        String name = getInputName();
        String gender = getInputGender();
        String petId = getInputPetId();
        int age = getInputAge();
        String address = getInputAddress();
        String phoneNumber = getInputPhoneNumber();
        Customer newCustomer = new Customer(customerId, name, gender, petId, age, address, phoneNumber);

        CustomerManagement.getCustomerMagagement().add(customerId, newCustomer);
//        for (Map.Entry<String, Customer> entry : customerList.entrySet()) {
//            System.out.println(entry);
//        }
        System.out.println("New customer added: " + newCustomer);
    }

    public void removeCustomer() {
         String removedId;
        System.out.println("Enter customer's id: ");
        removedId = input.nextLine();

        if (customerList.containsKey(removedId)) {
            System.out.println("Are you sure? (Y/N)");
            String isSure = input.nextLine().trim().toLowerCase();
            if(isSure.equals("y")) {
                System.out.println("Customer with id " + removedId + " is deleted");
                customerList.remove(removedId);
            }
        } else {
            System.out.println("Customer with id " + removedId + " doesn't exit");
        }
    }
    public void modifyNavigation(String action){
         if(action == "edit"){
             System.out.println();
             System.out.println("Press 1 if you want to " + action + " address");
             System.out.println("Press 2 if you want to " + action + " petId");
         }
        if(action == "search") {
            System.out.println("Press 2 if you want to " + action + " by Id");
        }

        System.out.println("Press 3 if you want to " + action + " by Name/Name");
        System.out.println("Press 4 if you want to " + action + " by PhoneNumber/PhoneNumber");
        System.out.println("Press 9 if you want to go back to main menu");
        System.out.println("Enter your choice: ");
    }

    public void searchCustomer() {
        int choice = -1;
        while(choice != 8){
            modifyNavigation("search");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 2:
                    System.out.println("Enter customer's Id: ");
                    String searchId = input.nextLine().trim();
                    System.out.println(customerManagement.searchById(searchId));
                    break;
                case 3:
                    System.out.println("Enter customer's name: ");
                    String searchName = input.nextLine().trim();
                    System.out.println(customerManagement.searchByName(searchName));
                    break;
                case 4:
                    System.out.println("Enter customer's phone number: ");
                    String searchPhoneNumber = input.nextLine().trim();
                    System.out.println(customerManagement.searchByName(searchPhoneNumber));
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


    public void editCustomer() {
        System.out.println("Enter customer's Id that you want to edit");
        String id = input.nextLine();
        Customer editCustomer = customerList.get(id);
        int choice = -1;
        if(!customerList.containsKey(id)){
            System.out.println("Customer doesn't exist");
        } else {
            while(choice != 8){
                System.out.println("Customer's info " + editCustomer);
                modifyNavigation("edit");
                choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Enter customer's address: ");
                        String editAddress = input.nextLine().trim();
                        customerManagement.editAddress(editCustomer, editAddress);
                        System.out.println("Customer's info after edit: " + customerList.get(id));
                        break;
//            case 2:
//                System.out.println("Enter customer's petId: ");
//                String editPetId = input.nextLine().trim();
//                customerManagement.editPetId(editCustomer, editPetId);
//                System.out.println("Customer's info after edit: ");
//                System.out.println(customerList.get(id));
//                break;
                    case 3:
                        System.out.println("Enter customer's name: ");
                        String editName = input.nextLine().trim();
                        customerManagement.editName(editCustomer, editName);
                        System.out.println("Customer's info after edit: " + customerList.get(id));
                        break;
                    case 4:
                        System.out.println("Enter customer's phone number: ");
                        String editPhoneNumber = input.nextLine().trim();
                        customerManagement.editPhoneNumber(editCustomer, editPhoneNumber);
                        System.out.println("Customer's info after edit: " + customerList.get(id));
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
        CustomerMenu menu = new CustomerMenu();
        menu.handleCustomerInput();
    }
        
}