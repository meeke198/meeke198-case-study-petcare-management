package customers;

import java.util.Map;
import java.util.Scanner;
import java.util.Scanner.*;
import customers.CustomerManagement;
import customers.IdGenerator;

public class CustomerMenu {
    Map<String, Customer> CustomerList = CustomerManagement.getCustomerMagagement().getCustomerList();
    private static void showMenuPersonnel() {
        System.out.println("*************************************************");
        System.out.println("*           ENTER YOUR REQUEST BY NUMBER        *");
        System.out.println("*       1. Add new customer.                    *");
        System.out.println("*       2. Search customer's information.       *");
        System.out.println("*       3. Edit customer's information.         *");
        System.out.println("*       4. Display history.                     *");
        System.out.println("*       5. Display all customer.                *");
        System.out.println("*       6. Return main Menu.                    *");
        System.out.println("*************************************************");
    }

    static Scanner input = new Scanner(System.in);

    // public static void handleCustomerInput() {
    // int choice = -1;
    // while (choice != 7) {
    // showMenuPersonnel();
    // System.out.print("Enter your choice: ");
    // choice = input.nextInt();
    // input.nextLine();
    // switch (choice) {
    // case 1:
    // CustomerManagement.getCustomerManagement().addNewCustomer();
    // break;
    // case 2: CustomerManagement.getCustomerManagement().searchCustomer();
    //// break;
    // case 3: CustomerManagement.getCustomerManagement().editCustomer();
    // break;
    // case 4: CustomerManagement.getCustomerManagement().displayVisitHistory();
    // break;
    // case 5: CustomerManagement.getCustomerManagement().displayAllCustomer();
    // break;
    // case 7:
    // break;
    // }
    // }
    // }

    // public static void main(String[] args) {
    // showMenuPersonnel();
    //
    // }

    public String getInputName() {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        return name;
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
        return age;
    }

    public String getInputAddress() {
        System.out.print("Enter address: ");
        String address = input.nextLine();
        return address;
    }

    public String getInputPhoneNumber() {
        System.out.print("Enter address: ");
        String address = input.nextLine();
        return address;
    }

    public String checkIdExist(String id) {
        if (!CustomerList.containsKey(id)) {
            while (CustomerList.containsKey(id)) {
                System.out.println("Your Id is exist, please try other id");
                System.out.println("Ids are exist: ");
                for (Map.Entry<String, Customer> entry : CustomerList.entrySet()) {
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
        return customerId;
    }
    public void addNewCustomer() {

        String customerId = customerIdGenerator();

        System.out.println("Please enter new Customer's information");
        customerId = checkIdExist(customerId);

        String name = getInputName();
        String gender = getInputGender();
        int age = getInputAge();
        String address = getInputAddress();
        String phoneNumber = getInputPhoneNumber();
        Customer newCustomer = new Customer(customerId, name, gender, age, address, phoneNumber);

        CustomerList.put(customerId, newCustomer);
        // for (Department el : listDepart) {
        //     if (el.getName().equals(department)) {
        //         el.setAmount(el.getAmount() + 1);
        //     }
        // }
    }

    public static void main(String[] args) {
        CustomerMenu menu = new CustomerMenu();
        showMenuPersonnel();
        menu.addNewCustomer();
    }

    
        
}