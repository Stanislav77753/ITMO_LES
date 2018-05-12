package HomeTaskDecorator;

import lessons_13_04.MyQueue;

import java.io.*;

public class CryptoOutputStream extends FilterOutputStream {
    private MyQueue<Byte> queue;

    public CryptoOutputStream(OutputStream out, String password) {
        super(out);
        if(password == null){
            throw new IllegalArgumentException("Пароль не может быть null!!!!");
        }
        this.queue = new MyQueue<>(password.length());
        byte[] passByte = password.getBytes();
        for(byte tByte : passByte){
            this.queue.offer(tByte);
        }
    }

    @Override
    public void write(int b) throws IOException {
        byte tempByte = queue.remove();
        int res = b ^ tempByte;
        queue.offer(tempByte);
        super.write(res);
    }
}
