package HomeTaskObserver;

/**
 * Created by Stas on 13.05.2018.
 */
public class Alarm implements Observer {
    private String type;
    private int flagInt;
    private boolean flag;

    public Alarm(String type) {
        this.type = type;
        switch (type){
            case "Green":
                this.flagInt = 100;
                break;
            case "Yellow":
                this.flagInt = 300;
                break;
            case "Red":
                this.flagInt = 600;
                break;
        }
        this.flag = false;
    }

    @Override
    public void handleEvent(int temp) {
        switch (type){
            case "Green":
                if(temp >= flagInt){
                    if(flag == false){
                        System.out.println("<Green> - Температура = " + temp);
                        flag = true;
                    }
                }else{
                    flag = false;
                }
                break;
            case "Yellow":
                if(temp >= flagInt){
                    if(flag == false){
                        System.out.println("<Yellow> - Температура = " + temp);
                        flag = true;
                    }
                }else{
                    flag = false;
                }
                break;
            case "Red":
                if(temp >= flagInt){
                    if(flag == false){
                        System.out.println("<Red> - Температура = " + temp);
                        flag = true;
                    }
                }else{
                    flag = false;
                }
                break;
        }
    }
}
