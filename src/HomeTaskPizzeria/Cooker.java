package HomeTaskPizzeria;

import java.util.Queue;

public class Cooker extends Thread {
    private Queue<Order> orderCooker;
    private Queue<Order> orderQueue;
    private String name;

    public Cooker(String name, Queue<Order> orderQueue, Queue<Order> orderCooker){
        this.name = name;
        this.orderQueue = orderQueue;
        this.orderCooker = orderCooker;
    }

    private void takeOrder(){
        synchronized (orderQueue){
            while (true){
                if(orderQueue.peek() == null || orderQueue.peek().isReadyWaiter() == false){
                    try {
                        orderQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(orderQueue.peek().isReadyWaiter() == true) {
                    Order order = (Order) orderQueue.remove();
                    System.out.println(name + " принял заказ");
                    order.setReadyWaiter(false);
                    order.setReadyCooker(true);
                    System.out.print(name + " заказ сделал");
                    orderCooker.offer(order);
                    break;
                }
            }
        }
    }
    private void enterToWaiter(){
        synchronized (orderCooker){
            while(true){
                if(orderCooker.peek() == null){
                    try {
                        orderCooker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(orderCooker.peek().isReadyCooker() == true){
                    System.out.println(" и передал его официанту");
                    orderCooker.notifyAll();
                    break;
                }
            }

        }
    }


    @Override
    public void run() {
        Thread.currentThread().setName(name);
        System.out.println(Thread.currentThread().getName() + " стартовал");
        takeOrder();
        enterToWaiter();

    }
}
