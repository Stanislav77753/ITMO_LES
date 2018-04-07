package homework_04_04;

public class Main {
    public static void main(String[] args) {
        FactoryHandler factoryHandler = new FactoryHandler();
        Handler handler = factoryHandler.getInstanse("gdkfgk.xml");
        handler.readFromFile();
        handler.writeInFile();
        System.out.println(handler.getClass().getName());
    }
}
