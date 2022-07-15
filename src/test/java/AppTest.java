import org.junit.jupiter.api.Test;
import util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        String content = "현재를 사랑하라";
        String author = "작자미상";
        WiseSaying saying = new WiseSaying(id, author, content);

        assertEquals(saying.id, 1);
    }

    @Test
    void 명언삭제를_위한_path_구분1() {
        String cmd = "삭제?id=1";
        String cmd2 = cmd.split("\\?")[0];
        assertEquals(cmd2, "삭제");
    }

    @Test
    void 명언삭제를_위한_path_구분2() {
        String cmd = "삭제?id=1";
        Rq rq = new Rq(cmd);
        assertEquals(rq.getPath(), "삭제");
    }

    @Test
    void 존재하지_않는_명언_삭제에_대한_예외처리1() {
        WiseSaying wiseSaying1 = new WiseSaying(1, "작미1", "내용1");
        WiseSaying wiseSaying2 = new WiseSaying(2, "작미2", "내용2");
        WiseSaying wiseSaying3 = new WiseSaying(3, "작미3", "내용3");
        String cmd = "삭제?id=2";
        Rq rq = new Rq(cmd);
        int paramId = rq.getIntParam("id", 0);
        assertEquals(paramId, 2);
    }

    @Test
    void 존재하지_않는_명언_삭제에_대한_예외처리2() {
        List<WiseSaying> repo = new ArrayList<>();
        WiseSaying wiseSaying1 = new WiseSaying(1, "작미1", "내용1");
        repo.add(wiseSaying1);
        WiseSaying wiseSaying2 = new WiseSaying(2, "작미2", "내용2");
        repo.add(wiseSaying2);
        WiseSaying wiseSaying3 = new WiseSaying(3, "작미3", "내용3");
        repo.add(wiseSaying3);
        String cmd = "삭제?id=2";
        Rq rq = new Rq(cmd);
        int paramId = rq.getIntParam("id", 0);
        if (paramId != 0) {
            repo.remove(wiseSaying2);
        }
        assertEquals(repo.get(1).content, "내용3");
    }

    @Test
    void 파일에_내용쓰기() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용");
    }
}