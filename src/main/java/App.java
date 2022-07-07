import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App{
    public void run() throws IOException {
        System.out.println("== 명언 SSG ==");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        outer: while (true) {
            System.out.print("명령 ) ");
            String cmd = br.readLine();

            switch (cmd) {
                case "종료":
                    break outer;
            }
        }
        br.close();
    }
}
