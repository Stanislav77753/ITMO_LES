package HomeTaskPizzeria;

import sun.awt.windows.ThemeReader;

import java.util.Scanner;

public class Client extends Thread {
    private Order order;
    private String nameClient;

    public Client(String name, Order order){
        this.nameClient = name;
        this.order = order;
    }
    private void makeAnOrder(){
            synchronized (this.order) {
                Scanner scn = new Scanner(System.in);
                System.out.println("Введите выбранную пиццу" + "   " + Thread.currentThread().getClass());
                order.setPizza(scn.nextLine());
                System.out.println("Введите выбранный сок" + "   " + Thread.currentThread().getClass());
                order.setJuice(scn.nextLine());
                order.readyClient = true;
                System.out.println("Заказ клиентом сделан и передан официанту" + "   " + Thread.currentThread().getClass());
                order.notify();

            }
    }

    private void receiveOrder(){
        while (true) {
            synchronized (this.order) {
                try {
                    order.wait(1);
                    if (order.readyOrder == true) {
                        System.out.println("Заказ получен клиентом" + "   " + Thread.currentThread().getClass());
                        order.readyOrder = false;
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void run() {
        makeAnOrder();
        receiveOrder();
    }

}
