import java.util.Scanner;

public class App {
    private Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            String cmd = sc.nextLine();
            switch (cmd) {
                case "종료":
                    break outer;
            }
        }
    }
}