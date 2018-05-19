package HomeTaskPizzeria;


import java.util.PriorityQueue;
import java.util.Queue;

public class PizzeriaMain {

    public static void main(String[] args) throws InterruptedException {
        Order orderClient = new Order("pizza", "juice");
        Queue<Order> orderQueue = new PriorityQueue<>();
        Queue<Order> orderCooker = new PriorityQueue<>();
        Client client = new Client("Client1", orderQueue, orderCooker, orderClient);
        Waiter waiter = new Waiter("Waiter1", orderQueue, orderCooker);
        Cooker cooker = new Cooker("Cooker1", orderQueue, orderCooker);

        cooker.start();
        waiter.start();

        Thread.sleep(1000);

        client.start();

        System.out.println("Стартовали все потоки");

    }
}
