package school.humans.teacher;
import school.humans.*;

import java.util.ArrayList;

public class Teacher extends Adult {
    private String subject;

    public Teacher(NamesMale name, SurnameMale surname, MidNameMale midName, String sex, int age, String subject) {
        super(name, surname, midName, sex, age);
        this.subject = subject;
    }

    public Teacher(NamesFemale name, SurnameFemale surname, MidNameFemale midName, String sex, int age, String subject){
        super(name, surname, midName, sex, age);
        this.subject = subject;
    }

    public String askQuestion(){
        String question = "";
        if(this.subject.equals("Математика")){
          ArrayList listQ = new ArrayList(new Questions().getMathMap().keySet());
          int random = (int)(Math.random()*listQ.size());
          question = (String) listQ.get(random);
        }
        return question;
    }
}
