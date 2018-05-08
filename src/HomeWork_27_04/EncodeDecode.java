package HomeWork_27_04;

import lessons_13_04.MyQueue;

import java.io.*;
import java.util.LinkedList;

public class EncodeDecode {
    public void encodeDecodeFile(File source, File encoded, String key)throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(encoded))) {
            byte[] buffer = new byte[(int) source.length()];
            byte[] keyBytes = key.getBytes();
            MyQueue<Byte> queue = new MyQueue<>(keyBytes.length);
            for (Byte b : keyBytes) {
                queue.offer(b);
            }
            int smth;
            byte b;
            while ((smth = is.read(buffer)) > 0) {
                for (int i = 0; i < buffer.length; i++) {
                    b = queue.remove();
                    os.write(buffer[i] ^ b);
                    queue.offer(b);
                }
            }
        }
    }
    public void encodeDecodeFile(File source, File encoded, File password)throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(encoded))){
            byte[] buffer = new byte[(int)source.length()];
            byte[] keyBytes = new byte[(int) password.length()];
            MyQueue<Byte> queue = new MyQueue<>(keyBytes.length);
            try(InputStream isp = new BufferedInputStream(new FileInputStream(password))){
                int smth;
                while((smth = isp.read(keyBytes)) > 0){
                    for(int i = 0; i < keyBytes.length; i++){
                        queue.offer(keyBytes[i]);
                    }
                }
            }


            int smth2;
            byte b;
            while((smth2 = is.read(buffer)) > 0) {
                for (int i = 0; i < buffer.length; i++) {
                    b = queue.remove();
                    os.write(buffer[i] ^ b);
                    queue.offer(b);
                }
            }
        }
    }
}
