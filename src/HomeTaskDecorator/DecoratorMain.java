package HomeTaskDecorator;

import java.io.*;

public class DecoratorMain {
    public static void main(String[] args) throws IOException {
        File sourse = new File("src/HomeTaskDecorator/wp.txt");
        File encode = new File("src/HomeTaskDecorator/encode.txt");
        File decode = new File("src/HomeTaskDecorator/decode.txt");
        String password = "Password";
        //Шифруем файл
        try(InputStream in = new CryptoInputStream(new FileInputStream(sourse), password);
            OutputStream os = new FileOutputStream(encode)){
            int smth;
            while ((smth=in.read()) != -1){
                os.write(smth);
            }
        }
        //Разшифровываем файл
        try(InputStream in = new FileInputStream(encode);
        OutputStream out = new CryptoOutputStream(new FileOutputStream(decode), password)){
                int smth;
                while ((smth = in.read()) != -1){
                    out.write(smth);
                }
        }
    }
}
