import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CustomerManagement {
    Map<String, Customer> customerMap = null;
    Scanner scanner = new Scanner(System.in);
    Set<String> setCusIds = customerMap.keySet();

    public CustomerManagement() {
        customerMap = new HashMap<>();
    }

    public CustomerManagement(Map<String, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    public void add(Customer customer) {
        customerMap.put(customer.getCusId(), customer);
    }

    public void display() {
        for (String cusId : setCusIds) {
            System.out.println(customerMap.get(cusId));
        }
    }

    public Customer createCustomer() {
        System.out.println("Enter customer ID");
        String cusID = scanner.nextLine();
        System.out.println("Enter customer name");
        String name = scanner.nextLine();
        System.out.println("Enter customer age");
        int age = scanner.nextInt();
        int gender;
        do {
            System.out.println("Enter customer gender");
            gender = scanner.nextInt();
            if (gender != 1 && gender != 0) {
                System.out.println("Wrong input, re input (0 or 1)");
            }
            scanner.nextLine();
        } while (gender != 1 && gender != 0);
        System.out.println("Enter customer address");
        String address = scanner.nextLine();
        System.out.println("Enter customer job");
        String job = scanner.nextLine();
        String phone;
        do {
            System.out.println("Enter customer phone");
            phone = scanner.nextLine();
            if (phone.length() != 10) {
                System.out.println("Wrong input, re input (10 letter)");
            }
        } while (phone.length() != 10);
        return new Customer(cusID, name, age, gender, address, job, phone);
    }
    public Customer searchCustomer(String cusID) {
        for (String setCusID: setCusIds){
            if (setCusID.equals(cusID))
            return customerMap.get(setCusID);
        }
        return null;
    }

}
