import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManagement customerManagement = new CustomerManagement();

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
    }
}
