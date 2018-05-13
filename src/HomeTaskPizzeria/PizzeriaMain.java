package HomeTaskPizzeria;

public class PizzeriaMain {

    public static void main(String[] args) {
        Order order = new Order();
        Client client = new Client("Client1", order);
        Waiter waiter = new Waiter("Waiter1", order);
        Cooker cooker = new Cooker("Cooker1", order);
        client.start();
        waiter.start();
        cooker.start();

    }
}
