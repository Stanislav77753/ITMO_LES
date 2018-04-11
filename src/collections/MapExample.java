package collections;

import java.util.*;

public class MapExample {
    // interface Map
    // В контейнерах Map хранятся 2 объекта: ключ и значение
    // Ключи должны быть уникальными, значения могут дублироваться
    // Существует возможность искать объекты по ключу

    // interface SorterMap - элементы размещаются по возрастанию ключей
    // interface NavigableMap - расширяет SorterMap
    // Map.Entry поззволяет работать с элементами

    // Классы который имплементирую эти интерфейсы:

    //HashMap - труктура данных для хранения пары ключ-значение
    // Ключи и значения могут быть любого типа, даже null
    // нет гарантий относительно неизменности порядка элементов
    // Разрешение коллизий осуществляется методом цепочек

    // TreeMap - коллекция с отсортированными ключами
    // LinkedMap - запоминается порядок, в котором добавлялись элементы
    // WeakHashMap - начения могут удальтся сборщиком мусора, если они не используются
    // IdentityHashMao - ключи сравниваются с помощью ==, вместо equals

    //interface Map<K, V>

    // методы:
    // void clear() - удаляет все пары ключ - значение
    // boolean containsKey(Object obj)
    // boolean containsValue(Object obj)
    // boolean equals(Object obj) - сравнивает по значениям, - true, если obj - это map, который содержит одинаковые значения
    // boolean isEmpty
    // put(key, Value)
    // putAll()
    // remove(key)
    // int size()
    // get(key)

    // Интерфейс map предоставляет три способа для доступа к данным, используя:
    // set из ключей (метод getKey)
    // коллекцию из значений (метод getValue)
    // set из пары ключ-значение (entrySet)

   // for(Map.Entry entry : mapName.entrySet()){}


    public static void main(String[] args) {
        Map<Integer, String> newMap = new HashMap<>();
        newMap.put(1, "gsgs");
        newMap.put(2, "jhjkk");
        newMap.put(3, "gsfsd");
        Map<Integer, String> newFinalMap = Collections.unmodifiableMap(newMap); // создали неизменяемую коллекцию

        /*Collections.unmodifiableMap(finalMap);
        finalMap.put("1", "val1");
        finalMap.put("2", "val2");
        finalMap.put("3", "val3");
        for(Map.Entry entry: finalMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/



        Map<String, String> hashmap = new HashMap<>();
        hashmap.put("key", "value");
        hashmap.put(null, "value1");
        hashmap.put(null, "value2");
        hashmap.put(null, "value3");
        //System.out.println(hashmap.get("key1"));

       /* for(Map.Entry entry: hashmap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/

        //TreeMap - для хранения элементов применяется дерево
        // Объекты сохраняются в отсортированном порядке
        // Ключи по возрастанию

        Map<String, String> treemap = new TreeMap<>();
        treemap.put("12", "value1");
        treemap.put("aaaa", "value2");
        treemap.put("AAAD", "value3");
        treemap.put("AAAA", "value4");

        for(Map.Entry entry: treemap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // конструкторы
//        TreeMap();
//        TreeMap(Comparator comp);
//        TreeMap(Map m);
//        TreeMap(SortedMap sortedmap);

        class CustComp implements Comparable{

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }

        // LinkedHashMap - расширяет HashMap
        // порядок хранения элементов определяется порядком установки

        Map<String, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put("12", "value1");
        linkedMap.put("aaaa", "value2");
        linkedMap.put("AAAD", "value3");
        linkedMap.put("AAAA", "value4");
        System.out.println();

        for(Map.Entry entry: linkedMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }




    }
}
