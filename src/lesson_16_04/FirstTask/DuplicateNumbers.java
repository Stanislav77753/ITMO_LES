package lesson_16_04.FirstTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuplicateNumbers implements HandlerString {
    private String str;

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
    @Override
    public  String[] stringToNumberArray(String str){
        return str.replaceAll("[^0-9]", " ").trim().replaceAll("\\s+",
                " ").split(" ");
    }

    public  List<String> listNumbers(String[] arr){
        int count;
        List<String> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            count = i;
            for(int j = i - 1; j >= 0; j --){
                count -=1;
                if(arr[i].equals(arr[j])){
                    break;
                }
                else if(!arr[i].equals(arr[j]) && count == 0){
                    list.add(arr[i]);
                }
            }
        }
        return list;
    }
    public  void printListNumbers(List<String> list){
        System.out.println("Числа, которые не повторяются:");
        for(String s: list){
            System.out.print(s + " ");
        }

    }

}
