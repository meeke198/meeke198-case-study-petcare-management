package services;

// import customers.Customer;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public final class ServiceManagement {

    private static volatile ServiceManagement departmentManagement;
    private static ServiceManagement serviceManagement;
    private Map<String, Service> ServiceList;
    
    public static ServiceManagement getServiceManagement() {

        synchronized (ServiceManagement.class) {
            if (serviceManagement == null) {
                serviceManagement = new ServiceManagement();
            }
        }
        return serviceManagement;
    }

    private static Scanner input = new Scanner(System.in);

    private ServiceManagement() {
        ServiceList = new HashMap<>();
        ServiceList.put("SV00121", new Service("SV00121", "Shred", 20, "30 mins shredding cost"));
        ServiceList.put("SV00122", new Service("SV00122", "Groom", 20, "30 mins grooming cost"));
        ServiceList.put("SV00123", new Service("SV00123", "Massage", 20, "30 mins full body massage cost"));
        ServiceList.put("SV00124", new Service("SV00124", "Pedicure", 20, "30 mins peducure cost"));
        ServiceList.put("SV00125", new Service("SV00125", "Dental", 20, "30 mins full dental package cost, X-ray included"));
        ServiceList.put("SV00126", new Service("SV00126", "General Exam", 20, "30 mins shredding cost"));

    }

    public void add(String id, Service newService) {
        if (newService != null) {
            ServiceList.put(id, newService);
        }
    }

    public void remove(String id) {
        ServiceList.remove(id);
    }

    public String searchById(String id) {
        return ServiceList.get(id).toString();
    }

    public String searchByName(String serviceName) {
        for (Map.Entry<String, Service> entry : ServiceList.entrySet()) {
            String key = entry.getKey();
            Service value = entry.getValue();
            if (serviceName.equals(value.getServiceName())) {
                return ServiceList.get(key).toString();
            }
        }
        return null;
    }

    public StringBuilder researchByName(String name) {
        StringBuilder result = new StringBuilder("");
        for (Map.Entry<String, Service> entry : ServiceList.entrySet()) {
            String key = entry.getKey();
            Service value = entry.getValue();
            if (name.equals(value.getServiceName())) {
                result.append(ServiceList.get(key).toString());
            }
        }
        return result;
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
