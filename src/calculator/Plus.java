package calculator;

public class Plus extends Operation{
    @Override
    protected int execute(int a, int b) {
        return a + b;
    }
}
