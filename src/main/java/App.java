import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    Map<Integer, WiseSaying> wsRepo;
    private Scanner sc;
    WiseSaying wiseSaying;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run() {
        wsRepo = new HashMap<>();
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
                    wsRepo.put(id, wiseSaying);
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    id++;
                    break;
                case "목록":
                    for (Integer wsId : wsRepo.keySet()) {
                        System.out.println(wsId + " / " + wsRepo.get(wsId).getAuthor() + " / " + wsRepo.get(wsId).getContent());
                    }
                    id++;
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}