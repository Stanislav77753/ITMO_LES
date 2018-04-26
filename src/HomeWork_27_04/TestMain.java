package HomeWork_27_04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws IOException {
        FileHandler ts = new FileHandler();
        File source = new File("wp.txt");
        File target = new File("t2.txt");
        //ts.copyFileUsingStream(source, target);
        //ts.copyFile(source, target);
        ts.splitFileOnParts(source,1024*1024);
        List<String> fileList = new ArrayList();
        fileList.add("part1.txt");
        fileList.add("part2.txt");
        ts.glueFiles(fileList, "New.txt");
    }
}
