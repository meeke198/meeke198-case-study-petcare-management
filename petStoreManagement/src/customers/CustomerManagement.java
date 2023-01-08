package customers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import customers.IdGenerator;

public final class CustomerManagement<K, V> {
    // private static volatile CustomerManagement departmentManagement;
    // tạo 1 biến static để lưu object duy nhất tạo ra bên trong lớp
    private static CustomerManagement customerManagement;
    private Map<String, Customer> customersList;
    

    // private constructor để không tạo object được từ bên ngoài lớp
    private CustomerManagement() {
        customersList = new HashMap<>();
        customersList.put("CS00120", new Customer("CS00120", "Luong", "Gay kín", 21,
                "21k Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "0123456789"));
        customersList.put("CS00121", new Customer("CS00121", "Hieu", "Queer", 16,
                "21h Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "0123456788"));
        customersList.put("CS00122", new Customer("CS00122", "Phong Xoan", "Bisexual", 11,
                "21f Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "0123456787"));
        customersList.put("CS00123", new Customer("CS00123", "Hien", "Female", 32,
                "21e Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "0123456786"));
        customersList.put("CS00124", new Customer("CS00124", "Vu", "Male", 15,
                "21d Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "0123456787"));
        customersList.put("CS00125", new Customer("CS00125", "Tung", "Male", 15,
                "21c Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "0123456786"));
        customersList.put("CS00126", new Customer("CS00126", "Minh", "Queer", 3,
                "21b Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "0123456785"));
        customersList.put("CS00127", new Customer("CS00127", "Tran", "Female", 18,
                "21a Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "0123456784"));
        customersList.put("CS00128", new Customer("CS00128", "Si Phong", "Linh động", 20,
                "21k Nguyễn Văn Trỗi, P. 10, Phú Nhuận, Tp.HCM", "012345678"));
    }

    // do constructor đã private rồi nên không tạo được object bên ngoài
    // nên phải tạo getCustomerManagement và new mới 1 instance phía bên trong
    // tuy nhiên nếu để public hàm này thì bên ngoài có thể gọi và tạo mới được
    // nên phải để static
    public static CustomerManagement getCustomerMagagement() {

        synchronized (CustomerManagement.class) {
            if (customerManagement == null) {
                customerManagement = new CustomerManagement();
            }
        }
        return customerManagement;
    }

    public Map<String, Customer> getCustomerList() {
        return customersList;
    }

    // public static Map setCustomerList(Map newCustomerList) {
    //     this.customersList = newCustomerList;
    // }

    public void add(String id, Customer newCustomer) {
        if (newCustomer != null) {
            customersList.put(id, newCustomer);
        }
    }

    public void remove(String id) {
        customersList.remove(id);
    }

    public String searchById(String id) {
        return customersList.get(id).toString();
    }

    public StringBuilder searchByPhoneNumber(String phoneNumber) {
        StringBuilder result = new StringBuilder("");
        for (Map.Entry<String, Customer> entry : customersList.entrySet()) {
            String key = entry.getKey();
            Customer value = entry.getValue();
            if (phoneNumber.equals(value.getPhoneNumber())) {
                result.append(customersList.get(key).toString());
            }
        }
        return result;
    }

    public StringBuilder researchByName(String name) {
        StringBuilder result = new StringBuilder("");
        for (Map.Entry<String, Customer> entry : customersList.entrySet()) {
            String key = entry.getKey();
            Customer value = entry.getValue();
            if (name.equals(value.getName())) {
                result.append(customersList.get(key).toString());
            }
        }
        return result;
    }

    public void editName(Customer customer, String newName) {
        customer.setName(newName);
    }

    public void editPhoneNumber(Customer customer, String newNumber) {
        customer.setPhoneNumber(newNumber);
    }

    public void editAddress(Customer customer, String newAddress) {
        customer.setAddress(newAddress);
    }

    public void editPetId(Customer customer, List <String> newPetId) {
        customer.setPetId(newPetId);
    }

}
