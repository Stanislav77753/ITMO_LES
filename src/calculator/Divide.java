package calculator;

public class Divide extends Operation{
    @Override
    protected int execute(int a, int b) {
        if(b == 0){
            System.out.println("На ноль делить нельзя");
            return a;
        }
        return a/b;
    }
}
