package calculator;


public class Multiply extends Operation{
    @Override
    protected int execute(int a, int b) {
        System.out.println(a * b);
        return a * b;
    }
}
