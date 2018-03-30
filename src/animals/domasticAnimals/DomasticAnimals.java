package animals.domasticAnimals;
import animals.Animal;
public class DomasticAnimals extends Animal {

    public DomasticAnimals(String name) {
        super(name);
    }

    public void liveWithPeople(){
        System.out.println("I am living with people");
    }

    /*public static void main(String[] args) {
        DomasticAnimals da = new DomasticAnimals("DomAnimals");
        da.say();
        da.liveWithPeople();
        da.setName("new name");
    }*/
}
