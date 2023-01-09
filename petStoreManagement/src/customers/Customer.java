package customers;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import customers.IdGenerator;

public class Customer {
    private String id;
    private String gender;
    private String petId;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    public Customer (){

    }

    public void setAge(int age) {
        this.age = age;
    }
  

    /**
     * @param id
     * @param name
     * @param gender
     * @param age
     * @param address
     * @param phoneNumber
     */
    public Customer (String id, String name, String gender, String petId, int age,
                     String address, String phoneNumber){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.petId = petId;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public int getAge(){
        return this.age;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public void setAddress(String newAddress){
        this.address = newAddress;

    }
    public void setAge(byte newAge){
        this.age = newAge;
    }
    public void setPhoneNumber(String newPhoneNumber){

        this.phoneNumber = newPhoneNumber;
    }
//    public void addPetId(String newPetId){
//        this.petId = newPetId;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", petId=" + petId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }


}
