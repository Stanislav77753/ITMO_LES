package school.humans.pupil;

import school.humans.*;
import school.humans.teacher.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pupil extends Child {
    private String rank;
    private double mathLevel, physicsLevel;

    public Pupil(NamesMale name, SurnameMale surname, String sex, int age, String hobby) {
        super(name, surname, sex, age, hobby);
        this.rank = "Новичок";
        if (hobby == "Математика") {
            this.mathLevel = 1;
            this.physicsLevel = 0;
        } else if (hobby == "Физика") {
            this.mathLevel = 0;
            this.physicsLevel = 1;
        } else {
            this.mathLevel = 0;
            this.physicsLevel = 0;
        }
    }

    public Pupil(NamesFemale name, SurnameFemale surname, String sex, int age, String hobby) {
        super(name, surname, sex, age, hobby);
        this.rank = "Новичок";
        if(hobby == "Математика"){
            this.mathLevel = 1;
            this.physicsLevel = 0;
        }
        else if(hobby == "Физика"){
            this.mathLevel = 0;
            this.physicsLevel = 1;
        }
        else {
            this.mathLevel = 0;
            this.physicsLevel = 0;
        }
    }


    public void askQuestin(String question, String subject) {
        Integer answer = 0;
        HashMap<String, Integer> map = new Questions().getMathMap();
        ArrayList<Integer> arrA = new ArrayList<>();
        Integer trueAnswer = 0;
        for(String key : map.keySet()){
            if(key.equals(question)){
               trueAnswer = map.get(key);
            }
        }
        switch (this.rank){
            case "Отличник":
                answer = trueAnswer;
                break;
            case "Хорошист":
                for (int i = 0; i < 3; i++) {
                    arrA.add(trueAnswer);
                }
                arrA.add((int) (Math.random() * 1000));
                answer = arrA.get((int) (Math.random() * 4));
                break;
            case "Троишник":
                for (int i = 0; i < 2; i++) {
                    arrA.add(trueAnswer);
                }
                arrA.add((int) (Math.random() * 1000));
                arrA.add((int) (Math.random() * 1000));
                answer = arrA.get((int) (Math.random() * 4));
                break;
            case "Новичок":
                for (int i = 0; i < 1; i++) {
                    arrA.add(trueAnswer);
                }
                arrA.add((int) (Math.random() * 1000));
                arrA.add((int) (Math.random() * 1000));
                arrA.add((int) (Math.random() * 1000));

                answer = arrA.get((int) (Math.random() * 4));
                break;
        }
        if(answer == trueAnswer){
            if(subject.equals("Математика")){
                this.mathLevel+=0.2;
            }
        }
        else{
            if(subject.equals("Математика")){
                if(this.mathLevel > 0.1){
                    this.mathLevel-=0.1;}
            }
        }
        if(this.mathLevel >= 4){
            this.rank = "Отличник";
        }
        else if(this.mathLevel >= 3){
            this.rank = "Хорошист";
        }
        else if(this.mathLevel >= 2){
            this.rank = "Троишник";
        }
    }

    public String getRank() {
        return rank;
    }

    public double getMathLevel() {
        return mathLevel;
    }

    public double getPhysicsLevel() {
        return physicsLevel;
    }
}
