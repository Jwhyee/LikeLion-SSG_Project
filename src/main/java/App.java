import java.util.*;

public class App {
    List<WiseSaying> wsRepo;
    private Scanner sc;
    WiseSaying wiseSaying;
    Rq rq;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run() {
        wsRepo = new ArrayList<>();
        System.out.println("== 명언 SSG ==");
        int id = 1;

        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            rq = new Rq(cmd);
            switch (cmd) {
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    wiseSaying = new WiseSaying(id, author, content);
                    wsRepo.add(wiseSaying);
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    id++;
                    break;
                case "목록":
                    for (WiseSaying saying : wsRepo) {
                        System.out.println(saying.getId() + " / " + saying.getAuthor() + " / " + saying.getContent());
                    }
                    id++;
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}