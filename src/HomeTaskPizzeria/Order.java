package HomeTaskPizzeria;

public class Order {
    private String pizza;
    private String juice;
    public boolean readyClient = false;
    public boolean readyWaiter = false;
    public boolean readyCooker = false;
    public boolean readyOrder = false;


    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getJuice() {
        return juice;
    }

    public void setJuice(String juice) {
        this.juice = juice;
    }
}
