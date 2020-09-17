package annotation;

import java.lang.reflect.Method;

/**
 * Created by minwujun on 2020/9/10
 */
public class Main {
    public static void main(String[] args) {
        Class useAnnotationClass = UseAnnotation.class;

        for (Method method : useAnnotationClass.getMethods()) {
            MwjAnnotation annotation = method.getAnnotation(MwjAnnotation.class);
            if (annotation != null) {
                System.out.println(annotation.value());
            }
        }
    }
}
