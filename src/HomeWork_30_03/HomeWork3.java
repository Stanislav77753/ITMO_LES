package HomeWork_30_03;

import java.lang.reflect.Array;
import java.util.*;

public class HomeWork3 {
    public static void main(String[] args) {

        // Задание по фигурам
        Shape rect= new Shape(new Point(1, 1), new Point(3,3),
                new Point(3,1), new Point(1, 3));
        Shape circle = new Shape(new Point(5,5),10);
        Shape triangle = new Shape(new Point(0,0), new Point(4,8), new Point(8,0));
/*        System.out.println("Периметр прямоугольника = " + rect.perRectangle(rect));
        System.out.println("Площадь прямоугольника = " + rect.squareRectangle(rect));
        System.out.println("Длина окружности = " + circle.lengthCircle(circle));
        System.out.println("Площадь круга = " + circle.squareCircle(circle));
        System.out.println("Периметр треугольника = " + triangle.perTriangle(triangle));
        System.out.println("Площадь треугольника = " + triangle.squareTriangle(triangle));*/

        // ----------------------------------------------------------------------------------------------
        // Задание по библиотеки
        Library lib = new Library();
        Book book1 = new Book("Н.А. Островский", "Как закалялась сталь", 360);
        Book book2 = new Book("Л.Н. Толстой", "Воскресение", 624);
        Book book3 = new Book("А.А. Фадеев", "Молодая гвардия", 640);
        Book book4 = new Book("Л.Н. Толстой", "Война и мир, том 1-2", 624);
        Book book5 = new Book("Л.Н. Толстой", "Война и мир, том 3-4", 700);
        lib.putBook(book1, 12);
        lib.putBook(book2, 13);
        lib.putBook(book3, 14);
        lib.putBook(book4, 5);
        lib.putBook(book5, 19);
        lib.getBook(book5, 1);
        /*lib.getBooksMap().forEach(((book, integer) -> System.out.println(book.getAuthor() + "     " + book.getTitle()
                + "    " + book.getPagesNum()
                +  "    " + integer)));
        System.out.println("Количество книг в библиотеке: " + lib.getBookCounter());*/

        // ----------------------------------------------------------------------------------------------
        // Задание по дому
        Building building = new Building(3,5,4, "SPb, Lenina street 24");
        ArrayList<Human> humans = new ArrayList<>();
        int n = 50;
        NamesHuman[] names = NamesHuman.values();
        int randomFloor;
        int randomName;
        for(int i = 0; i < n; i++){
            randomFloor = 1+ (int)(Math.random()*8);//случайный этаж
            randomName = (int)(Math.random()*names.length);// случайное имя
            humans.add((new Human(names[randomName], randomFloor)));

        }
        for(int i = 0; i < humans.size(); i++){
            System.out.println(humans.get(i).getName() + "   " + humans.get(i).getFloor());
        }
        building.add(humans);
        building.add(humans);
        building.add(humans);
        System.out.println("По адресу дома: " + building.getAdress() +"\n"
                + "проживает  " + building.getCountHumans() + " человека");
        building.printHuman(building.getnHumans());


    }

}
