package HomeTaskTop100;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WordCount {
    private static Map<String, Integer> result = new HashMap<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        MyValueComp mvc = new MyValueComp(result); // создали объект Компаратор для сортировки по значению
        TreeMap<String, Integer> treeMap = new TreeMap<>(mvc);

        // Поток чтения книги
        InputStream in = WordCount.class.getClassLoader().getResourceAsStream("war.txt");
        BufferedReader  rdr = new BufferedReader(new InputStreamReader(in));
        List<String> lines = rdr.lines().collect(toList());
        // Поток чтения файла со словами, которые надо исключить
        InputStream in2 = WordCount.class.getClassLoader().getResourceAsStream("words.txt");
        BufferedReader  rdr2 = new BufferedReader(new InputStreamReader(in2));
        List<String> listWord = rdr2.lines().collect(Collectors.toList());

        // Собираем сет слов, которые надо исключить (без символов и тд)
        Set<String> set = new HashSet<>();
        for(String line : listWord){
            String[] arrStr = line.replaceAll("[^a-zA-Z]", " ").
                    trim().replaceAll("\\s+", " ").split(" ");
            for(String word : arrStr){
                set.add(word);
            }
        }

        int cpus = Runtime.getRuntime().availableProcessors();
        List<WordCountThread> workers = new ArrayList<>();
        int fromIndex;
        int toIndex = 0;
        //Создаем потоки, передаем им участки книги и сет
        for(int i = 1; i <= cpus; i++){
            fromIndex = toIndex;
            if( i == cpus){
                toIndex = lines.size();
            }else{
                toIndex = lines.size() - lines.size()*(cpus - i)/cpus;
            }
            WordCountThread wct = new WordCountThread(lines.subList(fromIndex, toIndex),set);
            workers.add(wct);
        }

        // запускаем потоки
        for(WordCountThread worker : workers){
            worker.start();
        }
        for(WordCountThread worker : workers){
            worker.join();
        }

        treeMap.putAll(result);
        int countWords = 0;
        for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
            if(countWords < 10){
                System.out.println("Слово " + "\"" + entry.getKey() + "\"" + " повторяется "
                        + entry.getValue() + " раз");
                countWords++;
            }
            else{
                break;
            }
        }
        System.out.println("------------------------------");
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения : " + ((finish - start)/1000.0) + " секунд");
    }

    private static class WordCountThread extends Thread{
        private  List<String> words;
        private HashMap<String, Integer> wordCnt;
        private Set<String> excWords;


        public WordCountThread(List<String> words, Set<String> excWords) {
            this.words = words;
            this.wordCnt = new HashMap<>();
            this.excWords = excWords;
        }


        @Override
        public void run() {
            uniteMapsWords(splitLines(words, excWords));
        }

        // Метод собирает карту без символов, не нужных слов (предлоги и тд, который помещены в сет из файла words)
        private HashMap<String, Integer> splitLines(List<String> words, Set<String> excWords){
            outer:for(String word : words) { // Считываем строку
                String[] arr = word.toLowerCase().replaceAll("[^a-zA-Z]", " ").
                        trim().replaceAll("\\s+", " ").split(" "); //Делим строку на слова
                if (arr[0].trim().isEmpty()) { // проверяем является ли строка пустой
                    continue outer;
                }
                for(String s : arr){ // проверяем на совпадение слов со словами из сета и затем добавляем в карту
                    if(!excWords.contains(s)){
                        if (wordCnt.containsKey(s)) { // сли слово в карте уже есть, увеличиваем значение
                            wordCnt.put(s, wordCnt.get(s) + 1);
                        } else {
                            wordCnt.put(s, 1);
                        }
                    }
                }
            }
            return wordCnt;
        }

        // Каждый поток по очереди добавляет свои карты в результирующую,
        // для повторяющихся слов значения суммируются
        private synchronized void uniteMapsWords(HashMap<String, Integer> wordCnt){
            for(Map.Entry<String, Integer> entry : wordCnt.entrySet()){
                String word = entry.getKey();
                Integer value = entry.getValue();
                if(result.containsKey(word)){
                    result.put(word, result.get(word) + value);
                }
                else{
                    result.put(word, value);
                }
            }
        }
    }
}
