import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;

    WiseSayingRepository() {
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }

    // 하나 찾기
    public WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }
        return null;
    }

    // 다 찾기
    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    // 파일저장
    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    // 파일 삭제
    public void remove(int paramId) {
        WiseSaying foundWiseSaying = findById(paramId);
        wiseSayings.remove(foundWiseSaying);
    }

    // 파일 수정
    public void modify(int paramId, String content, String author) {
        WiseSaying foundWiseSaying = findById(paramId);
        foundWiseSaying.content = content;
        foundWiseSaying.author = author;
    }
}