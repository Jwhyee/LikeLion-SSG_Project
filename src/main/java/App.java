import java.util.Scanner;

public class App {
    private Scanner sc;
    WiseSaying wiseSaying;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");
        int id = 1;
        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            switch (cmd) {
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    wiseSaying = new WiseSaying(id, author, content);
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    id++;
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}