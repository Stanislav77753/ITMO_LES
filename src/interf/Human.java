package interf;

import animals.domasticAnimals.DomasticAnimals;

public interface Human {

    void setName(String name);
    String getName();
    default boolean isHuman(){ //дефолтный метод можно реализовать в интерфейсе.
        return true;
    }
    // методы - public;
    // нельзя создать экземпляр интерфейса;
}
interface Teacher extends Human{
    void teach(Pupil pupil);
}

interface Pupil extends Human{
    void study();
}

class FirstYearPupil implements Pupil, Teacher{

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void study() {

    }

    @Override
    public void teach(Pupil pupil) {

    }

    public static void main(String[] args) {
        Pupil pupil = new FirstYearPupil();
    }
}

// абстрактные классы (описывает базовый функционал классов наследников)
abstract class DomasticAnimal{
    public String getName(){
        return "DomasticAnimal";
    }
    abstract void eat();
}

class Dog extends DomasticAnimal{

    @Override
    void eat() {

    }
}
class Cat extends DomasticAnimal{

    @Override
    void eat() {

    }
}
