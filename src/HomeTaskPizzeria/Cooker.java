package HomeTaskPizzeria;

public class Cooker extends Thread {
    private String name;
    private Order order;

    public Cooker(String name, Order order){
        this.name = name;
        this.order = order;
    }

    private void takeOrder(){
        while (true) {
            synchronized (this.order) {
                try {
                    order.wait(10);
                    if (order.readyWaiter == true) {
                        System.out.println("Заказ принят поваром" + "   " + Thread.currentThread().getClass());
                        order.readyWaiter = false;
                        transferOrder();
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void transferOrder(){
        synchronized (this.order) {
            order.readyCooker = true;
            order.notify();
            System.out.println("Заказ готов и отправлен официанту" + "   " + Thread.currentThread().getClass());
        }
    }

    @Override
    public void run() {
        takeOrder();
    }
}
