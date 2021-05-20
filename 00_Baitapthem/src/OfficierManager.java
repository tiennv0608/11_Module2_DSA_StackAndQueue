import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class OfficierManager {
    private ArrayList<Officier> list;

    public OfficierManager() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Officier> getList() {
        return list;
    }

    public void setList(ArrayList<Officier> list) {
        this.list = list;
    }

    public void display() {
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i));
        }
        System.out.println("----------------------");
    }

    public void add(Officier officier) {
        this.list.add(officier);
    }

    public int searchByName(String name) {
        for (int i = 0; i < this.list.size(); i++) {
            if ((this.list.get(i).getName().equals(name))) {
                return i;
            }
        }
        return -1;
    }

    public void editByName(String name, Officier officier) {
        int index = searchByName(name);
        if (index == -1) {
            System.out.println("Khong tim thay nhan vien trong danh sach");
        } else {
            this.list.set(index, officier);
        }
    }
    public void deleteByName(String name){
        int index = searchByName(name);
        if (index == -1) {
            System.out.println("No officier!");
        } else {
            this.list.remove(index);
        }
    }

    public void sortByName(){
        Collections.sort(this.list, new Comparator<Officier>() {
            @Override
            public int compare(Officier officier1, Officier officier2) {
                return officier1.getName().compareTo(officier2.getName());
            }
        });
    }
}
