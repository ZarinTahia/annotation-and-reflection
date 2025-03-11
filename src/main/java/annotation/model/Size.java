package main.java.annotation.model;

import java.lang.annotation.*;

/**
 * @author zarin
 * @since 12/18/2021
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {

    int min() default 1;

    int max() default 100;

    String message() default "Length must be {min}-{max}";
}