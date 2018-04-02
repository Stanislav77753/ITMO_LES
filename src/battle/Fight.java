package battle;

public class Fight {




    public void fight(Soldier[] whiteArmy, Soldier[] blackArmy){
        for(int i = 0; i < whiteArmy.length; i++){
            whiteArmy[i].attack(blackArmy[i]);
        }
        for(int i = 0; i < blackArmy.length; i++){
            blackArmy[i].attack(whiteArmy[i]);
        }
    }

    public void winner(Soldier[] whiteArmy, Soldier[] blackArmy){
        int healthWhiteArmy = 0;
        int healthBlackArmy = 0;
        for(int i = 0; i < whiteArmy.length; i++){
            healthWhiteArmy+=whiteArmy[i].health;
        }
        for(int i = 0; i < blackArmy.length; i++){
            healthBlackArmy+=blackArmy[i].health;
        }
        if(healthWhiteArmy > healthBlackArmy){
            System.out.println("Победила белая армия");
        }
        else if(healthWhiteArmy < healthBlackArmy){
            System.out.println("Победила черная армия");
        }
        else{
            System.out.println("Ничья");
        }
    }

    public static void main(String[] args) {
        Soldier[] whiteArmy = new Soldier[10];
        Soldier[] blackArmy = new Soldier[10];
        for(int i = 0; i < whiteArmy.length; i++){
            whiteArmy[i] = new WhiteSoldier(50+(int)(Math.random()*50),(int)(Math.random()*10));
        }
        for(int i = 0; i < blackArmy.length; i++){
            blackArmy[i] = new BlackSoldier(50+(int)(Math.random()*50),(int)(Math.random()*10));
        }
        Fight fight = new Fight();
        fight.fight(whiteArmy, blackArmy);
        fight.winner(whiteArmy, blackArmy);


    }
}
