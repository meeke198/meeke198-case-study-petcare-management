package customers;
import java.util.Scanner;
import customers.CustomerManagement;
import customers.IdGenerator;
public class CustomerMenu {
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

//    public static void handleCustomerInput() {
//        int choice = -1;
//        while (choice != 7) {
//            showMenuPersonnel();
//            System.out.print("Enter your choice: ");
//            choice = input.nextInt();
//            input.nextLine();
//            switch (choice) {
//                case 1:
//                    CustomerManagement.getCustomerManagement().addNewCustomer();
//                    break;
//                case 2:  CustomerManagement.getCustomerManagement().searchCustomer();
////                    break;
//                case 3: CustomerManagement.getCustomerManagement().editCustomer();
//                    break;
//                case 4: CustomerManagement.getCustomerManagement().displayVisitHistory();
//                    break;
//                case 5: CustomerManagement.getCustomerManagement().displayAllCustomer();
//                    break;
//                case 7:
//                    break;
//            }
//        }
//    }

//    public static void main(String[] args) {
//        showMenuPersonnel();
//
//    }
}