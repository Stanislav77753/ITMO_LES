package school;

import HomeWork_30_03.NamesHuman;
import school.humans.*;
import school.humans.pupil.Pupil;
import school.humans.teacher.Teacher;

import java.util.ArrayList;
import java.util.Arrays;

public class School {
    /*Создаем класс из 20 учеников. 10 мальчиков и 10 девочек. Создаем одного учителя по математике. Учитель по
    математике задает вопросы, ученики на них отвечают. Если ответ правильный, ученик получает бал по математике,
    если нет, бал уменьшается на 0,1. При достижении определенного количества балов ученик растет по шкале успеваемости
      с новичка до отличника*/

    public static void main(String[] args) {
        ArrayList<Pupil> newClass = new ArrayList<>();
        NamesMale[] nameM = NamesMale.values();
        NamesFemale[] nameF = NamesFemale.values();
        SurnameMale[] surnameM = SurnameMale.values();
        SurnameFemale[] surnameF = SurnameFemale.values();
        MidNameMale[] midNameM = MidNameMale.values();
        MidNameFemale[] midNameF = MidNameFemale.values();
        String[] hobbys = {"Математика", "Физика", "Спорт"};
       /* System.out.println(Arrays.toString(nameM));
        System.out.println(Arrays.toString(nameF));
        System.out.println(Arrays.toString(surnameM));
        System.out.println(Arrays.toString(surnameF));*/
        for(int i = 0; i < 10; i++){
            newClass.add(new Pupil(nameM[(int)(Math.random()*nameM.length)],
                    surnameM[(int)(Math.random()*surnameM.length)], "Male", 7,
                    hobbys[(int)(Math.random()*hobbys.length)])); // создали мальчика
            newClass.add(new Pupil(nameF[(int)(Math.random()*nameF.length)],
                    surnameF[(int)(Math.random()*surnameF.length)], "Female", 7,
                    hobbys[(int)(Math.random()*hobbys.length)])); // создали девочку
        }
        Teacher mathTeacher = new Teacher(nameM[(int)(Math.random()*nameM.length )],
                surnameM[(int)(Math.random()*surnameM.length )],
                midNameM[(int)(Math.random()*midNameM.length )],"Male", 30, "Математика");

        for(int i = 0; i < 500; i++){
            for(int j = 0; j < newClass.size(); j++) {
                newClass.get(j).askQuestin(mathTeacher.askQuestion(), "Математика");
            }
        }


        // Выводим список учеников с их текущем рангом
        for(int i = 0; i < newClass.size(); i+=2){
            System.out.println("Имя ученика: " + newClass.get(i).getNameM() + "\n"
                    + "Фамилия ученика: " + newClass.get(i).getSurnameM() + "\n"
                    + "Ранг: " + newClass.get(i).getRank() + "\n"
                    + "Хобби: " + newClass.get(i+1).getHobby() + "\n");
            System.out.println("-------------------------");
            System.out.println("Имя ученика: " + newClass.get(i+1).getNameF() + "\n"
                    + "Фамилия ученика: " + newClass.get(i+1).getSurnameF() + "\n"
                    + "Ранг: " + newClass.get(i+1).getRank() + "\n"
                    + "Хобби: " + newClass.get(i+1).getHobby() + "\n");
            System.out.println("--------------------------");
        }
    }
}
