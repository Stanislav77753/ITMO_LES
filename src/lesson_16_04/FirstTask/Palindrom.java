package lesson_16_04.FirstTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrom implements HandlerString {
    private String str;
    private List<String> list = new ArrayList<>();

    public String getStr() {
        return str;
    }

    @Override
    public String[] stringToNumberArray(String str) {
        return str.replaceAll("[^A-Za-zА-Яа-я]", " ").trim().replaceAll("\\s+",
                " ").split(" ");
    }

    @Override
    public void setNumStr() {
        System.out.println("Введите строку со словами");
        Scanner sc = new Scanner(System.in);
        this.str = sc.nextLine();
        while(true){
            if(str.replaceAll("[A-Za-zА-Яа-я]", " ").trim().replaceAll("\\s+",
                    " ").split(" ").length > 1){
                System.out.println("Введите строку только со словами!!!!");
                this.str = sc.nextLine();
            }
            else{
                break;
            }
        }
    }
    public List<String> findPalindrom(String[] arr){
        for(int k = 0; k < arr.length; k++) {
            StringBuilder sb = new StringBuilder(arr[k]);
            //sb.append(arr[k]);
            String str = sb.reverse().toString();
            if(arr[k].equals(str)){
                this.list.add(arr[k]);
            }
        }
        return this.list;
    }
    public void printListPal(List<String> list){
        System.out.println("Палиндромы:");
        for(String s: list){
            System.out.print(s + ", ");
        }

    }
}
