package HomeTaskTop100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
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
        List<WordCountThread> workers = new ArrayList<>();
        BlockingQueue<String> linesQueue = new LinkedBlockingQueue();
        BlockingQueue<HashMap<String, Integer>> mapQueue = new ArrayBlockingQueue<>(cpus);

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
            WordCountThread wct = new WordCountThread(linesQueue, set, mapQueue);
            workers.add(wct);
        }

        for(WordCountThread worker : workers){
            worker.start();
        }
        linesQueue.addAll(lines);
        linesQueue.add(STOP);

        for(WordCountThread worker : workers){
            worker.join();
        }

        for(HashMap<String, Integer> mQueue : mapQueue){
            for(Map.Entry<String, Integer> map : mQueue.entrySet()){
                String key = map.getKey();
                Integer value = map.getValue();
                if(result.containsKey(key)){
                    result.put(key, result.get(key) + value);
                }
                else{
                    result.put(key,value);
                }
            }
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
        private final BlockingQueue<String> linesQueue;
        private HashMap<String, Integer> wordCnt = new HashMap<>();
        BlockingQueue<HashMap<String, Integer>> mapQueue;
        private Set<String> excWords;


        public WordCountThread(BlockingQueue<String> linesQueue, Set<String> excWords,
                               BlockingQueue<HashMap<String, Integer>> mapQueue ) {
            this.linesQueue = linesQueue;
            this.mapQueue = mapQueue;
            this.excWords = excWords;


        }


        @Override
        public void run() {
            while ((!isInterrupted())){
                try {
                    String line = linesQueue.take();
                    if (line == STOP){
                        linesQueue.add(STOP);
                        break;
                    }
                    splitAndUniteInMap(line, excWords);

                } catch (InterruptedException e) {
                    return;
                }
            }
            mapQueue.add(wordCnt);
        }

        private void splitAndUniteInMap(String line, Set<String> excWords){
            String[] arr = line.toLowerCase().replaceAll("[^a-zA-Z]", " ").
                    trim().replaceAll("\\s+", " ").split(" "); //Делим строку на слова
            outer:for(String word : arr){
                if (word.trim().isEmpty()) { // проверяем является ли строка пустой
                    continue outer;
                }
                if(!excWords.contains(word)){
                    if (wordCnt.containsKey(word)) { // если слово в карте уже есть, увеличиваем значение
                        wordCnt.put(word, wordCnt.get(word) + 1);
                    } else {
                        wordCnt.put(word, 1);
                    }
                }
            }
        }
    }
}
