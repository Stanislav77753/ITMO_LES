
public class stringLesson {
    public static void main(String[] args) {
        String str = "String";
        String str1 = new String("String 2");

        String st = String.format("шаблон со специальными символами %d%n", 3232);
       // System.out.println(st);

        StringBuilder sb = new StringBuilder(); // изменяемый объект  (требует меньше ресурсов, но не безопасен для потоков)
        StringBuffer sf = new StringBuffer(); // изменяемый объект (требует больше ресурсов и безопасен для потоков)

        sb.append("some new").append("new");
        sb.insert(3, "some new").append(" new ");
        //System.out.println(sb);

        String stFromLoop = "";
        StringBuilder sbLoop = new StringBuilder();
        long start=System.nanoTime();
        for(int i = 0; i < 10; i++){
            //sbLoop.append("number: ").append(i); // редпочтительнее
            // в java9 StringConcatFactory
            stFromLoop += "number" + i;
        }
        long end = System.nanoTime();
        System.out.println((start - end)/1000000.0);


        // сравнение строк
        str.equals(str1);
        str.equalsIgnoreCase(str1); // игнорируется регистр
        str.startsWith("dfsg"); //проверяет начинается ли строка с аргумента
        str.endsWith("gsg"); //проверяет заканчивается ли строка аргументом


        str1.compareTo(str);  // возвращает ноль если апгумент лексически равен строке, вернет больше 0  если аргумент
        // больше строки и меньше нуля если наоборот
        str1.compareToIgnoreCase(str); // возвращает ноль если апгумент лексически равен строке, вернет больше 0
        // если аргумент больше строки и меньше нуля если наоборот

        str.length(); // длина строки

    }
}
