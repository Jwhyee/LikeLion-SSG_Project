public class Quotes{
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

    @Override
    public String toString() {
        return id + " / " + writer + " / " + quotes;
    }
}