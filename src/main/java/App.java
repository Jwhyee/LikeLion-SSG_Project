import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App{
    public void run() throws IOException {
        List<Quotes> quotesList = new ArrayList<>();
        System.out.println("== 명언 SSG ==");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;

        outer: while (true) {
            System.out.print("명령 ) ");
            String cmd = br.readLine();

            switch (cmd) {
                case "종료":
                    break outer;
                case "등록":
                    System.out.print("명언 ) ");
                    String quotes = br.readLine();
                    System.out.print("작가 ) ");
                    String writer = br.readLine();
                    Quotes newQuotes = new Quotes(cnt, quotes, writer);
                    quotesList.add(newQuotes);
                    break;
            }
            System.out.println(quotesList.get(cnt - 1).id + "번 명언이 등록되었습니다.");
            cnt++;
        }
        br.close();
    }
}
class Quotes{
    int id;
    String quotes;
    String writer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Quotes(int id, String quotes, String writer) {
        this.id = id;
        this.quotes = quotes;
        this.writer = writer;
    }
}