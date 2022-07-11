import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App{

    BufferedReader br;
    int wiseSayingLastId;
    List<WiseSaying> wiseSayings;

    public App() {
        br = new BufferedReader(new InputStreamReader(System.in));
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() throws IOException {
        System.out.println("== 명언 SSG ==");




        outer: while (true) {
            System.out.print("명령 ) ");
            String cmd = br.readLine();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "종료":
                    break outer;
                case "등록":
                    write(rq);
                    break;
                case "목록":
                    list(rq);
                    break;
                case "삭제":
                    remove(rq);
                    break;
            }
        }
        br.close();
    }

    private void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying1 = wiseSayings.get(i);
            System.out.println(wiseSaying1.id + " / " + wiseSaying1.author + " / " + wiseSaying1.content);
        }
    }

    private void write(Rq rq) throws IOException {
        System.out.print("명언 : ");
        String content = br.readLine();
        System.out.print("작가 : ");
        String author = br.readLine();
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    private void remove(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying fountWiseSaying = null;

        for (WiseSaying wiseSaying___ : wiseSayings) {
            if (wiseSaying___.id == paramId) {
                fountWiseSaying = wiseSaying___;
            }
        }

        // 찾지 못했다면 중지
        if (fountWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayings.remove(fountWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }
}