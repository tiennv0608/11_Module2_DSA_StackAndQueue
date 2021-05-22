import java.util.*;


public class CustomerManagement {
    Map<String, Customer> customerMap = null;
    Scanner scanner = new Scanner(System.in);
    Set<String> keys = null;

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
        keys = customerMap.keySet();
        for (String cusId : keys) {
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
        keys = customerMap.keySet();
        for (String key : keys) {
            if (key.equals(cusID))
                return customerMap.get(key);
        }
        return null;
    }

    public void sortByName() {
        List<Map.Entry<String, Customer>> lists = new LinkedList(customerMap.entrySet());
        Collections.sort(lists, new Comparator<Map.Entry<String, Customer>>() {
            @Override
            public int compare(Map.Entry<String, Customer> customer1, Map.Entry<String, Customer> customer2) {
                return customer1.getValue().getName().compareTo(customer2.getValue().getName());
            }
        });
        Map<String, Customer> listCustomer = new LinkedHashMap<>();
        for (Map.Entry<String, Customer> list : lists) {
            listCustomer.put(list.getKey(), list.getValue());
        }
        this.customerMap = listCustomer;
    }

    public void editInformation(Customer customer) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        if (!name.equals("")) {
            customer.setName(name);
        }
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        if (age > 0 && age <= 100) {
            customer.setAge(age);
        }
        int gender;
        do {
            System.out.println("Enter gender (0-1):");
            gender = scanner.nextInt();
            if (gender == 1 || gender == 0) {
                customer.setGender(gender);
            } else {
                System.out.println("Wrong input, re input");
            }
        } while (gender != 1 && gender != 0);
        scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        if (!address.equals("")) {
            customer.setAddress(address);
        }
        System.out.println("Enter job");
        String job = scanner.nextLine();
        if (!job.equals("")) {
            customer.setJob(job);
        }
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        if (!phone.equals("")) {
            if (phone.length() < 10) {
                System.out.println("Number phone too short, re input (10 numbers):");
            } else if (phone.length() > 10) {
                System.out.println("Number phone too long, re input (10 numbers):");
            } else {
                customer.setPhone(phone);
            }
        }
    }
    public void deleteCustomerByID(){
        System.out.println("Enter customer ID:");
        String cusId = scanner.nextLine();
        Customer customer = searchCustomer(cusId);
        if (customer==null){
            System.out.println("No information!");
        } else {
            customerMap.remove(cusId);
        }
    }
}
