import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        /*Задание 1
        Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран сначала в строку,
                отделяя один элемент от другого пробелом, а затем в столбик (отделяя один элемент от другого началом
                новой строки). Перед созданием массива подумайте, какого он будет размера.*/
        //task1();

        /*Задание 2
        Cоздайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем этот же массив
        выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3 1)*/
        //task2();

        /*Задание 3
        Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран. Подсчитайте сколько
        в массиве чётных элементов и выведете это количество на экран на отдельной строке*/
        //task3();

        /*Задание 4
        Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите массивы на экран в двух
        отдельных строках. Посчитайте среднее арифметическое элементов каждого массива и сообщите, для какого из
        массивов это значение оказалось больше (либо сообщите, что их средние арифметические равны)*/
        //task4();

        /*Задание 5
        Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в строку. Определить
        и вывести на экран сообщение о том, является ли массив строго возрастающей последовательностью.*/
        //task5();

        /*Задание 6
        Пользователь должен указать с клавиатуры чётное положительное число, а программа должна создать массив
        указанного размера из случайных целых чисел из [-5;5] и вывести его на экран в строку. После этого программа
        должна определить и сообщить пользователю о том, сумма модулей какой половины массива больше: левой или правой,
        либо сообщить, что эти суммы модулей равны. Если пользователь введёт неподходящее число, то программа должна
        требовать повторного ввода до тех пор, пока не будет указано корректное значение*/
        //task6();

        /*Задание 7
        Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел из отрезка [-99;99].
        Вывести массив на экран. После на отдельной строке вывести на экран значение максимального элемента этого
        массива (его индекс не имеет значения)*/
        //task7();

        /*Задание 8
        Для проверки остаточных знаний учеников после летних каникул, учитель младших классов решил начинать каждый
        урок с того, чтобы задавать каждому ученику пример из таблицы умножения, но в классе 15 человек, а примеры
        среди них не должны повторяться. В помощь учителю напишите программу, которая будет выводить на экран 15
        случайных примеров из таблицы умножения (от 2*2 до 9*9, потому что задания по умножению на 1 и на 10 —
        слишком просты). При этом среди 15 примеров не должно быть повторяющихся (примеры 2*3 и 3*2 и им подобные
        пары считать повторяющимися)*/
        //task8();

        /*Задание 9
        Найти в строке указанную подстроку и заменить ее на новую. Строку, ее подстроку для замены и новую подстроку
        вводит пользователь.*/
        //task9();

        /*Задание 10
        Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde def",
         то должно быть выведено "abcdef".*/
        //task10();

        /*Задание 11
        Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы. Требуется все числа, которые
        встречаются в строке, поместить в отдельный целочисленный массив. Например, если дана строка "дом 48, корпус 9,
        парадная 7, этаж 4", то в массиве должны оказаться числа 48, 9, 7 и 4*/
        //task11();
    }

    //----------------------- Задание 1 ----------------------------------------
    public static void task1(){
        int[] arr = new int[10];
        for(int i = 1; i <= arr.length; i++){
            arr[i-1] = i * 2;
            System.out.print(arr[i-1] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    //----------------------- Задание 2 ----------------------------------------
    public static void task2(){
        int count = 0;
        int start = 1;
        int end = 99;
        for (int i = start; i <= end; i++){ // определяем количество нечетный чисел
            if(i % 2 != 0){
                count+=1;
            }
        }
        int[] arr = new int[count];
        int x = 1;
        for(int i = 0; i <arr.length; i++){ // выводим массив в порядке увеличения чисел
            arr[i] = i + x;
            x+=1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        x = 50;
        for(int i = arr.length - 1; i >= 0; i--){// выводим массив в обратном порядке
            arr[i] = i + x;
            x-=1;
            System.out.print(arr[i] + " ");
        }
    }

    //----------------------- Задание 3 ----------------------------------------
    public static void task3(){
        int[] arr = new int[15];
        int countEven = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = 0 + (int)(Math.random()*9);
            System.out.print(arr[i] + " ");
            if(arr[i] % 2 == 0 && arr[i] != 0){
                countEven+=1;
            }
        }
        System.out.println();
        System.out.println(countEven);
    }

    //----------------------- Задание 4 ----------------------------------------
    public static void task4(){
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 5);
            System.out.print(arr1[i] + " ");
            sum1 += arr1[i];
        }
        System.out.println();

        for(int i = 0; i < arr2.length; i++) {
            arr2[i] =(int) (Math.random() * 5);
            System.out.print(arr2[i] + " ");
            sum2 += arr2[i];
        }
        System.out.println();
        if((double)sum1/arr1.length > (double)sum2/arr2.length){
            System.out.println("Среднее арифметическое элементов первого массива больше");
        }
        else if ((double)sum1/arr1.length < (double)sum2/arr2.length){
            System.out.println("Среднее арифметическое элементов второго массива больше");
        }
        else{
            System.out.println("Среднее арифметическое элементов двух массивов равны");
        }
    }
    //----------------------- Задание 5 ----------------------------------------
    public static void task5(){
        int[] arr = new int[4];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 10 + (int)(Math.random()*89);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);

        if(Arrays.equals(arr, arrCopy)){
            System.out.println("Массив является возрастающей последовательностью");
        }
        else {
            System.out.println("Массив не является возрастающей последовательностью");
        }
    }

    //----------------------- Задание 6 ----------------------------------------
    public static void task6(){
        boolean odd_sc = true;
        int a = 0;
        int sum1 = 0;
        int sum2 = 0;
        while(odd_sc){
            System.out.println("Введите четное положительное число:");
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt();
            if(a > 0 && a % 2 == 0){
            odd_sc = false;
            }
            else{
                System.out.println("Вы ввели неверное число!!!");
            }
        }
        int[] arr = new int[a];

        for(int i = 0; i < arr.length; i++){
            arr[i] = -5 + (int)(Math.random()*10);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr.length/2; i++){
            sum1 += Math.sqrt(arr[i] * arr[i]);
        }

        for(int i = arr.length/2; i < arr.length; i++){
            sum2 += Math.sqrt(arr[i] * arr[i]);
        }

        if(sum1 > sum2){
            System.out.println("Сумма модулей элементов левой половины больше");
        }
        else if ( sum1 < sum2){
            System.out.println("Сумма модулей элементов правой половины больше");
        }
        else{
            System.out.println("Сумма модулей равны");
        }
    }

    //----------------------- Задание 7 ----------------------------------------
    public static void  task7(){
        int max = 0;
        int[][] arr = new int[5][8];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = -99 + (int)(Math.random()*198);
                if(arr[i][j] < 0 && arr[i][j] < -9){ // условия для отформатированного вывода на консоль
                    System.out.print(arr[i][j] + " ");
                }
                else if(arr[i][j] < 0){
                    System.out.print(" " + arr[i][j] + " ");
                }
                else if (arr[i][j] > 0 && arr[i][j]> 9){
                    System.out.print(" " + arr[i][j] + " ");
                }
                else
                System.out.print("  " + arr[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if( max < arr[i][j])
                    max = arr[i][j];
            }
        }
        System.out.println("Максимальный элемент равен " + max);
    }

    //----------------------- Задание 8 ----------------------------------------
    public static void task8(){
        int count = 0;
        int[][] arr = new int[2][15];
        while(count < 15){
            int row = 2 + (int)(Math.random()*7);
            int col = 2 + (int)(Math.random()*7);
            for(int i = 0; i < count +1; i++){
                if(((arr[0][i] == row) && (arr[1][i] == col))|| ((arr[0][i] == col) && (arr[1][i] == row))){
                    break;
                }
                else if(((arr[0][i] != row) && (arr[1][i] != col) && i == count)|| ((arr[0][i] != col) &&
                        (arr[1][i] != row)&& i == count)){
                    arr[0][count] = row;
                    arr[1][count] = col;
                    count ++;
                    break;
                }
            }
        }
        for(int i = 0; i < 15; i++){
            System.out.println(arr[0][i] + " x " + arr[1][i]);
        }
    }

    //----------------------- Задание 9 ----------------------------------------
    public static void task9(){
        System.out.println("Введите строку");
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.nextLine();
        System.out.println("Введите подстроку, которую необходимо заменить");
        String str2 = sc1.nextLine();
        System.out.println("Введите подстроку на которую меняем");
        String str3 = sc1.nextLine();
        String newstr = str.replace(str2, str3);
        System.out.println(newstr);
    }

    //----------------------- Задание 10 ----------------------------------------
    public static void task10(){
        System.out.println("Введите строку");
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.nextLine();
        char[] arrChar = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j < arrChar.length; j++){
                if(arrChar[i] == arrChar[j]){
                    arrChar[j] = 0;
                }
            }
        }
        for(char ch : arrChar){
            if(ch != 0 && ch != ' '){
              sb.append(ch);
            }
        }
        System.out.println(sb);
    }

    //----------------------- Задание 11 ----------------------------------------
    public static void task11(){
        System.out.println("Введите адресс");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = str.replaceAll("[^0-9\\s+]", "");// Убираем все кроме цифр и пробелов
        int count = 0; // счетчик чисел
        char[] ch = str1.toCharArray(); // массив цифр и пробелов
        for(int i = 0; i < ch.length; i++){ // считаем количество чисел для задания размера массива интов
            if(ch[i] == '\u0020' && ch[i+1] !='\u0020'){ // если выбранный элемент является пробелом, а следующей цифрой
                count+=1;
            }
        }
        int[] arr = new int[count];
        boolean b = true;
        String s = "";
        int count2 = 0; // счетчик пройденных элементов массива char
        for(int i = 0; i < arr.length; i++){
            b = true;
            s = "";
            while(b){
                for(int j = count2; j < ch.length; j++){
                    if(ch[j] == '\u0020' && ch[j+1] !='\u0020'){ // если выбраный элемент является пробелом, а
                        // следующий нет
                        count2+=1;
                    }
                    if(ch[j] == '\u0020' && ch[j+1] =='\u0020'){ // если выбраный элемент является пробелом и
                        // следующий тоже
                        count2+=1;
                    }
                    else if(j == ch.length - 1 && ch[j] !='\u0020'){ // если выбраный элемент является последним в
                        // массиве char и не является пробелом
                        count2+=1;
                        s += ch[j];
                        break;
                    }
                    else if (ch[j] !='\u0020' && ch[j+1] != '\u0020'){ // если выбраный элемент не является пробелом и
                        // следующий элемент тоже
                        count2+=1;
                        s += ch[j];

                    }

                    else if(ch[j] !='\u0020' && ch[j+1] == '\u0020'){ // если выбраный элемент не является пробелом, а
                        // следующий элемент является пробелом
                        count2+=1;
                        s += ch[j];
                        break;
                    }
                }
                b = false;
            }
            arr[i] = Integer.parseInt(s);
        }
        System.out.println(Arrays.toString(arr));
    }
}
