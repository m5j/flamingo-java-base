package annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Created by minwujun on 2020/9/10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MwjAnnotation {
    String value();
}
