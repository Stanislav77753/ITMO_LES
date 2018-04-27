package lessons_13_04;


import java.util.*;
import java.util.LinkedList;

public class MainTest {
    public static void main(String[] args) {

    /*    // Задание с планетами
        Planets[] planets = Planets.values();
        for(int i = 0; i < planets.length; i ++){
            System.out.println(planets[i] + " " + " масса : " +  planets[i].getMass()+ " "
                    + " радиус : " +  planets[i].getRasius()+ " "
                    + " радиус орбиты " + planets[i].getRadiusOrbita());
        }*/
        //--------------------------------------------------------

/*        // Задание с LinkedList
        lessons_13_04.LinkedList newList = new lessons_13_04.LinkedList();

        newList.addLast("Firts Element");
        newList.addLast("Second Element");
        newList.addLast("Third Element");
        System.out.println("размер листа: " + newList.size());
        for(int i = 0; i < newList.size(); i++){
            System.out.println(newList.getElementByIndex(i));
        }
        System.out.println("--------------------------");
        newList.addFirst("One");
        newList.addFirst("Zero");
        for(int i = 0; i < newList.size(); i++){
            System.out.println(newList.getElementByIndex(i));
        }*/

/*        // Задание Stack
        MyStack myStack = new MyStack(10);
        myStack.push("one");
        myStack.push("two");
        myStack.push("three");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println("------------");
        MyStack myStack1 = new MyStack(5);
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        myStack1.push(4);
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
   */

        MyQueue<String> queue = new MyQueue<>(10);
        for(int i = 0; i < 10; i++){
            System.out.println(queue.offer("Строка: " + i));
        }

        for(int i = 0; i < 3; i++){
            System.out.println(queue.remove());
        }

        System.out.println(queue.peek());
    }


}
