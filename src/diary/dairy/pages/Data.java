package diary.dairy.pages;

public class Data {
    private int dd;
    private int mm;
    private int yy;

    public Data(int dd, int mm, int yy) {
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    public String getData(){
        return "" + this.dd +"." + this.mm + "." + this.yy;
    }
}
