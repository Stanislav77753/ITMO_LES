package bankTask;

public class Bank implements Runnable {
    private Account src;
    private Account dst;
    private int amount;

    public Bank(Account src, Account dst, int amount) {
        this.src = src;
        this.dst = dst;
        this.amount = amount;
    }

    public  static void transferMoney(Account src, Account dst, int amount){
        new Thread(new Bank(src,dst,amount)).start();

    }


    @Override
    public void run() {
        synchronized (this.src){
            while (this.src.isFlag()){
                try {
                    System.out.println("++++++++++");
                    src.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.src.setFlag(true);
            synchronized (this.dst){
                while (this.dst.isFlag()){
                    try {
                        System.out.println("-----------");
                        this.dst.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.dst.setFlag(true);

                this.dst.setAmount(this.src.getAmount(this.amount));
                this.src.setFlag(false);
                this.dst.setFlag(false);
            }
        }

    }
}
