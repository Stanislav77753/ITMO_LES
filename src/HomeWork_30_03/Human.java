package HomeWork_30_03;

public class Human {
    private NamesHuman name;
    private int floor;

    public Human(NamesHuman name, int floor) {
        this.name = name;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public NamesHuman getName() {
        return name;
    }
}
