package battle;

public class BlackSoldier extends Soldier {
    public BlackSoldier(int health, int attackScore) {
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
