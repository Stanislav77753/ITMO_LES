package HomeTaskTop100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WordCountQueue {
    private static Map<String, Integer> result = new HashMap<>();
    private static final String STOP = new String("stop");
    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        MyValueComp mvc = new MyValueComp(result); // создали объект Компаратор для сортировки по значению
        TreeMap<String, Integer> treeMap = new TreeMap<>(mvc);
        InputStream in = WordCount.class.getClassLoader().getResourceAsStream("war.txt");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        List<String> lines = rdr.lines().collect(toList());
        int cpus = Runtime.getRuntime().availableProcessors();
        List<WordCountQueue.WordCountThread> workers = new ArrayList<>();
        BlockingQueue<String> linesQueue = new LinkedBlockingQueue();

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

        for(int i = 1; i <= cpus; i++){
//
            WordCountThread wct = new WordCountThread(linesQueue, set);
            workers.add(wct);
        }



        for(WordCountThread worker : workers){
            worker.start();
        }
        linesQueue.addAll(lines);
        for (int i = 0; i < cpus; i++) {
            linesQueue.add(STOP);
        }
        for(WordCountThread worker : workers){
            worker.join();
        }
        for(WordCountThread worker : workers){
            worker.uniteMapsWords();
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
        private  BlockingQueue<String> linesQueue;
        private HashMap<String, Integer> wordCnt;
        private Set<String> excWords;


        public WordCountThread(BlockingQueue<String> linesQueue, Set<String> excWords ) {
            this.linesQueue = linesQueue;
            this.wordCnt = new HashMap<>();
            this.excWords = excWords;
        }


        @Override
        public void run() {
            while ((!isInterrupted())){
                try {
                    String line = linesQueue.take();
                    if (line == STOP){
                        break;
                    }

                    splitLines(line, excWords);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        private HashMap<String, Integer> splitLines(String line, Set<String> excWords){
            String[] arr = line.replaceAll("[^a-zA-Z]", " ").
                    trim().replaceAll("\\s+", " ").split(" "); //Делим строку на слова
            outer:for(String word : arr){
                if (word.trim().isEmpty()) { // проверяем является ли строка пустой
                    continue outer;
                }
                if(!excWords.contains(word)){
                    if (wordCnt.containsKey(word)) { // сли слово в карте уже есть, увеличиваем значение
                        wordCnt.put(word.toLowerCase(), wordCnt.get(word) + 1);
                    } else {
                        wordCnt.put(word, 1);
                    }
                }
            }
            return wordCnt;
        }
        private void uniteMapsWords(){
            for(Map.Entry<String, Integer> entry : this.wordCnt.entrySet()){
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
