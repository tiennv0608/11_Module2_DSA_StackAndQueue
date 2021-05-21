import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class OfficierManager {
    ArrayList<Officier> list;
    Scanner scanner = new Scanner(System.in);

    public OfficierManager() {
        list = new ArrayList<>();
    }

    public ArrayList<Officier> getList() {
        return list;
    }

    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------------");
    }

    public void add(Officier officier) {
        list.add(officier);
    }

    public int searchByName(String name) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getName().equals(name))) {
                return i;
            }
        }
        return -1;
    }

    public void editByName(String name, Officier officier) {
        int index = searchByName(name);
        if (index == -1) {
            System.out.println("There is no officier in the list!");
        } else {
            list.set(index, officier);
        }
    }

    public void deleteByName(String name) {
        int index = searchByName(name);
        if (index == -1) {
            System.out.println("There is no officier in the list!");
        } else {
            list.remove(index);
        }
    }

    public void sortByName() {
        Collections.sort(list, new Comparator<Officier>() {
            @Override
            public int compare(Officier officier1, Officier officier2) {
                return officier1.getName().compareTo(officier2.getName());
            }
        });
    }

    public Officier createOfficier(int number) {
        Officier officier;
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        if (number == 1) {
            int level;
            do {
                System.out.println("Enter level (1-10):");
                level = scanner.nextInt();
                scanner.nextLine();
            } while (level < 1 || level > 10);
            officier = new Worker(name, age, gender, address, level);
        } else if (number == 2) {
            System.out.println("Enter specialize:");
            String specialize = scanner.nextLine();
            officier = new Engineer(name, age, gender, address, specialize);
        } else {
            System.out.println("Enter job:");
            String job = scanner.nextLine();
            officier = new Staff(name, age, gender, address, job);
        }
        return officier;
    }
}
