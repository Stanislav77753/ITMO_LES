package HomeWork_30_03;

public class Book {
    private String author, title;
    private int pagesNum;

    public Book(String author, String title, int pagesNum) {
        this.author = author;
        this.title = title;
        this.pagesNum = pagesNum;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPagesNum() {
        return pagesNum;
    }
}
