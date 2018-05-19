package HomeTaskPizzeria;

import com.sun.org.apache.xpath.internal.operations.Or;
import lessons_13_04.MyQueue;

import java.util.Queue;

public class Waiter extends  Thread {
    private Queue<Order> orderCooker;
    private Queue<Order> orderQueue;
    private String name;


    public Waiter(String name, Queue<Order> orderQueue, Queue<Order> orderCooker){
        this.name = name;
        this.orderQueue = orderQueue;
        this.orderCooker = orderCooker;
    }

    private void takeAnOrder(){
        synchronized (orderQueue){
            while (true){
                if(orderQueue.peek() == null || orderQueue.peek().isReadyClient() == false){
                    try {
                        orderQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (orderQueue.peek().isReadyClient() == true) {
                    orderQueue.peek().setReadyClient(false);
                    orderQueue.peek().setReadyWaiter(true);
                    System.out.println(name + " заказ принял и отправил его повару");
                    orderQueue.notifyAll();
                    break;
                }
            }
        }
    }


    private void placeOrder() {
        synchronized (orderCooker) {
            while(true){
                if(orderCooker.peek() == null || orderCooker.peek().isReadyCooker() == false){
                    try {
                        orderCooker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(orderCooker.peek().isReadyCooker() == true){
                    System.out.println(name + " передает заказ клиенту");
                    Order order = (Order)orderCooker.remove();
                    order.setReadyCooker(false);
                    order.setReadyOrder(true);
                    orderCooker.offer(order);
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
        takeAnOrder();
        placeOrder();





    }

}
