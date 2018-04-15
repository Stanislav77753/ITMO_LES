package lessons_13_04;


public enum Planets {
    Planeta1(1,2,3), Planeta2(4,5,6), Planeta3(7,8,9), Planeta4(10,11,12);
    private int mass;
    private int rasius;
    private int radiusOrbita;

    Planets(int mass, int rasius, int radiusOrbita) {
        this.mass = mass;
        this.rasius = rasius;
        this.radiusOrbita = radiusOrbita;
    }

    public int getMass(){
        return mass;
    }

    public int getRasius(){
        return rasius;
    }

    public int getRadiusOrbita(){
        return radiusOrbita;
    }

}

