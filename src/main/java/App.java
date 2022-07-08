import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App{
    public void run() throws IOException {
        System.out.println("== 명언 SSG ==");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<WiseSaying> wiseSayings = new ArrayList<>();
        int wiseSayingLastId = 0;

        outer: while (true) {
            System.out.print("명령 ) ");
            String cmd = br.readLine();

            switch (cmd) {
                case "종료":
                    break outer;
                case "등록":
                    System.out.print("명언 : ");
                    String content = br.readLine();
                    System.out.print("작가 : ");
                    String author = br.readLine();
                    int id = ++wiseSayingLastId;
                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    wiseSayings.add(wiseSaying);
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("---------------");
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying1 = wiseSayings.get(i);
                        System.out.println(wiseSaying1.id + " / " + wiseSaying1.author + " / " + wiseSaying1.content);
                    }
                    break;
                case "삭제":
                    break;
            }
        }
        br.close();
    }
}