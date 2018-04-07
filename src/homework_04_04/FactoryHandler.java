package homework_04_04;

import java.io.IOException;
import java.util.HashMap;

public class FactoryHandler {

    public Handler getInstanse(String filename){

      if(extension(filename).equals("xml")){
          return new XmlHandler();
      }
      else
          return new JsonHandler();
    }
    public static String extension(String filename){
        String ext = "";
        int i = filename.lastIndexOf('.');
        ext = filename.substring(i + 1);
        return ext;
    }
}
