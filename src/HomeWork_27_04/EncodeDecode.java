package HomeWork_27_04;

import java.io.*;
import java.util.LinkedList;

public class EncodeDecode {
    public void encodeDecodeFile(File source, File encoded, String key)throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(encoded))){
            byte[] buffer = new byte[(int)source.length()];
            byte[] keyBytes = key.getBytes();
            LinkedList<Byte> byteList = new LinkedList();
            for (Byte b : keyBytes){
                byteList.add(b);
            }
            int smth;
            while((smth = is.read(buffer)) > 0){
                for(int i = 0; i < buffer.length; i++)
                    os.write(buffer[i] ^ byteList.getFirst());
            }
        }
    }
}
