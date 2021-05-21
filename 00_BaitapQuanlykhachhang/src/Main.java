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
                    customerManagement.add(customerManagement.createCustomer());
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    customerManagement.display();
                    break;
                case 6:

                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (choice>=0 && choice<=6);
    }
    static void menu(){
        System.out.println("Customer Management");
        System.out.println("1. Add customer");
        System.out.println("2. Search customer");
        System.out.println("3. Sort customer");
        System.out.println("4. Edit customer");
        System.out.println("5. Display list customer");
        System.out.println("6. Delete customer");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
    }
}
