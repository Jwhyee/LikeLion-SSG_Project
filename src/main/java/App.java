import java.io.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class App{
    public void run() throws IOException {
        System.out.println("== 명언 SSG ==");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wiseSayingLastId = 0;

        outer: while (true) {
            System.out.print("명령 ) ");
            String cmd = br.readLine();

            switch (cmd) {
                case "종료":
                    break outer;
                case "등록":
                    System.out.print("명언 : ");
                    String title = br.readLine();
                    System.out.print("작가 : ");
                    String author = br.readLine();
                    int id = ++wiseSayingLastId;
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    break;
                case "삭제":
                    break;
            }
        }
        br.close();
    }
}