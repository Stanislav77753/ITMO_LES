package lessons_13_04;

public class MyQueue<T> {
    private T[] queue;
    private int size;
    private int nElem;
    private int front;
    private int end;

    public MyQueue(int size){
        this.size = size;
        this.queue = (T[]) new Object[size];
        this.nElem = 0;
        this.front = 0;
        this.end = -1;
    }

    public boolean offer(T elemement){
        boolean flag = false;
        if(end == size - 1){
            end = -1;
        }
        if(nElem < size){
            queue[++end] = elemement;
            nElem++;
            flag = true;
        }
        else{
            throw new IndexOutOfBoundsException("Очередь полна");
        }
        return flag;
    }

    public T remove(){
        T temp = queue[front++];
        if(front == size){
            front = 0;
        }
        nElem--;
        return temp;
    }

    public T peek(){
        return queue[front];
    }
}
