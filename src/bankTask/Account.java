package bankTask;

public class Account {
    private int  amount;
    private final int id;
    private final int userId;
    private boolean flag = false;

    public Account(int amount, int id, int userId) {
        this.amount = amount;
        this.id = id;
        this.userId = userId;
    }

    public int getAmount(int amount){
        this.amount -= amount;
        return amount;
    }

    public int setAmount(int amount){
        this.amount+=amount;
        return this.amount;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public void print (){
        System.out.println(this.amount);
    }
}
