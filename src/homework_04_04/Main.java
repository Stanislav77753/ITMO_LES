package homework_04_04;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Handler handler1 = new Handler().getInstanse("file.xml");
        System.out.println(handler1.getClass());
        Handler handler2 = new Handler().getInstanse("file.json");
        System.out.println(handler2.getClass());
    }
}
