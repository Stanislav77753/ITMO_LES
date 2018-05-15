package HomeTaskTop100;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Stas on 15.05.2018.
 */
public class MyValueComp implements Comparator<String> {
    private Map<String, Integer> map;

    public MyValueComp(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(String o1, String o2) {
        return map.get(o2).compareTo(map.get(o1));
    }
}
