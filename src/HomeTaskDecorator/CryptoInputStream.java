package HomeTaskDecorator;

import lessons_13_04.MyQueue;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {
    //private byte[] password;
    private MyQueue<Byte> queue;
    public CryptoInputStream(InputStream in, String password) {
        super(in);
        if(password == null){
            throw new IllegalArgumentException("Пароль не может быть null!!!!");
        }
        this.queue = new MyQueue<>(password.length());
        byte[] passByte = password.getBytes();
        for(byte tByte : passByte){
            this.queue.offer(tByte);
        }
        //this.password = password.getBytes();
    }

    @Override
    public int read() throws IOException {
        byte tempByte;
        int smth;
        if((smth = super.read()) != -1){
            tempByte = queue.remove();
            smth^=tempByte;
            queue.offer(tempByte);
            return smth;
        }
        return -1;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int res = super.read(b);
        byte tempByte;
        byte[] tempB = new byte[b.length];
        System.arraycopy(b,0,tempB,0,b.length);
        for(int i = 0; i < tempB.length; i++){
            tempByte = queue.remove();
            b[i] = (byte)(tempB[i]^tempByte);
            queue.offer(tempByte);
        }
        return res;
    }
}
