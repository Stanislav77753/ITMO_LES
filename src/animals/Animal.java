package animals;

public class Animal {
    //public - виден везде
    //protected - виден только в рамках пакета, где находится класс и наследникам из любого пакета
    //private - виден только в рамках своего класса
    //default - (без модификатора) виден только в рамках своего класса
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    protected void protectedSmth(){
        System.out.println("What");
    }
    public void say(){

        System.out.println("I am " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
