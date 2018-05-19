package HomeTaskPizzeria;

import java.util.Queue;
import java.util.Scanner;

public class Client extends Thread {
    private Queue<Order> orderQueue;
    private Queue<Order> orderCooker;
    private Order orderClient;
    private String nameClient;


    public Client(String name, Queue<Order> orderQueue, Queue<Order> orderCooker, Order orderClient){
        this.nameClient = name;
        this.orderQueue = orderQueue;
        this.orderClient = orderClient;
        this.orderCooker = orderCooker;


    }
    private void makeAnOrder() {
        synchronized (orderQueue) {
            orderClient.setReadyClient(true);
            System.out.println(nameClient + " заказ сделал и передал его официанту");
            orderQueue.add(orderClient);
            orderQueue.notifyAll();

        }
    }


    private void receiveOrder() {
        synchronized (orderCooker) {
            while (true) {
                if(orderCooker.peek() == null){
                    try {
                        orderCooker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(orderCooker.peek().isReadyOrder() == true){
                    Order order = orderCooker.remove();
                    System.out.println(nameClient + " получил заказ");
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        Thread.currentThread().setName(nameClient);
        System.out.println(Thread.currentThread().getName() + " стартовал");
        makeAnOrder();
        receiveOrder();
    }

}
