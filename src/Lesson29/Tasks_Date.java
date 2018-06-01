package Lesson29;


import java.time.*;
import java.time.temporal.ChronoUnit;

public class Tasks_Date {

    public static void daysBeforeEvalution(){
        LocalDate deadline = LocalDate.of(2018, Month.JUNE, 29);

        LocalDate today = LocalDate.now();

        Period period = Period.between(today, deadline);
        System.out.println(period.getDays());
    }

    public static void fridays(){
        LocalDate startDate = LocalDate.of(2012, 1, 1);
        LocalDate endDate = LocalDate.of(2012, 12, 31);
        int fdays = 0;
        while(startDate.isBefore(endDate)){
            if((DayOfWeek.FRIDAY.equals(startDate.getDayOfWeek())&& startDate.getDayOfMonth()==13)
                    || (DayOfWeek.FRIDAY.equals(endDate.getDayOfWeek())
                    && endDate.getDayOfMonth() == 13)){
                fdays +=1;
            }
            startDate = startDate.plusDays(1);
        }
        System.out.println(fdays);
    }

    public static void reverseCount(){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime n = LocalDateTime.of(2018,Month.JANUARY,1,0,0);
        LocalDateTime nyDay = LocalDateTime.of(2019, Month.JANUARY, 1, 0, 0);
        int sec = 0;
        while(today.isBefore(nyDay)){
            switch (today.getMonth()){
                case JUNE: if(sec == 0){
                    sec = (151*24*60*60) + today.getHour()*60*60 + today.getMinute()*60 + today.getSecond();
                }
            }
            System.out.println("Секунд до нового года - " + (365*24*60*60 - sec));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sec+=1;

        }

    }

    public static void main(String[] args) {
       daysBeforeEvalution();
       fridays();
       reverseCount();


    }
}
