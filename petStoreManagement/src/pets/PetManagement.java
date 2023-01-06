package pets;

import customers.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class PetManagement<K, V> {
    private static volatile PetManagement departmentManagement;
    private static PetManagement petManagement;
    private Map<String, Pet> PetList;
    // public int generateId() {
    // Integer min = 1; // Giá trị nhỏ nhất
    // Integer max = 1000; // Giá trị lớn nhất
    //
    // Integer randomNumber = min + (int)(Math.random() * ((max - min) + 1));
    //// while (PetList.containsKey(randomNumber)){
    //// randomNumber = min + (int)(Math.random() * ((max - min) + 1));
    //// }
    // return randomNumber;
    // }
    private static Scanner input = new Scanner(System.in);

    private PetManagement() {
        PetList = new HashMap<>();
        PetList.put("PT00121",
                new Pet("PT00121", "Luo", "Golden Retriever", "CS00120", "CS00120", "This dog need shredding"));
        PetList.put("PT00122",
                new Pet("PT00122", "SiPog", "Chihuahua", "CS00120", "CS00120", "This dog need shredding"));
        PetList.put("PT00123", new Pet("PT00123", "Huei", "Husky", "CS00120", "CS00120", "This dog need shredding"));
        PetList.put("PT00124",
                new Pet("PT00124", "Tarn", "Yorkshire Terrier", "CS00120", "CS00120", "This dog need shredding"));
        PetList.put("PT00125", new Pet("PT00125", "Nos", "Dachshund", "CS00120", "CS00120", "This dog need shredding"));
        PetList.put("PT00126",
                new Pet("PT00126", "Hein", "Shiba Inu", "CS00120", "CS00120", "This dog need shredding"));
        PetList.put("PT00127", new Pet("PT00127", "Toah", "Poodle", "CS00120", "CS00120", "This dog need shredding"));
    }

    public static PetManagement getPetManagement() {
        synchronized (PetManagement.class) {
            if (petManagement == null) {
                PetManagement petManagement = new PetManagement();
            }
        }
        return petManagement;
    }

    public void add(String id, Pet newPet) {
        if (newPet != null) {
            PetList.put(id, newPet);
        }
    }

    public void remove(String id) {
        PetList.remove(id);
    }

    public String searchById(String id) {
        return PetList.get(id).toString();
    }

    public StringBuilder searchByName(String name) {
        StringBuilder searchResult = new StringBuilder();
        for (Map.Entry<String, Pet> entry : PetList.entrySet()) {
            String key = entry.getKey();
            Pet value = entry.getValue();
            if (name.equals(value.getName())) {
                searchResult.append(PetList.get(name));
            }
        }
        return searchResult;
    }

    public void editName(Pet pet, String newName) {
        pet.setName(newName);
    }

    public void editDescription(Pet pet, String newDesription) {
        pet.setName(newDesription);
    }

    public void editServiceId(Pet pet, String newServiceId) {
        pet.setName(newServiceId);
    }

}
