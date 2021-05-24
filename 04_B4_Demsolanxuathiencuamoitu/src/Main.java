import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi muốn kiểm tra các từ lặp lại: ");
        String string = scanner.nextLine();

        String[] listChart = string.split(" +");

        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str : listChart) {
            str = str.toLowerCase();
            if (map.containsKey(str)){
                int plus = map.get(str)+1;
                map.put(str, plus);
            }else{
                map.put(str, 1);
            }
        }
        map.forEach((key, value)->{
            System.out.println(key + ": " + value);
        });
    }
}