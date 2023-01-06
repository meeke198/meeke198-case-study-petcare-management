package services;

public class Service {
    private String serviceId;
    private String serviceName;
    private float price;
    private String description;

    public Service() {

    }

    public Service(String serviceId, String serviceName,
            float price, String description) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public float getPrice() {
        return this.price;
    }

    public void setServiceId(String newServiceId) {
        this.serviceId = newServiceId;
    }

    public void setServiceName(String newServiceName) {
        this.serviceName = newServiceName;

    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
