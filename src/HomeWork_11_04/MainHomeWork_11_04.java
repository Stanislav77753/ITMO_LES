package HomeWork_11_04;

import java.util.HashMap;
import java.util.List;

public class MainHomeWork_11_04 {
    public static void main(String[] args){
        ReaderFromFile book = new ReaderFromFile("C:\\Java_project\\JavaItmo\\ITMO_LES\\src\\HomeWork_11_04\\wp1.txt");
        // масси символов и слов, которые исключаем
        String[] arr = {"a", "an", "the", "on", "and", "in", "if", "from", "I", "he", "she", "it", "you", "to", "of",
                "it", "me", "by", "but", "so", "s", "t", "with", "my", "don", "at", "for", "is", "are", "am",
                "chapter", "Leo", "Tolstoy", "Tolstoi"};
        Character[] charLet ={'a', 'b', 'c', 'd', 'e', 'f','g', 'h', 'i','j', 'k', 'l','m', 'n', 'o','p', 'q', 'r',
                's', 't', 'u','v', 'w', 'x','y', 'z'};

        // Лист с содержимым книги
        List<String> bookList = book.getLines();

        // Лист со словами и с артиклями. предлогами и тд

       /* List<String> bookList1 = ReaderFromFile.splitLines(bookList);
        System.out.println(bookList1);*/

        // Лист без элементов из массива arr
        List<String> bookList2 = ReaderFromFile.splitLines(bookList, arr);
        System.out.println(bookList2);

        // Выводим частоту слова, которую передаем в аргумент метода
        /*int i = ReaderFromFile.countWord("Peace", bookList2);
        System.out.println(i);*/

        // Выводим топ 10 повторяемых слов
        int maxLenghtWord = book.maxLenghtWord(bookList2); //максимальный размер слова в списке
        HashMap<String, Integer> mapWord = book.mapWords(bookList2); // Коллекция не повторяющихся слов и их повторяемость
        HashMap<String, Integer> mapTop = book.top10(mapWord); // Коллекция c топ 10 слов
        ReaderFromFile.printTop10(mapTop);

        /*List<String> listLetters = ReaderFromFile.splitOnLetter(bookList);
        System.out.println(ReaderFromFile.nLetter(listLetters));*/
    }
}
