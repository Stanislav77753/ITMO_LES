package lesson_16_04.FirstTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Stas on 17.04.2018.
 */
public class DuplicateNumbersCount implements HandlerString {
    private String str;

    @Override
    public String[] stringToNumberArray(String str) {
        return str.replaceAll("[^0-9]", " ").trim().replaceAll("\\s+",
                " ").split(" ");
    }

    public String getStr() {
        return str;
    }

    @Override
    public void setNumStr(){
        System.out.println("Введите строку с числами");
        Scanner sc = new Scanner(System.in);
        this.str = sc.nextLine();
        while(true){
            if(str.replaceAll("\\d+", " ").trim().replaceAll("\\s+",
                    " ").split(" ").length > 1){
                System.out.println("Введите строку только с числами!!!!");
                this.str = sc.nextLine();
            }
            else{
                break;
            }
        }
    }

    public  HashMap<String, Integer> createMap(String[] arr){
        HashMap<String, Integer> map = new HashMap<>();
        int count;
        String[] arr2 = arr.clone();
        outer: for(int i = 0; i < arr.length-1; i++){
            count = 1;
            for(int k = i - 1; k >= 0; k--){
                if(arr[k].equals(arr[i])){
                    continue outer;
                }
            }
            for(int j = i+1; j < arr2.length; j++){
                if(arr[i].equals(arr2[j])){
                    count+=1;
                }
            }
            map.put(arr[i], count);
        }
        return map;
    }

    public int DuplicateNumbersCount(Map<String, Integer> map){
        int count = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()!= 1){
                count+=1;
            }
        }
        System.out.print("Количество повторяющихся чисел равно :");
        return count;
    }

}
