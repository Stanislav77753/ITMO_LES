package school.humans.teacher;

import java.util.HashMap;

public class Questions {
    private  HashMap mathMap = new HashMap();
    private  HashMap<String, Integer> physicsMap = new HashMap<String, Integer>();

    public HashMap<String, Integer > getMathMap() {
        mathMap.put("Сколько буде 1 + 1", 2);
        mathMap.put("Сколько буде 9 - 1", 8);
        mathMap.put("Сколько буде 3 * 2", 6);
        mathMap.put("Сколько буде 4 * 3", 12 );
        mathMap.put("Сколько буде 20 / 2", 10 );
        return mathMap;
    }
}
