package HomeTaskReflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ReflectionToString {
    public static String smthObjectToString(Object obj) throws IllegalAccessException {
        Class someClass = obj.getClass();
        String className = someClass.getSimpleName();
        Field[] fields = someClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append(className).append(" Fields:");
        for(Field f : fields){
            f.setAccessible(true);
            if(!f.isAnnotationPresent(Exclude.class)){
                sb.append("\n" + f.getType().getSimpleName() + "\t" + f.getName());
            }
            if(f.getType().isArray() && !f.isAnnotationPresent(Exclude.class)){
                sb.append("\t" + "[");
                for(int i = 0; i < Array.getLength(f.get(obj)); i++){
                    sb.append(" " + Array.get(f.get(obj), i));
                    if(i < Array.getLength(f.get(obj)) - 1){
                        sb.append(",");
                    }
                }
                sb.append(" " + "]");
            }
        }
        return new String(sb);
    }
}
