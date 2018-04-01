package school.humans;

public class Human {
    private NamesMale nameM;
    private NamesFemale nameF;
    private SurnameMale  surnameM;
    private SurnameFemale surnameF;
    private String  sex;
    private int age;

    public Human(NamesMale name, SurnameMale surname, String sex, int age) {
        this.nameM = name;
        this.surnameM = surname;
        this.sex = sex;
        this.age = age;
    }
    public Human(NamesFemale name, SurnameFemale surname, String sex, int age) {
        this.nameF = name;
        this.surnameF = surname;
        this.sex = sex;
        this.age = age;
    }

    public NamesMale getNameM() {
        return nameM;
    }

    public NamesFemale getNameF() {
        return nameF;
    }

    public SurnameMale getSurnameM() {
        return surnameM;
    }

    public SurnameFemale getSurnameF() {
        return surnameF;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
