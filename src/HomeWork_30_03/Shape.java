package HomeWork_30_03;

public class Shape {
        private int r;
        private Point p1;
        private Point p2;
        private Point p3;
        private Point p4;
        private Point cp;

    public int getR() {
        return r;
    }


    public Shape(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Shape(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Shape(Point cp, int r) {
        this.r = r;
        this.cp = cp;
    }

    public double perRectangle(Shape shape){
        double per = 0;
        // проверка для случая, когда точки задаются в случайном порядке
        if((shape.p1.getX() == shape.p2.getX()) && (shape.p1.getY() == shape.p4.getY())){
            per = 2*((Math.abs(shape.p1.getX() - shape.p4.getX())) + (Math.abs(shape.p1.getY() - shape.p2.getY())));
        }
        else if((shape.p1.getX() == shape.p2.getX()) && (shape.p1.getY() == shape.p3.getY())){
            per = 2*((Math.abs(shape.p1.getX() - shape.p3.getX())) + (Math.abs(shape.p1.getY() - shape.p2.getY())));
        }
        else if((shape.p1.getX() == shape.p3.getX()) && (shape.p1.getY() == shape.p2.getY())){
            per = 2*((Math.abs(shape.p1.getX() - shape.p2.getX())) + (Math.abs(shape.p1.getY() - shape.p3.getY())));
        }
        else if((shape.p1.getX() == shape.p3.getX()) && (shape.p1.getY() == shape.p4.getY())){
            per = 2*((Math.abs(shape.p1.getX() - shape.p4.getX())) + (Math.abs(shape.p1.getY() - shape.p3.getY())));
        }
        else if((shape.p1.getX() == shape.p4.getX()) && (shape.p1.getY() == shape.p2.getY())){
            per = 2*((Math.abs(shape.p1.getX() - shape.p2.getX())) + (Math.abs(shape.p1.getY() - shape.p4.getY())));
        }
        else if((shape.p1.getX() == shape.p4.getX()) && (shape.p1.getY() == shape.p3.getY())){
            per = 2*((Math.abs(shape.p1.getX() - shape.p3.getX())) + (Math.abs(shape.p1.getY() - shape.p4.getY())));
        }
        else{
            System.out.println("Вы ввели точки не соответсвующие прямоугольнику");
        }
        return per;
    }

    public double squareRectangle(Shape shape){
        double square = 0;
        if((shape.p1.getX() == shape.p2.getX()) && (shape.p1.getY() == shape.p4.getY())){
            square = (Math.abs(shape.p1.getX() - shape.p4.getX())) * (Math.abs(shape.p1.getY() - shape.p2.getY()));
        }
        else if((shape.p1.getX() == shape.p2.getX()) && (shape.p1.getY() == shape.p3.getY())){
            square = (Math.abs(shape.p1.getX() - shape.p3.getX())) * (Math.abs(shape.p1.getY() - shape.p2.getY()));
        }
        else if((shape.p1.getX() == shape.p3.getX()) && (shape.p1.getY() == shape.p2.getY())){
            square = (Math.abs(shape.p1.getX() - shape.p2.getX())) * (Math.abs(shape.p1.getY() - shape.p3.getY()));
        }
        else if((shape.p1.getX() == shape.p3.getX()) && (shape.p1.getY() == shape.p4.getY())){
            square = (Math.abs(shape.p1.getX() - shape.p4.getX())) * (Math.abs(shape.p1.getY() - shape.p3.getY()));
        }
        else if((shape.p1.getX() == shape.p4.getX()) && (shape.p1.getY() == shape.p2.getY())){
            square = (Math.abs(shape.p1.getX() - shape.p2.getX())) * (Math.abs(shape.p1.getY() - shape.p4.getY()));
        }
        else if((shape.p1.getX() == shape.p4.getX()) && (shape.p1.getY() == shape.p3.getY())){
            square = (Math.abs(shape.p1.getX() - shape.p3.getX())) * (Math.abs(shape.p1.getY() - shape.p4.getY()));
        }
        else{
            System.out.println("Вы ввели точки не соответсвующие прямоугольнику");
        }
        return  square;
    }

    public double lengthCircle(Shape shape){
        double length = 2* Math.PI * shape.getR();
        return length;
    }

    public double squareCircle(Shape shape){
        double square = Math.PI *shape.getR()*shape.getR();
        return square;
    }

    public double perTriangle(Shape shape){
        double l1 = Math.sqrt(((Math.abs(shape.p1.getX() - shape.p2.getX())) * (Math.abs(shape.p1.getX()
                - shape.p2.getX()))) + ((Math.abs(shape.p1.getY() - shape.p2.getY())) * (Math.abs(shape.p1.getY()
                - shape.p2.getY()))));
        double l2 = Math.sqrt(((Math.abs(shape.p1.getX() - shape.p3.getX())) * (Math.abs(shape.p1.getX()
                - shape.p3.getX()))) + ((Math.abs(shape.p1.getY() - shape.p3.getY())) * (Math.abs(shape.p1.getY()
                - shape.p3.getY()))));
        double l3 = Math.sqrt(((Math.abs(shape.p2.getX() - shape.p3.getX())) * (Math.abs(shape.p2.getX()
                - shape.p3.getX()))) + ((Math.abs(shape.p2.getY() - shape.p3.getY())) * (Math.abs(shape.p2.getY()
                - shape.p3.getY()))));
        return  l1 + l2 + l3;
    }

    public double squareTriangle(Shape shape){
        double square = 0;
        double l1 = Math.sqrt(((Math.abs(shape.p1.getX() - shape.p2.getX())) * (Math.abs(shape.p1.getX()
                - shape.p2.getX()))) + ((Math.abs(shape.p1.getY() - shape.p2.getY())) * (Math.abs(shape.p1.getY()
                - shape.p2.getY()))));
        double l2 = Math.sqrt(((Math.abs(shape.p1.getX() - shape.p3.getX())) * (Math.abs(shape.p1.getX()
                - shape.p3.getX()))) + ((Math.abs(shape.p1.getY() - shape.p3.getY())) * (Math.abs(shape.p1.getY()
                - shape.p3.getY()))));
        double l3 = Math.sqrt(((Math.abs(shape.p2.getX() - shape.p3.getX())) * (Math.abs(shape.p2.getX()
                - shape.p3.getX()))) + ((Math.abs(shape.p2.getY() - shape.p3.getY())) * (Math.abs(shape.p2.getY()
                - shape.p3.getY()))));
        square =  Math.sqrt((shape.perTriangle(this)/2) * (shape.perTriangle(this)/2 - l1)
                *(shape.perTriangle(this)/2 - l2)*(shape.perTriangle(this)/2 - l3));

        return square;
    }
}
class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
