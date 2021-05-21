import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OfficierManager list = new OfficierManager();
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 0 || choice > 6) {
                System.out.println("Wrong choice, re input (0-6):");
            } else {
                switch (choice) {
                    case 1:
                        int option;
                        do {
                            showMenuOfficier();
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
                                showMenuOfficier();
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

        } while (choice >= 0 && choice <= 6);
    }

    static void showMenu() {
        System.out.println("-------------MENU---------------");
        System.out.println("1. Add Officier:");
        System.out.println("2. Search by name:");
        System.out.println("3. Edit by name:");
        System.out.println("4. Display:");
        System.out.println("5. Sort by name:");
        System.out.println("6. Delete by name");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
    }

    static void showMenuOfficier() {
        System.out.println("1. Worker");
        System.out.println("2. Engineer");
        System.out.println("3. Staff");
        System.out.println("Enter option:");
    }

}
