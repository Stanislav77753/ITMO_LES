package collections;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectionExample {
    private String name;
    private int count;

    public CollectionExample(String name, int count){
        this.name = name;
        this.count = count;
    }




    //В Java все классы наследуются от Object.
//Это позволяет группировать ссылки на объекты и работать с ними единообразно.
//Класс Object предоставляет следующие методы, которые есть у всех объектов:
//  1) Class<?> getClass() - возвращает ссылку на класс объекта
//  2) int hashCode() - возвращает хэш-код объекта, по умолчанию это
//    рассчитанное специальным образом число на основании генератора
//    случайных чисел;
//  3) boolean equals(Object obj) — возвращает true, если объекты одинаковы,
//    по умолчанию выполняет сравнение по ссылке: ==;
//  4) Object clone() - создает копию объекта;
//  5) String toString() - возвращает строковое представление объекта,
//    например для удобства вывода в консоль;
//  6) void finalize() - выполняется при уничтожении объекта сборщиком
//            мусора;
//  7) методы wait(), notify() и notifyAll() используются при многопоточном
//    программировании.

//    Для определения идентичности объектов используют методы equals() и
//    hashCode(). Они переопределяются оба для соответсвия
//    следующим требованиям.  (сгенерировать Intellij IDEA: ALT + Insert).
//    equals:
//    1. Рефлективность — объект всегда равен самому себе:
//       a.equals(a).
//    2. Симметричность —
//        если a.equals(b) , то и b.equals(a).
//    3. Транзитивность —
//        если a.equals(b), b.equals(c), то и a.equals(c).
//    4. Консистентность — сколько бы раз не вызывался equals без изменения состояния объектов,
//    результат должен оставаться неизменным.
//    Переопределенный equals проверяет сначала идентичность с помощью ==,
//    потом на null и тип переданного объекта,
//    после чего сравнивает при помощи equals все поля
//    hashCode:
//    1. Сколько раз бы не был вызван hashCode на объекте, он должен
//    возвращать то же значение. Значение может быть иным при следующем выполении программы.
//    2. Если объекты равны по equals(), то hashCode() должен вернуть
//    одинаковое значение для обоих объектов.
//    3. Если объекты не равны по equals(), hashCode() может возвращать
//    одинаковые значения.

//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionExample that = (CollectionExample) o;

        if (count != that.count) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + count;
        return result;
    }

    public static void main(String[] args) throws IOException {
        CollectionExample collectionExample1 = new CollectionExample("ColEx", 4);
        CollectionExample collectionExample2 = new CollectionExample("ColEx", 4);


//        System.out.println(collectionExample1.hashCode());
//        System.out.println(collectionExample2.hashCode());
//        System.out.println(collectionExample1.equals(collectionExample2));

//          Collection Framework
//          interface Collection:

//        int size();
//        boolean isEmpty(); - возвращает true если пустой
//        boolean contains(Object obj); - возврашает true если в коллекции сдержится объект
//        boolean add(elem); - возвращает true если элемент добавлен
//        boolean remove(Object obj);- возвращает true если элемент удален
//        boolean containsAll(Collection<?> c); - возвращает true если содержаться все элеменььы переданной коллекции
//        boolean addAll(Collection<?> c); - возвращает true если добавдены все элементы
//        boolean removeAll(Collection<?> c);- возвращает true если удалены все элементы
//        boolean retailAll(Collection<?> c); - удаляет элементы не принадлежащие переданной коллекции
//        boolean clear(); - очищает всю коллекцию


//            1. interface Set (
//              коллекция, которая не  может содержать дублирующих элементов
//            HashSet - реализация на основе хеш-таблицы.
//                Это наиболее эффективная реализация,
//                но она не гарантирует сохранение порядка элементов при обходе,

        Set<String> strings = new HashSet<>();
//        System.out.println(strings.add("12"));
//        System.out.println(strings.add("43"));
//        System.out.println(strings.add("43"));
//        System.out.println(strings.add("67"));

        for(String str : strings){
            System.out.println(str);
        }

        Set<CollectionExample> colex = new HashSet<>();
       /* System.out.println(colex.add(collectionExample1));
        System.out.println(colex.add(collectionExample2));
        System.out.println(colex.contains(collectionExample2));*/

        Iterator<String> iterator =strings.iterator();
        while ((iterator.hasNext())){
            //System.out.println("with iterator " + iterator.next());
        }

//            LinkedHashSet - реализация на основе хеш-таблицы,
//                но дополнительно пролинкованная связанным списком.
//                Эта реализация избавляет от хаотичного порядка элементов
//                и лишь незначительно хуже по эффективности HashSet-а.
//            TreeSet - упорядочивает элементы в соответствии с их значениями,
//        но работает значительно медленнее HashSet
//        )
//            2. interface List - упорядоченная коллекция, может содержать дублирующие элементы
        // доступ, удаление, добавлние элементов по индексу
        // поиск элементов
        // замена элементов
        // операции с частью списка
        //ListIterator - расширенный итератор
       /* List<String> arrlst = new ArrayList<>();
        List<String> linkedlist = new LinkedList<>();
        arrlst.subList(1,3).clear(); // sublist позволяет работать с частью листа*/




//            3. interface Queue - очередь
        //element(); - возвращает, но не удаляет элементиз начала очереди, при нуле элементов сгенерирует исключение
        //poll(); - возвращает с удаление из начала очереди, при нуле элементов вернет null
        //peek(); - озвращает без удаления элемент из начала очереди (null, если очередь пуста)
        //remove(); -

        Queue<String> queue = new PriorityQueue<>();

        File txt = new File("src/file.txt");
        List<String> lines = Files.readAllLines(txt.toPath());
//        для каждой строки :
//        1) перевести в нижний регистр
//        2) убрать пробелы в начале и в конце строки
//        3) поместить в коллекцию только не пустые слова

        List<String> list = new ArrayList<>();
        for(String s : lines){
             //list.add(s.toLowerCase().trim().replace(" ", ""));
             String[] arr = s.toLowerCase().trim().split(" ");
             for(int i = 0; i < arr.length; i++){
                 list.add(arr[i]);
             }

        }

        System.out.println(list);
    }
}
