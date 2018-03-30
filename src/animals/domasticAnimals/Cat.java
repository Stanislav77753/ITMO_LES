package animals.domasticAnimals;

import animals.Animal;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void say() {
        //super.say();
        System.out.println("Мяу-мяу");
    }
     public void say(String text){
         System.out.println("cat say " + text);
     }

    public static void main(String[] args) {
        Cat cat = new Cat("Tom");
        System.out.println(cat.getName());
        cat.say();
        Dog dog = new Dog("Jek");
        System.out.println(dog.getName());
        dog.say();
        System.out.println("------------------");
        // полиморфизм наследования
        Animal animal1 = new Cat("animal - cat");
        Animal animal2 = new Dog("animal - dog");
        animal1.say();
        animal2.say();

        cat.say("rrrrrr");
    }
}
