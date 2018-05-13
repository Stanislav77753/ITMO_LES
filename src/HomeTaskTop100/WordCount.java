package HomeTaskTop100;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class WordCount {
    private  static Map<String, Integer> result = new HashMap<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        InputStream in = WordCount.class.getClassLoader().getResourceAsStream("war.txt");
        BufferedReader  rdr = new BufferedReader(new InputStreamReader(in));
        List<String> lines = rdr.lines().collect(toList());
        int cpus = Runtime.getRuntime().availableProcessors();
        List<WordCountThread> workers = new ArrayList<>();
        int fromIndex = 0;
        int toIndex = 0;
        for(int i = 1; i <= cpus; i++){
            fromIndex = toIndex;
            if( i == cpus){
                toIndex = lines.size();
            }else{
                toIndex = lines.size() - lines.size()*(cpus - i)/cpus;
            }
            WordCountThread wct = new WordCountThread(lines.subList(fromIndex, toIndex));
            workers.add(wct);
            /*System.out.println(lines.subList(fromIndex, toIndex));
            System.out.println("-----------------------------------------");*/
        }
        for(WordCountThread worker : workers){
            worker.start();
            worker.join();
        }
        WordCountThread.printTopN(100, WordCountThread.tempMap);

        System.out.println("------------------------------");
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения : " + ((finish - start)/1000.0) + " секунд");
    }

    private static class WordCountThread extends Thread{
        private  List<String> words;
        private HashMap<String, Integer> wordCnt;
        public static HashMap<String, Integer> tempMap = new HashMap<>();
        private static  int count = 0;
        private String[] symbolsAndWord = {"a", "an", "the", "on", "and", "in", "if", "from", "I", "he", "she", "it",
                "you", "to", "of", "it", "me", "by", "but", "so", "s", "t", "with", "my", "don", "at", "for", "is",
                "are", "am", "chapter", "Leo", "Tolstoy", "Tolstoi"};

        public WordCountThread(List<String> words) {
            this.words = words;
            this.wordCnt = new HashMap<>();
        }


        @Override
        public void run() {
            List<String> words = splitLines(this.words, symbolsAndWord);
            uniteMapsWords(mapWordsCountRepeats(words));
        }

        private List<String> splitLines(List<String> words, String[] symbolsAndWords){
            List<String> listWords = new ArrayList<>();
            String[] arrSymbols = symbolsAndWords;
            outer:for(String word : words){
                String[] arr = word.replaceAll("[^a-zA-Z]", " ").trim().replaceAll("\\s+", " ").split(" ");
                if(arr[0].trim().isEmpty()){
                    continue outer;
                }
                outer2: for(String s : arr) {
                    for(String symbols : arrSymbols){
                        if(symbols.compareToIgnoreCase(s) == 0){
                            continue outer2;
                        }
                    }
                    listWords.add(s.toLowerCase());
                }
            }
            return listWords;
        }

        private HashMap<String, Integer> mapWordsCountRepeats(List<String> words){
            List<String> listAllWords = words;
            HashMap<String, Integer> mapWords= new HashMap<>();
            for(String s : listAllWords){
                mapWords.put(s, 0);
            }
            int countRepeats;
            for(Map.Entry<String, Integer> entry : mapWords.entrySet()){
                countRepeats = 0;
                for(String word : listAllWords){
                    if(entry.getKey().equals(word)){
                        countRepeats+=1;
                    }
                }
                this.wordCnt.put(entry.getKey(), countRepeats);
            }
            return this.wordCnt;
        }

        private synchronized void uniteMapsWords(HashMap<String, Integer> mapWordsCountRepeats){
            if(count==0) {
                for (Map.Entry<String, Integer> entry : mapWordsCountRepeats.entrySet()) {
                    tempMap.put(entry.getKey(), entry.getValue());
                    count+=1;
                }
            }
            else{
                for(Map.Entry<String, Integer> entry : mapWordsCountRepeats.entrySet()){
                    for(Map.Entry<String, Integer> entry1 : tempMap.entrySet()){
                     if(entry.getKey().equals(entry1.getKey())){
                         tempMap.put(entry.getKey(), (entry.getValue() + entry1.getValue()));
                     }else{
                         tempMap.put(entry1.getKey(), entry1.getValue());
                     }
                    }
                }
            }
        }

        public static void printTopN(int n, Map<String, Integer> map){
            Map<Integer, String> sortMap = new TreeMap<>(Collections.reverseOrder());
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                sortMap.put(entry.getValue(), entry.getKey());
            }
            System.out.println("Топ " + n + " слов:");
            int count = 0;
            Set set = sortMap.entrySet();
            Iterator i = set.iterator();
            while(i.hasNext()){
                Map.Entry me = (Map.Entry) i.next();
                System.out.println("Слово " + "\"" + me.getValue() + "\"" + " повторяется " + me.getKey()
                        + " раз" );
                count+=1;
                if(count==n){
                    break;
                }
            }
        }
    }

}
