package calculator;

public class Accumm {
    private int value;
    private Operation operation;
    public Accumm(Operation operation, int value){
        this.value = value;
        this.operation = operation;

    }
    protected void accum(int a){

        this.value =this.operation.execute(this.value,a);
    }
    public int getValue(){
        return this.value;
    }

    public static void main(String[] args) {
        Accumm acc = new Accumm(new Divide(), 3);
        acc.accum(3);
        System.out.println("Текущее значение равно " + acc.getValue());

    }
}
