import java.util.Scanner;

public class App {

    public App() {

    }

    public void run() {
        String str1 = "안녕";
        String str2 = "안녕";
        System.out.println(str1 == str2); // true
        str1 += "1";
        str2 = "안녕1";
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // true
    }
}