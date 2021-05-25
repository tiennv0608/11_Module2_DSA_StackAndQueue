import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManagement customerManagement = new CustomerManagement();
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    customerManagement.add();
                    break;
                case 2:
                    System.out.println("Enter customer ID");
                    String cusID = scanner.nextLine();
                    List<Customer> customerList = customerManagement.searchCustomerByName(cusID);
                    if (customerList == null){
                        System.out.println("There is no customer in the list");
                    } else {
                        customerManagement.displayCustomerList();
                    }
                    break;
                case 3:
                    customerManagement.sortByName();
                    break;
                case 4:
                    System.out.println("Enter ID:");
                    cusID = scanner.nextLine();
                    Customer customer = customerManagement.searchCustomer(cusID);
                    if (customer == null){
                        System.out.println("There is no customer in the list");
                    } else {
                        customerManagement.editInformation(customer);
                    }
                    break;
                case 5:
                    customerManagement.display();
                    break;
                case 6:
                    customerManagement.deleteCustomerByID();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input, re input (0-6):");
            }
        } while (true);
    }
    static void menu(){
        System.out.println("Customer Management");
        System.out.println("1. Add customer");
        System.out.println("2. Search customer by ID");
        System.out.println("3. Sort customer by name");
        System.out.println("4. Edit customer by ID");
        System.out.println("5. Display list customer");
        System.out.println("6. Delete customer");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
    }
}
