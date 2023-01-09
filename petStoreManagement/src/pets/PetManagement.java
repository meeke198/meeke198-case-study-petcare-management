package pets;

import customers.Customer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import customers.CustomerManagement;
import customers.IdGenerator;

public final class PetManagement {
    private static PetManagement petManagement;
    private Map<String, Pet> petList;
    Map<String, Customer> customerList = CustomerManagement.getCustomerMagagement().getCustomerList();
    CustomerManagement customerManagement = CustomerManagement.getCustomerMagagement();

    private static Scanner input = new Scanner(System.in);

    private PetManagement() {
        petList = new HashMap<>();
        petList.put("PT00121",
                new Pet("PT00121", "Luo", "Golden Retriever", "CS00120", "SV00121", "This dog need shredding"));
        petList.put("PT00122",
                new Pet("PT00122", "SiPog", "Chihuahua", "CS00121", "SV00122", "This dog need shredding"));
        petList.put("PT00123", new Pet("PT00123", "Shark", "Husky", "CS00122", "SV00123", "This dog need shredding"));
        petList.put("PT00124",
                new Pet("PT00124", "Tarn", "Yorkshire Terrier", "CS00123", "SV00124", "This dog need shredding"));
        petList.put("PT00125", new Pet("PT00125", "Nos", "Dachshund", "CS00124", "SV00125", "This dog need shredding"));
        petList.put("PT00126",
                new Pet("PT00126", "Fluffy", "Shiba Inu", "CS00125", "SV00126", "This dog need shredding"));
        petList.put("PT00127", new Pet("PT00127", "Popcorn", "Poodle", "CS00126", "SV00126", "This dog need shredding"));
        petList.put("PT00128", new Pet("PT00128", "Leia", "Husky", "CS00127", "SV00122", "This dog need shredding"));
        petList.put("PT00129",
                new Pet("PT00129", "Pew", "Yorkshire Terrier", "CS00128", "SV00122", "This dog need shredding"));
//        petList.put("PT00130", new Pet("PT00130", "Nos", "Dachshund", "CS00127", "CS00120", "This dog need shredding"));
//        petList.put("PT00131",
//                new Pet("PT00131", "Candy", "Shiba Inu", "CS00128", "CS00120", "This dog need shredding"));
////        petList.put("PT00131", new Pet("PT00131", "Toah", "Poodle", "CS00128", "CS00120", "This dog need shredding"));
    }

    public static PetManagement getPetManagement() {
        synchronized (PetManagement.class) {
            if (petManagement == null) {
                petManagement = new PetManagement();
            }
        }
        return petManagement;
    }
    public Map<String, Pet> getPetList() {
        return petList;
    }

    public void displayAllPet() {
        StringBuilder text = new StringBuilder("");
        for (Map.Entry<String, Pet> entry : petList.entrySet()) {
            String key = entry.getKey();
            Pet value = entry.getValue();
            text.append( key + "  || " + value.getName() + "|| Breed: " + value.getBreed() + "|| Owner Id: "
                    + value.getOwnerId() + "|| Service id: " + value.getServiceId() + "|| Description: " + value.getDescription()+".\n");
        }
        System.out.println(text);
    }

    public static void setPetManagement(PetManagement petManagement) {
        PetManagement.petManagement = petManagement;
    }

    public void setPetList(Map<String, Pet> petList) {
        this.petList = petList;
    }

    public void add(String id, Pet newPet) {
        if (newPet != null) {
            petList.put(id, newPet);
        }
    }

    public void remove(String id) {
        petList.remove(id);
    }

    public String searchByPetId(String id) {
        return petList.get(id).toString();
    }

    public String searchByOwnerId(String ownerId) {
        Customer owner =  customerList.get(ownerId);
        String petId = owner.getPetId();
//        if(customerList.containsKey(ownerId) && petList.containsKey(petId))
        String result;
        if (petList.containsKey(petId)){
            result = petList.get(petId).toString();
        } else {
            result = "Pet doesn't exist";
        }
        return result;
    }

    public StringBuilder searchByName(String name) {
        StringBuilder searchResult = new StringBuilder();
        for (Map.Entry<String, Pet> entry : petList.entrySet()) {
            String key = entry.getKey();
            Pet value = entry.getValue();
            if (name.equals(value.getName())) {
                searchResult.append(petList.get(key).toString());
            }
        }
        if(searchResult.isEmpty()){
            searchResult.append("Pet doesn't exist");
        }
        return searchResult;
    }

    public void editName(Pet pet, String newName) {
        pet.setName(newName);
    }
    public void editOwnerId(Pet pet, String newOwnerId) {
        pet.setOwnerId(newOwnerId);
    }

    public void editDescription(Pet pet, String newDesription) {
        pet.setName(newDesription);
    }

    public void editServiceId(Pet pet, String newServiceId) {
        pet.setName(newServiceId);
    }

    public static void main(String[] args) {
        PetManagement pet = new PetManagement();
        pet.searchByOwnerId("CS00128");
    }
}
