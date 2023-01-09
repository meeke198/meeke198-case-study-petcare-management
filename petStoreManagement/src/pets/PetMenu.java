package pets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Scanner.*;
import customers.CustomerManagement;
import customers.IdGenerator;

public class PetMenu {
    private static void showMenuPet() {
        System.out.println("*************************************************");
        System.out.println("*           ENTER YOUR REQUEST BY NUMBER        *");
        System.out.println("*       1. Add new pet.                         *");
        System.out.println("*       2. Search pet's information.            *");
        System.out.println("*       3. Edit pet's information.              *");
        System.out.println("*       4. Remove pet.                          *");
        System.out.println("*       5. Display all pet.                     *");
        System.out.println("*       6. Return main Menu.                    *");
        System.out.println("*************************************************");
    }

    static Scanner input = new Scanner(System.in);

    PetManagement petManagement = PetManagement.getPetManagement();
    Map<String, Pet> petList = petManagement.getPetList();


    public void handlePetInput() {
        int choice = -1;

        while(choice != 8){
            showMenuPet();
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    addNewPet();
                    break;
                case 2:
                    searchPet();
                    break;
                case 3:
                    editPet();
                    break;
                case 4:
                    removePet();
                    break;
                case 5:
                    petManagement.displayAllPet();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Your choice is not on the menu :) ");
                   showMenuPet();
                    choice = 8;
                    break;
            }
        }
    }

    public String getInputName() {
        System.out.print("Enter pet's name: ");
        String name = input.nextLine();
        return name;
    }

    public String getInputOwnerId() {
        System.out.print("Enter Owner's Id: ");
        String ownerId = input.nextLine();
        return ownerId;
    }
    public String getInputBreed() {
        System.out.print("Enter breed: ");
        String breed = input.nextLine();
        return breed;
    }

     public String getInputServiceId() {
         System.out.print("Enter serviceId: ");
         String serviceId = input.nextLine();
         return serviceId;
     }

    public String getInputDescription() {
        System.out.print("Enter discription: ");
        String description =  input.nextLine();

//        nextInt khong bat su kien enter nen no se chay tiep nhung het nhung su kien
//        nextLine ke tiep, vi no ngam hieu la cung 1 line
        return description;
    }

//    public String getInputServiceHistory() {
//        System.out.print("Enter address: ");
//        String serviceHistory = input.nextLine();
//        return serviceHistory;
//    }

//    public String getInputPhoneNumber() {
//        System.out.print("Enter PhoneNumber: ");
//        String phoneNumber = input.nextLine();
//        return phoneNumber;
//    }

    public String checkIdExist(String id) {
        if (!petList.containsKey(id)) {
            while (petList.containsKey(id)) {
                System.out.println("Your Id is exist, please try other id");
                System.out.println("Ids are exist: ");
                for (Map.Entry<String, Pet> entry : petList.entrySet()) {
                    String key = entry.getKey();
                    System.out.print(key + " ");
                }
                System.out.println();
                id = petIdGenerator();
            }
        }
        return id;
    }

    public String petIdGenerator(){
        IdGenerator generator = new IdGenerator();
        System.out.println("Please enter package's initial");
        Scanner input = new Scanner(System.in);
        String prefixInput = input.nextLine();
        String suffixInput = generator.generateSuffix();
        generator.init(prefixInput, suffixInput, 1);
        String petId = generator.generate();
        System.out.println(petId);
        return petId;
    }
    public void addNewPet() {

        String petId = petIdGenerator();

        System.out.println("Please enter new Customer's information");
        petId = checkIdExist(petId);

        String name = getInputName();
        String breed = getInputBreed();
        String ownerId = getInputOwnerId();
        String description = getInputDescription();
        String serviceId = getInputServiceId();
        Pet newPet = new Pet(petId, name, breed, ownerId, serviceId, description);

        petManagement.add(petId, newPet);
//        for (Map.Entry<String, Customer> entry : customerList.entrySet()) {
//            System.out.println(entry);
//        }
        System.out.println("New pet added: " + newPet);
    }

    public void removePet() {
        String removedId;
        System.out.println("Enter pet's id: ");
        removedId = input.nextLine();

        if (petList.containsKey(removedId)) {
            System.out.println("Are you sure? (Y/N)");
            String isSure = input.nextLine().trim().toLowerCase();
            if(isSure.equals("y")) {
                System.out.println("Pet with id " + removedId + " is deleted");
               petList.remove(removedId);
            }
        } else {
            System.out.println("Pet with id " + removedId + " doesn't exit");
        }
    }
    public void modifyNavigation(String action){
        if(action == "edit"){
            System.out.println();
            System.out.println("Press 1 if you want to " + action + " description");
            System.out.println("Press 2 if you want to " + action + " service id");
        }
        if(action == "search") {
            System.out.println("Press 2 if you want to " + action + " by Id");
        }

        System.out.println("Press 3 if you want to " + action + " by Name/Name");
        System.out.println("Press 4 if you want to " + action + " by owner's Id/ owner's id");

        System.out.println("Press 9 if you want to go back to main menu");
        System.out.println("Enter your choice: ");
    }

    public void searchPet() {
        int choice = -1;
        while(choice != 8){
            modifyNavigation("search");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 2:
                    System.out.println("Enter pet's Id: ");
                    String searchId = input.nextLine().trim();
                    System.out.println(petManagement.searchByPetId(searchId));
                    break;
                case 3:
                    System.out.println("Enter pet's name: ");
                    String searchName = input.nextLine().trim();
                    System.out.println(petManagement.searchByName(searchName));
                    break;
                case 4:
                    System.out.println("Enter owner's id: ");
                    String ownerId = input.nextLine().trim();
                    System.out.println(petManagement.searchByOwnerId(ownerId));
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


    public void editPet() {
        System.out.println("Enter pet's Id that you want to edit");
        String id = input.nextLine();
        Pet editPet = petList.get(id);
        int choice = -1;
        if(!petList.containsKey(id)){
            System.out.println("Pet doesn't exist");
        } else {
            while(choice != 8){
                System.out.println("Pet's info " + editPet);
                modifyNavigation("edit");
                choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Enter new description: ");
                        String newDescription = input.nextLine().trim();
                        petManagement.editDescription(editPet, newDescription);
                        System.out.println("Pet's info after edit: " + petList.get(id));
                        break;
//            case 2:
//                System.out.println("Enter customer's petId: ");
//                String editPetId = input.nextLine().trim();
//                customerManagement.editPetId(editCustomer, editPetId);
//                System.out.println("Customer's info after edit: ");
//                System.out.println(customerList.get(id));
//                break;
                    case 3:
                        System.out.println("Enter pet's name: ");
                        String editName = input.nextLine().trim();
                       petManagement.editName(editPet, editName);
                        System.out.println("Pet's info after edit: " + petList.get(id));
                        break;
                    case 4:
                        System.out.println("Enter pet's new service id: ");
                        String newServiceId = input.nextLine().trim();
                        petManagement.editServiceId(editPet, newServiceId);
                        System.out.println("Customer's info after edit: " + petList.get(id));
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
        PetMenu menu = new PetMenu();
        menu.handlePetInput();
    }

}