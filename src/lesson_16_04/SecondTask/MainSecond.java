package lesson_16_04.SecondTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainSecond {
    public static final String ADD = "add data";
    public static final String SHOW = "show data";
    public static final String CLOSE = "close";
    private Map<String, Map<String, Integer>> mapUsers = new HashMap<>();

    public Map<String, Map<String, Integer>> getMapUsers(){
        return mapUsers;
    }

    public void addMapUsers(String str){
        Map<String, Integer> mapGoods = new HashMap<>();
        String[] arr= str.split(" ");
        String name = arr[0];
        String good = arr[1];
        int numGood = Integer.parseInt(arr[2]);
        if(this.mapUsers.containsKey(name)){
            mapGoods = mapUsers.get(name);
            if(mapGoods.containsKey(good)){
                mapGoods.put(good,mapGoods.get(good+numGood));
            }
            else{
                mapGoods.put(good, numGood);
            }
        }
        else{
            mapGoods.put(good, numGood);
        }
        this.mapUsers.put(name, mapGoods);
    }

    public void showMapUsers(){
        for(Map.Entry<String, Map<String, Integer>> entry : mapUsers.entrySet()){
            System.out.println(entry.getKey() + " ");
            for(Map.Entry<String, Integer> entry1 : mapUsers.get(entry.getKey()).entrySet()){
                System.out.println(entry1.getKey() + " " + entry1.getValue());
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainSecond mainSecond = new MainSecond();

        while(true){
            System.out.println("Введите чего-нибудь");
            String str = scanner.nextLine();
            if(str.equals(ADD)){
                String str1 = scanner.nextLine();
                mainSecond.addMapUsers(str1);


            }
            if(str.equals(SHOW)){
                mainSecond.showMapUsers();
            }
            if(str.equals(CLOSE)){

            }
        }
    }
}
