package lessons_13_04;

public class MyStack<T> {
    private int top;
    private T[] stack;
    private int size;

    public MyStack(int size){
        this.size = size;
        this.stack = (T[]) new Object [size];
        this.top = -1;
    }
    public void push(T element){
        if(this.top == this.size - 1){
            System.out.println("Стек заполенен");
        }
        else{
            this.stack[++top] = element;
        }
    }

    public T pop(){
        if(this.top == -1){
            System.out.println("Стек пуст");
            return null;
        }
        else{
             return this.stack[top--];
        }
    }
}
