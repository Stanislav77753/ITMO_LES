package diary;

import diary.dairy.pages.Data;
import diary.dairy.pages.Line;
import diary.dairy.pages.Page;
import diary.dairy.pages.Time;
import diary.dairy.pages.diary.user.User;

import java.util.HashMap;
import java.util.Map;

public class Dairy {
    public static void main(String[] args) {
        User Stas = new User("Stas");
        Data data1 = new Data(01, 01,2018);
        HashMap<Time, Line> fillPage1 = new HashMap<>();
        Page page1 = new Page(data1, fillPage1);

        Stas.makeEntry(page1.getFiilPage(), 12,30, "Не забудь сделать дз");

        for(Map.Entry<Time, Line> map : fillPage1.entrySet()){
            System.out.println(map.getKey().getTime() + "   " + map.getValue().getLine());
        }

        //System.out.println(page1.getData());

    }
}
