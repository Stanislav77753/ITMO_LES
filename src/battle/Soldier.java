package battle;

abstract class Soldier {
    protected int health ;
    protected int attackScore;
    abstract boolean isAlive();
    abstract void attack(Soldier enemy);

    public Soldier(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

}
