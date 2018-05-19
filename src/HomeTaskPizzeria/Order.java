package HomeTaskPizzeria;

public class Order {
    private String pizza;
    private String juice;
    public boolean readyClient = false;
    public boolean readyWaiter = false;
    public boolean readyCooker = false;
    public boolean readyOrder = false;

    public Order(String pizza, String juice) {
        this.pizza = pizza;
        this.juice = juice;
    }

    public boolean isReadyClient() {
        return readyClient;
    }

    public void setReadyClient(boolean readyClient) {
        this.readyClient = readyClient;
    }

    public boolean isReadyWaiter() {
        return readyWaiter;
    }

    public void setReadyWaiter(boolean readyWaiter) {
        this.readyWaiter = readyWaiter;
    }

    public boolean isReadyCooker() {
        return readyCooker;
    }

    public void setReadyCooker(boolean readyCooker) {
        this.readyCooker = readyCooker;
    }

    public boolean isReadyOrder() {
        return readyOrder;
    }

    public void setReadyOrder(boolean readyOrder) {
        this.readyOrder = readyOrder;
    }


}
