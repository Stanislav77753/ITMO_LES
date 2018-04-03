package diary.dairy.pages;

public class Time {
    private StringBuilder time;
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        if(hour > 23 || hour < 0){
            System.out.println("Вы ввели неверное значение часов");
        }
        if(minute > 59 && minute < 0){
            System.out.println("Вы ввели неверное значение минут");
        }
        else{
            this.hour = hour;
            this.minute = minute;
        }
    }
    public String getTime(){
        return "" + this.hour + ":" + this.minute;
    }

}
