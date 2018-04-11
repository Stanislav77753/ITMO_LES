package HomeWork_11_04;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ReaderFromFile {
    private List<String> lines;
    private int countWord;
    private int maxLenght;
    private List<String> wordGroup;
    private HashMap<Integer, List<String>> mapGroupWords;
    private HashMap<String, Integer> words;
    private HashMap<String, Integer> top;



    public ReaderFromFile(String filePath){
        try{
            FileInputStream fstream = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            this.lines = new ArrayList<>();
            String str;
            while ((str = br.readLine()) != null) {
                this.lines.add(str);
            }
            System.out.println("Файл прочитан и добавлен в коллекцию");
        }
        catch (IOException e){
            System.out.println("Файл не найден");
        }
    }


    public List<String> getLines(){
        return lines;
    }

    public  static List<String> splitLines(List<String> lines){// Метод возвращает лист слов
        List<String> listWords = new ArrayList<>();
        outer: for(String str : lines) {
            String[] arr = str.replaceAll("[^a-zA-Z]", " ").trim().replaceAll("\\s+", " ").split(" ");
            if(arr[0].trim().isEmpty()){
                continue outer;
            }
            for (int i = 0; i < arr.length; i++) {
                listWords.add(arr[i]);
            }
        }
        return listWords;
    }
    public static List<String> splitLines(List<String> lines, String[] arrstr){// Метод возвращает лист слов без предлогов и тд
        int count;
        List<String> listWords = new ArrayList<>();
        outer: for(String str : lines) {
            String[] arr = str.replaceAll("[^a-zA-Z]", " ").trim().replaceAll("\\s+", " ").split(" ");
            if(arr[0].trim().isEmpty()){
                continue outer;
            }
            for (int i = 0; i < arr.length; i++) {
                count = 0;
                for(int j = 0; j < arrstr.length; j++){
                    if(arr[i].compareToIgnoreCase(arrstr[j]) == 0) {
                        count+=1;
                    }
                }
                if(count == 0) {
                    listWords.add(arr[i].toLowerCase());
                }
            }
        }
        return listWords;
    }

    // Метод возвращает количество повторов аргумента
    public static int countWord(String word, List<String> listWords){
        int countWord = 0;
        for(String str : listWords){
            if(word.compareToIgnoreCase(str) == 0){
                countWord+=1;
            }
        }
        return countWord;
    }

    public int maxLenghtWord(List<String> listWords){
        this.maxLenght = 0;
        for(String s : listWords){
            if(s.length() > this.maxLenght){
                this.maxLenght = s.length();
            }
        }
        return maxLenght;
    }

    public HashMap<Integer, List<String>> getMapGroup(int maxLenght, List<String> listWords) {
        this.mapGroupWords = new HashMap<>();
        for (int k = 2; k <= maxLenght; k++){
            this.wordGroup = new ArrayList<>();
            for (String str : listWords) {
                if(str.length() == k){
                    wordGroup.add(str);
                }
            }
            this.mapGroupWords.put((Integer) k,this.wordGroup);
        }
        return this.mapGroupWords;
    }

    public void printMapGroup(HashMap<Integer, List<String >> map){
        for(Map.Entry entry : map.entrySet()){
            System.out.println("Группа слов из " + entry.getKey()+ " букв" + "\n" + entry.getValue());
        }
    }

    public HashMap<String, Integer> mapWords(List<String> listWords){ // очень медленно работает (надо переделать)
        this.words = new HashMap<>();
        List<String> newlist = new ArrayList<>(listWords);
        int count;
        String string;
        boolean isEmpty = true;
        while(isEmpty){
            count = 0;
            string = "";
            for(String str : newlist){
                for(String str1 : listWords){
                    if(str.compareToIgnoreCase(str1) == 0){
                        count+=1;
                    }
                }
                string = str;
                this.words.put(str, (Integer)count);
                break;
            }

            for(int i = 0; i < count; i++){
                newlist.remove(string);
            }
            if(newlist.isEmpty()){
                isEmpty = false;
            }
        }
        return this.words;
    }

    public HashMap<String, Integer> top10(HashMap<String, Integer> words){
        String word;
        Integer count;
        this.top = new HashMap<>();
        HashMap<String, Integer> newWords = new HashMap<>(words);
        int n = 0;
        while(n < 10){
            word = "";
            count = 0;
            HashMap<String, Integer> mapppp = new HashMap<>(newWords);
            outer: for(Map.Entry<String, Integer> entry : newWords.entrySet()){
                for(Map.Entry<String, Integer> entry1 : mapppp.entrySet()){
                    if(entry.getValue() < entry1.getValue()){
                        continue outer;
                    }
                }
                this.top.put(entry.getKey(), entry.getValue());
                word = entry.getKey();
                count = entry.getValue();
                break;
            }
            newWords.remove(word, count);
            n+=1;
        }
        return this.top;
    }


    public static void printTop10(HashMap<String, Integer> map){
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("Слово   " + entry.getKey()+ " встречается         " + entry.getValue() + " раз");
        }
    }

    public static List<Character> splitOnLetter(List<String> lines){
        //List<String> listLetters = new ArrayList<>();
        List<Character> listChar = new ArrayList<>();
        outer: for(String str : lines) {
            String[] arr = str.replaceAll("[^a-zA-Z]", "").trim().replaceAll("\\s+", "").split("");
            if(arr[0].trim().isEmpty()){
                continue outer;
            }
            for(int i = 0; i < arr.length; i++){
                char[] char1 = arr[i].toCharArray();
                for(int j = 0; j < arr[i].length(); j++){
                    listChar.add(char1[j]);
                }


            }
        }
        return listChar;
    }

    public static int nLetter(List<Character> listChar){
        int n = 0;
        for(Character ch : listChar){
            n+=1;
        }
        return n;
    }

    public static void printNLetter(List<Character> listChar, char[] charLet, int nLetter){
        int count;
        for(int i = 0; i < charLet.length; i++){
            String s = String.valueOf(charLet[i]);
            count = 0;
            for(Character ch : listChar){
                String ss = String.valueOf(ch);
                if(s.compareToIgnoreCase(ss)==0){
                    count+=1;

                }
            }
            System.out.println("Буква " + charLet[i] + " встречается в процентах " + (100*((double)count/(double)nLetter)) +" %");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReaderFromFile that = (ReaderFromFile) o;

        if (countWord != that.countWord) return false;
        return lines != null ? lines.equals(that.lines) : that.lines == null;
    }

    @Override
    public int hashCode() {
        int result = lines != null ? lines.hashCode() : 0;
        result = 31 * result + countWord;
        return result;
    }
}
