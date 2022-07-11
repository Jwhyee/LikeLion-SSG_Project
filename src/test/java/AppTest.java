import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    @DisplayName("getPath")
    public void rqGetPath() {
        Rq rq = new Rq("삭제?id=1");
        String path = rq.getPath();

        assertEquals("삭제", path);
    }

    @Test
    @DisplayName("rq")
    public void Rq() {
        Rq rq = new Rq("검색?id=1&no=1");
        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);
        assertEquals(1, id);
        assertEquals(1, no);
    }
    @Test
    @DisplayName("스캐너")
    public void 문자열을_스캐너의_입력으로_설정() {
        String input = """
                등록
                명언1
                작가1
                """.stripIndent();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();
        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);
    }
    @Test
    @DisplayName("출력")
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        // 표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        String rs = output.toString().trim();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);
    }
}