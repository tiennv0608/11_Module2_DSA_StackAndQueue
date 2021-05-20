import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OfficierManager list = new OfficierManager();
        Officier officier1 = new Worker("Như Anh",20,"Nam","TB",10);
        Officier officier2 = new Engineer("Hiệu",30,"Nam","HN","IT");
        Officier officier3 = new Staff("Linh",25,"Nữ","ND","Sales");
        list.add(officier1);
        list.add(officier2);
        list.add(officier3);
        list.display();
        System.out.println(list.searchByName("Hiệu"));
        list.deleteByName("Như Anh");
        list.display();

    }
}
