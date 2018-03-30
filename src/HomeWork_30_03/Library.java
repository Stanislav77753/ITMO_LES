package HomeWork_30_03;
import java.util.HashMap;

public class Library {
    private int bookCounter;
    private int librarySize = 100;
    private HashMap<Book, Integer> booksMap;

    Library(){
        this.booksMap = new HashMap<>();
    }

    public void putBook (Book book, int quantity){
        if(librarySize>bookCounter + quantity){
            if (booksMap.containsKey(book)){
                booksMap.computeIfPresent(book,(k, v) -> v + quantity);
            }
            else {
                booksMap.put(book,quantity);
            }
            bookCounter = bookCounter + quantity;

        }
        else {
            System.out.println("Нет места для книг");
        }

    }

    public int getBook(Book book, int quantity){
        if (booksMap.containsKey(book)){
            if(booksMap.get(book) >= quantity){
                booksMap.computeIfPresent(book,(k, v) -> v - quantity);
                bookCounter=bookCounter - quantity;
                return quantity;
            }
            else {
                return 0;
            }
        }
        else {
            return 0;
        }
    }

    public HashMap<Book, Integer> getBooksMap() {
        return booksMap;
    }

    public int getBookCounter() {
        return bookCounter;
    }
}
