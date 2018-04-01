package school.humans;

public class Adult extends Human{
    private MidNameMale midNameM;
    private MidNameFemale midNameF;

    public Adult(NamesMale name, SurnameMale surname, MidNameMale midName, String sex, int age) {
        super(name, surname, sex, age);
        this.midNameM = midName;
    }

    public Adult(NamesFemale name, SurnameFemale surname, MidNameFemale midName, String sex, int age) {
        super(name, surname, sex, age);
        this.midNameF = midName;
    }
}
