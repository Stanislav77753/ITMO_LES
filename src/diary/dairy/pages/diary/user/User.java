package diary.dairy.pages.diary.user;

import diary.dairy.pages.Line;
import diary.dairy.pages.Time;

import java.util.HashMap;
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
    public HashMap<Time, Line> makeEntry(HashMap<Time, Line> fillPage, int hour, int minute, String str){
        fillPage.put(new Time(hour, minute),new Line(str));
        return fillPage;
    };
}
