package HomeTaskPizzeria;

public class Waiter extends  Thread {
    private String name;
    private Order order;

    public Waiter(String name, Order order){
        this.name = name;
        this.order = order;
    }

    private void takeAnOrder(){
        while (true) {
            synchronized (this.order) {
                try {
                    order.wait(1);
                    if (order.readyClient == true) {
                        System.out.println("Заказ принят официантом" + "   " + Thread.currentThread().getClass());
                        order.readyClient = false;
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
            order.readyWaiter = true;
            order.notify();
            System.out.println("Заказ отправлен повару" + "   " + Thread.currentThread().getClass());
            placeOrder();
        }
    }

    private void placeOrder() {
        synchronized (this.order) {
            try {
                order.wait(1);
                if (order.readyCooker == true) {
                    System.out.println("Заказ подается клиенту" + "   " + Thread.currentThread().getClass());
                    order.readyCooker = false;
                    order.readyOrder = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        takeAnOrder();

    }

}
