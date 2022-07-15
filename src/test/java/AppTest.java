import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void 등록() {
        String cmd = "등록";
        String ws = "현재를 사랑하라";
        String aut = "작자미상";

        assertEquals(cmd, "등록");
        assertEquals(ws, "현재를 사랑하라");
        assertEquals(aut, "작자미상");

    }

    @Test
    void 등록시_생성된_명언번호_노출() {
        Map<Integer, WiseSaying> map = new HashMap<>();
        int id = 1;
        String cmd = "등록";
        String content = "현재를 사랑하라";
        String author = "작자미상";
        WiseSaying saying = new WiseSaying(id, author, content);

        assertEquals(id, 1);
    }

    @Test
    void 명언삭제를_위한_path_구분() {
        String cmd = "삭제?id=1";
        Rq rq = new Rq(cmd);
        assertEquals(rq.getPath(), "삭제");
    }

}