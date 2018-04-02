package battle;

public class WhiteSoldier extends Soldier {


    public WhiteSoldier(int health, int attackScore) {
        super(health, attackScore);
    }

    @Override
    boolean isAlive() {
        return health > 0;
    }

    @Override
    void attack(Soldier enemy) {
        enemy.health-=this.attackScore;
        if(enemy.isAlive() == true){
            this.health-=enemy.attackScore/2;
        }
    }
}
