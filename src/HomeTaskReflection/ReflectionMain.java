package HomeTaskReflection;

public class ReflectionMain {
    public static void main(String[] args) {
        TstClass tstClass = new TstClass();
        try {
            System.out.println(ReflectionToString.smthObjectToString(tstClass));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
