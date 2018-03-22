
public class DataTypes {

    public static void main(String[] arg) {

        short a = 1;
        short b = 3;
        short c = (short) (a + b); // опреация + суммирует short как int

        int a1 = 8;
        int b1 = 3;
        int c1 = a1 / b1;
        System.out.println(c1);

        float a2 = 0.2f;
        float b2 = 0.3f;
        float c2 = a2 * b2;
        System.out.println(c2);

        double a3 = 0.2;
        double b3 = 0.3;
        double c3 = a3 * b3;
        System.out.println(c3);

        char char1 = 74;
        char char2 = 'a';
        char char3 = 118;
        char char4 = 97;
        System.out.println(char1 + "  " + char2 + "   " + char3 + "   " + char4);
        char char5 = '\u0054';
        System.out.println(char5);
        int a5 = 65; // число
        Integer a6 = 120; //ссылка на объект


        byte x = Byte.parseByte("100");
        int x1 = Integer.parseInt("100");
        short x2 = Short.parseShort("100");
        long x3 = Long.parseLong("100");
        double x4 = Double.parseDouble("100.9");
        float x5 = Float.parseFloat("100.9");
        System.out.println(x1);

        String str = "String";
        String str2 = "String";

        String str3 = new String("String");
        String str4 = new String("String");

        System.out.println(str == str2);
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));
    }
}
