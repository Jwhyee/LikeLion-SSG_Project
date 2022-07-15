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
        int wiseSayingLastId = 0;

        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            rq = new Rq(cmd);
            switch (rq.getPath()) {
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    int id = ++wiseSayingLastId;
                    wiseSaying = new WiseSaying(id, author, content);
                    wsRepo.add(wiseSaying);
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    id++;
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-------------------");
                    for (WiseSaying saying : wsRepo) {
                        System.out.println(saying.getId() + " / " + saying.getAuthor() + " / " + saying.getContent());
                    }
                    break;
                case "삭제":
                    int paramId = rq.getIntParam("id", 0);
                    if (paramId == 0) {
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }
                    WiseSaying findWiseSaying = null;
                    for (WiseSaying saying : wsRepo) {
                        if (saying.getId() == paramId) {
                            findWiseSaying = saying;
                        }
                    }
                    if (findWiseSaying == null) {
                        System.out.println(paramId + "번 명언은 존재하지 않습니다.");
                        continue;
                    }
                    wsRepo.remove(findWiseSaying);
                    System.out.println(paramId + "번 명언이 삭제되었습니다.");
                    break;
                case "수정":
                    int findParamId = rq.getIntParam("id", 0);
                    if (findParamId == 0) {
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }
                    WiseSaying findWise = null;
                    for (WiseSaying saying : wsRepo) {
                        if (saying.getId() == findParamId) {
                            findWise = saying;
                        }
                    }
                    if (findWise == null) {
                        System.out.println(findParamId + "번 명언은 존재하지 않습니다.");
                        continue;
                    }
                    wsRepo.remove(findWise);
                    System.out.println(findParamId + "번 명언이 삭제되었습니다.");
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}