package animals.domasticAnimals;

public class Dog extends DomasticAnimals {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void say(){
        //super.say();
        System.out.println("Гав - гав");
    }

   /* public static void main(String[] args) {
        Dog dog = new Dog("Jek");
        System.out.println(dog.getName());
        dog.say();
    }*/
}
