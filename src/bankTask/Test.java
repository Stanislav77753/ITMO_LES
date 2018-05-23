package bankTask;

public class Test {
    public static void main(String[] args) {
        User user1 = new User(1, "email1");
        Account account1 = new Account(500, 1, 1 );
        Account account2 = new Account(1000, 2, 1);
        user1.addAccount(account1);
        user1.addAccount(account2);
        Bank.transferMoney(account1,account2,  100);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account1.print();
        account2.print();
        Bank.transferMoney(account1,account2,  100);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account1.print();
        account2.print();




    }
}
