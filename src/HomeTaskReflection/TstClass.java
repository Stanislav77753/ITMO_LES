package HomeTaskReflection;

public class TstClass {
    private String stringFieldPrivate1;
    @Exclude
    private String stringFieldPrivate2;

    public String stringFieldPublic1;
    @Exclude
    public String stringFieldPublic2;

    private int intFieldPrivate1;
    @Exclude
    private int intFieldPrivate2;

    public int intFieldPublic1;
    @Exclude
    public int intFieldPublic2;

    public int[] intFieldArrayPublic1 = {1,2,3};
    @Exclude
    public int[] intFieldArrayPublic2 = {4,5,6};


    public TstClass(){
        this.stringFieldPrivate1 = "strPrivate1";
        this.stringFieldPrivate2 = "strPrivate2";
        this.stringFieldPublic1 = "strPublic1";
        this.stringFieldPublic2 = "strPublic2";
        this.intFieldPrivate1 = 1;
        this.intFieldPrivate2 = 2;
        this.intFieldPublic1 = 11;
        this.intFieldPublic2 = 22;

    }
    public TstClass(String stringFieldPrivate1, String stringFieldPrivate2, String stringFieldPublic1,
                    String stringFieldPublic2, int intFieldPrivate1, int intFieldPrivate2, int intFieldPublic1,
                    int intFieldPublic2) {
        this.stringFieldPrivate1 = "strPrivate1";
        this.stringFieldPrivate2 = "strPrivate2";
        this.stringFieldPublic1 = "strPublic1";
        this.stringFieldPublic2 = "strPublic2";
        this.intFieldPrivate1 = 1;
        this.intFieldPrivate2 = 2;
        this.intFieldPublic1 = 11;
        this.intFieldPublic2 = 22;
    }

    public String getStringFieldPrivate1() {
        return stringFieldPrivate1;
    }

    public void setStringFieldPrivate1(String stringFieldPrivate1) {
        this.stringFieldPrivate1 = stringFieldPrivate1;
    }

    public String getStringFieldPrivate2() {
        return stringFieldPrivate2;
    }

    public void setStringFieldPrivate2(String stringFieldPrivate2) {
        this.stringFieldPrivate2 = stringFieldPrivate2;
    }

    public String getStringFieldPublic1() {
        return stringFieldPublic1;
    }

    public void setStringFieldPublic1(String stringFieldPublic1) {
        this.stringFieldPublic1 = stringFieldPublic1;
    }

    public String getStringFieldPublic2() {
        return stringFieldPublic2;
    }

    public void setStringFieldPublic2(String stringFieldPublic2) {
        this.stringFieldPublic2 = stringFieldPublic2;
    }

    public int getIntFieldPrivate1() {
        return intFieldPrivate1;
    }

    public void setIntFieldPrivate1(int intFieldPrivate1) {
        this.intFieldPrivate1 = intFieldPrivate1;
    }

    public int getIntFieldPrivate2() {
        return intFieldPrivate2;
    }

    public void setIntFieldPrivate2(int intFieldPrivate2) {
        this.intFieldPrivate2 = intFieldPrivate2;
    }

    public int getIntFieldPublic1() {
        return intFieldPublic1;
    }

    public void setIntFieldPublic1(int intFieldPublic1) {
        this.intFieldPublic1 = intFieldPublic1;
    }

    public int getIntFieldPublic2() {
        return intFieldPublic2;
    }

    public void setIntFieldPublic2(int intFieldPublic2) {
        this.intFieldPublic2 = intFieldPublic2;
    }
    public int[] getIntFieldArrayPublic1() {
        return intFieldArrayPublic1;
    }

    public void setIntFieldArrayPublic1(int[] intFieldArrayPublic1) {
        this.intFieldArrayPublic1 = intFieldArrayPublic1;
    }

    public int[] getIntFieldArrayPublic2() {
        return intFieldArrayPublic2;
    }

    public void setIntFieldArrayPublic2(int[] intFieldArrayPublic2) {
        this.intFieldArrayPublic2 = intFieldArrayPublic2;
    }
}
