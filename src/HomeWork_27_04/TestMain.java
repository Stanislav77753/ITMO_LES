package HomeWork_27_04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args)  {
        FileHandler ts = new FileHandler();
        File source = new File("src/HomeWork_27_04/wp.txt");
        File target = new File("src/HomeWork_27_04/target.txt");
        //копируем файл
        try {
            ts.copyFileUsingStream(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
/*        // копируем файл с помощью nio
        try {
            ts.copyFile(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        // режем файл на части указанной длины
/*        try {
            ts.splitFileOnParts(source, 1024*1024);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        // создаем лист с файлами которые будем склеивать
        List<String> fileList = new ArrayList();
        fileList.add("src/HomeWork_27_04/part1.txt");
        fileList.add("src/HomeWork_27_04/part2.txt");
        try {
            ts.glueFiles(fileList, "src/HomeWork_27_04/New.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Зашифровать файл паролем XOR
        EncodeDecode ed = new EncodeDecode();
        File sourceEncodeDecode = new File("src/HomeWork_27_04/part1.txt");
        File encode = new File("src/HomeWork_27_04/encode.txt");
        File decode = new File("src/HomeWork_27_04/decode.txt");
        String key = "passwordPassword";
        try {
            ed.encodeDecodeFile(sourceEncodeDecode, encode, key);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // Расшифровать файл паролем
//
        try {
            ed.encodeDecodeFile(encode, decode, key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
