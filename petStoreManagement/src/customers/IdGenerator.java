package customers;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Scanner;
import customers.Customer;

public class IdGenerator {
    private String prefix;
    private String suffix;
    private AtomicInteger lastId = new AtomicInteger(0);
    private AtomicInteger id;

    public IdGenerator() {
        this.id = new AtomicInteger();
        this.prefix = "";
        this.suffix = "";
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public AtomicInteger getLastId() {
        return lastId;
    }

    public void setLastId(AtomicInteger lastId) {
        this.lastId = lastId;
    }

    public AtomicInteger getId() {
        return id;
    }

    public void setId(AtomicInteger id) {
        this.id = id;
    }

    public void init(String prefix, String suffix, int lastId) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.lastId.set(lastId);
    }

    public String generate() {
        return this.prefix + this.lastId.incrementAndGet() + this.suffix;
    }

    public String generateSuffix() {
        Integer min = 10; // Giá trị nhỏ nhất
        Integer max = 99; // Giá trị lớn nhất
        Integer randomNumber = min + (int) (Math.random() * ((max - min) + 1));
        return randomNumber.toString();
    }

    // public static void main(String[] args) {
    // IdGenerator generator = new IdGenerator();
    // System.out.println("Please enter new customer's initial name");
    // Scanner input = new Scanner(System.in);
    // String prefixInput = input.nextLine();
    // String suffixInput = generator.generateSuffix();
    // generator.setPrefix(prefixInput);
    // generator.init(prefixInput, suffixInput, 1);
    // String id = generator.generate();
    // Customer sv = new Customer(id);
    // System.out.println(sv.getId());
    // }
}