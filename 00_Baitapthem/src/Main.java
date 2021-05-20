import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OfficierManager list = new OfficierManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            list.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 0 || choice > 6) {
                System.out.println("Wrong choice, re input (0-6):");
            } else {
                switch (choice) {
                    case 1:
                        int option;
                        do {
                            list.showMenuOfficier();
                            option = scanner.nextInt();
                            scanner.nextLine();
                            if (option < 1 || option > 3) {
                                System.out.println("Wrong option, re input (1-3):");
                            }
                        } while (option < 1 || option > 3);
                        Officier officier = list.createOfficier(option);
                        list.add(officier);
                        break;
                    case 2:
                        System.out.println("Enter name you want to search:");
                        String name = scanner.nextLine();
                        int index = list.searchByName(name);
                        if (index == -1) {
                            System.out.println("There is no officier in the list!");
                        } else {
                            System.out.println(list.getList().get(index));
                        }
                        break;
                    case 3:
                        System.out.println("Enter name you want to edit:");
                        name = scanner.nextLine();
                        index = list.searchByName(name);
                        if (index == -1) {
                            System.out.println("There is no officier in the list!");
                        } else {
                            do {
                                System.out.println("Position you want to edit");
                                list.showMenuOfficier();
                                option = scanner.nextInt();
                                scanner.nextLine();
                                if (option < 1 || option > 3) {
                                    System.out.println("Wrong option, re input (1-3):");
                                }
                            } while (option < 1 || option > 3);
                            officier = list.createOfficier(option);
                            list.editByName(name, officier);
                        }
                        break;
                    case 4:
                        list.display();
                        break;
                    case 5:
                        list.sortByName();
                        break;
                    case 6:
                        System.out.println("Enter name you want to delete:");
                        name = scanner.nextLine();
                        list.deleteByName(name);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
            }
        }

    }
}
