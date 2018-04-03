package diary.dairy.pages;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Page {
    private Data data;
    private HashMap<Time, Line> fiilPage;
    public Page(Data data, HashMap<Time, Line> fillPage){
        this.data = data;
        this.fiilPage = fillPage;
    }

    public Data getData() {
        return data;
    }

    public HashMap<Time, Line> getFiilPage() {
        return fiilPage;
    }
}
