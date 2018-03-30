package HomeWork_30_03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Building {
    private int nEntrance, nFloor, nApartment;
    private String adress;
    private ArrayList<Human> nHumans = new ArrayList<>();
    private int[][] freeApartmens;

    public Building(int nEntrance, int nFloor, int nApartment, String adress) {
        this.nEntrance = nEntrance;
        this.nFloor = nFloor;
        this.nApartment = nApartment;
        this.adress = adress;
        this.freeApartmens = new int[nFloor][2];
        for(int i = 0; i < this.nFloor; i++){
            this.freeApartmens[i][0] = i + 1;
            this.freeApartmens[i][1] = this.nApartment * this.nEntrance;
        }
    }

    public int getnFloor() {
        return nFloor;
    }

    public String getAdress() {
        return adress;
    }

    public ArrayList<Human> getnHumans() {
        return nHumans;
    }

    public void printHuman(ArrayList<Human> nHumans){
        for(int  i = 0; i < nHumans.size(); i++){
            System.out.println(nHumans.get(i).getName() + "   " + nHumans.get(i).getFloor());
        }
    }

    public int getCountHumans() {
        return nHumans.size();
    }

    public void add(ArrayList<Human> humans){
        for(int i = 0; i < 3; i++){
            if(humans.size() <= 0){
                break;
            }
            int want = humans.get(0).getFloor();
            if(want > nFloor || this.freeApartmens[want-1][1] <= 0){
                humans.add(humans.get(0));
                humans.remove(0);
            }
            else{
                this.nHumans.add(humans.get(0));
                humans.remove(0);
                this.freeApartmens[want - 1][1] --;
                }
        }
    }
}
