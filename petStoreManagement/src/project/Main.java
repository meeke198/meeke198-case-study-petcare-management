package project;

import customers.CustomerMenu;
import pets.PetMenu;
import services.ServiceMenu;

public class Main {
    public static void main(String[] args) {
        new CustomerMenu().handleCustomerInput();
        new PetMenu().handlePetInput();
        new ServiceMenu().handleServiceInput();
    }
}