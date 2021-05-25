import java.util.*;

public class CustomerManagement {
    Map<String, Customer> customerMap;
    Scanner scanner = new Scanner(System.in);
    Set<String> keys = null;
    List<Customer> customerList = null;

    public CustomerManagement() {
        customerMap = new HashMap<>();
    }

    public void add() {
        Customer customer = createCustomer();
        customerMap.put(customer.getCusId(), customer);
    }

    public void display() {
        keys = customerMap.keySet();
        for (String key : keys) {
            System.out.println(customerMap.get(key));
        }
    }

    public void displayCustomerList() {
        for (Customer customer : customerList) {
            System.out.println(customer);
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
            System.out.println("Enter customer gender (0.Female/1.Male)");
            gender = scanner.nextInt();
            if (gender != 1 && gender != 0) {
                System.out.println("Wrong input, re input (0.Female/1.Male)");
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

    public List<Customer> searchCustomerByName(String name) {
        keys = customerMap.keySet();
        customerList = new LinkedList<>();
        for (String key : keys) {
            if (customerMap.get(key).getName().equals(name)) {
                customerList.add(customerMap.get(key));
            }
        }
        if (customerList.size() != 0)
            return customerList;
        return null;
    }

    public List<Customer> searchCustomerByAge(int age) {
        keys = customerMap.keySet();
        customerList = new LinkedList<>();
        for (String key : keys) {
            if (customerMap.get(key).getAge() == age) {
                customerList.add(customerMap.get(key));
            }
        }
        if (customerList.size() != 0)
            return customerList;
        return null;
    }

    public List<Customer> searchCustomerByGender(int gender) {
        keys = customerMap.keySet();
        customerList = new LinkedList<>();
        for (String key : keys) {
            if (customerMap.get(key).getAge() == gender) {
                customerList.add(customerMap.get(key));
            }
        }
        if (customerList.size() != 0)
            return customerList;
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

    public void editName(Customer customer) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        if (!name.equals("")) {
            customer.setName(name);
        }
    }

    public void editAge(Customer customer) {
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age > 0 && age <= 100) {
            customer.setAge(age);
        }
    }

    public void editGender(Customer customer) {
        int gender;
        do {
            System.out.println("Enter gender (0.Female/1.Male):");
            gender = scanner.nextInt();
            if (gender == 1 || gender == 0) {
                customer.setGender(gender);
            } else {
                System.out.println("Wrong input, re input");
            }
        } while (gender != 1 && gender != 0);
        scanner.nextLine();
    }

    public void editAddress(Customer customer) {
        System.out.println("Enter address");
        String address = scanner.nextLine();
        if (!address.equals("")) {
            customer.setAddress(address);
        }
    }

    public void editJob(Customer customer) {
        System.out.println("Enter job");
        String job = scanner.nextLine();
        if (!job.equals("")) {
            customer.setJob(job);
        }
    }

    public void editPhone(Customer customer) {
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

    public void editInformation(Customer customer) {
        editName(customer);
        editAge(customer);
        editGender(customer);
        editAddress(customer);
        editJob(customer);
        editPhone(customer);
    }

    public void deleteCustomerByID() {
        System.out.println("Enter customer ID:");
        String cusId = scanner.nextLine();
        Customer customer = searchCustomer(cusId);
        if (customer == null) {
            System.out.println("No information!");
        } else {
            customerMap.remove(cusId);
        }
    }

}
