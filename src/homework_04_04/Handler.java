package homework_04_04;

import java.io.IOException;
import java.util.HashMap;

public class Handler {

    public Handler getInstanse(String filename){
        Handler object = new Handler();
        switch (extension(filename)){
            case "xml":
                object = new XmlHandler();
                break;
            case "json":
                object = new JsonHandler();
                break;
        }
        return object;
    }
    public static String extension(String filename){
        String ext = "";
        int i = filename.lastIndexOf('.');
        ext = filename.substring(i + 1);
        return ext;
    }
    public void writeInFile(String filename, HashMap<String, String> map){};
    public void readFromFile(){};

}
