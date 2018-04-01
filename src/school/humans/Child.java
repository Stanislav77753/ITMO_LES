package school.humans;

public class Child extends Human{
    private String hobby;


    public Child(NamesMale name, SurnameMale surname, String sex, int age, String hobby) {
        super(name, surname, sex, age);
        this.hobby = hobby;
    }

    public Child(NamesFemale name, SurnameFemale surname, String sex, int age, String hobby) {
        super(name, surname, sex, age);
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }
}
