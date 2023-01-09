package services;

// import customers.Customer;

import customers.Customer;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public final class ServiceManagement {

    private static ServiceManagement serviceManagement;
    private Map<String, Service> serviceList;
    
    public static ServiceManagement getServiceManagement() {
        synchronized (ServiceManagement.class) {
            if (serviceManagement == null) {
                serviceManagement = new ServiceManagement();
            }
        }
        return serviceManagement;
    }

//    private static Scanner input = new Scanner(System.in);

    private ServiceManagement() {
        serviceList = new HashMap<>();
        serviceList.put("SV00121", new Service("SV00121", "Shred", 20, "30 mins shredding cost"));
        serviceList.put("SV00122", new Service("SV00122", "Groom", 20, "30 mins grooming cost"));
        serviceList.put("SV00123", new Service("SV00123", "Massage", 20, "30 mins full body massage cost"));
        serviceList.put("SV00124", new Service("SV00124", "Pedicure", 20, "30 mins peducure cost"));
        serviceList.put("SV00125", new Service("SV00125", "Dental", 20, "30 mins full dental package cost, X-ray included"));
        serviceList.put("SV00126", new Service("SV00126", "General Exam", 20, "30 mins shredding cost"));

    }

    public void add(String id, Service newService) {
        if (newService != null) {
            serviceList.put(id, newService);
        }
    }

    public static void setServiceManagement(ServiceManagement serviceManagement) {
        ServiceManagement.serviceManagement = serviceManagement;
    }

    public Map<String, Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(Map<String, Service> serviceList) {
        this.serviceList = serviceList;
    }

    public void removeService(String id) {
        serviceList.remove(id);
    }

    public String searchById(String id) {
        return serviceList.get(id).toString();
    }

    public String searchByName(String serviceName) {
        for (Map.Entry<String, Service> entry : serviceList.entrySet()) {
            String key = entry.getKey();
            Service value = entry.getValue();
            if (serviceName.equals(value.getServiceName())) {
                return serviceList.get(key).toString();
            }
        }
        return null;
    }
    public void displayAllService() {
        StringBuilder text = new StringBuilder("");
        for (Map.Entry<String, Service> entry : serviceList.entrySet()) {
            String key = entry.getKey();
            Service value = entry.getValue();
            text.append( key + "  || " + value.getServiceName() + "|| Price: " + value.getPrice() + "|| Description: " + value.getDescription()+".\n");
        }
        System.out.println(text);
    }

    public void editName(Service service, String newServiceName) {
        service.setServiceName(newServiceName);
    }

    public void editDescription(Service service, String newDescription) {
        service.setDescription(newDescription);
    }

    public void editPrice(Service service, float newPrice) {
        service.setPrice(newPrice);
    }

}
