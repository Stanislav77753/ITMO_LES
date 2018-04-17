package lesson_16_04.FirstTask;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Stas on 16.04.2018.
 */
public class MainFirst {
    public static void main(String[] args) {
//        // первое задание
//        DuplicateNumbers dm = new DuplicateNumbers();
//        dm.setNumStr();
//        dm.printListNumbers(dm.listNumbers(dm.stringToNumberArray(dm.getStr())));
//        System.out.println();
//        // второе задание
//        DuplicateNumbersCount dnc = new DuplicateNumbersCount();
//        dnc.setNumStr();
//        System.out.println(dnc.DuplicateNumbersCount(dnc.createMap(dnc.stringToNumberArray(dnc.getStr()))));
//        System.out.println();
        // третье задание
        Palindrom pal = new Palindrom();
        pal.setNumStr();
        pal.printListPal(pal.findPalindrom(pal.stringToNumberArray(pal.getStr())));
    }
}
