package main.java.annotation.validator;

import java.util.*;

import main.java.annotation.model.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author zarin
 * @since 12/18/2021
 */
public class AnnotatedValidator {

    public static void validate(Object p, List<ValidationError> errors) {
        Class c = p.getClass();
        Field[] field = c.getDeclaredFields();
        for (Field f : field) {
            Annotation[] annotation = f.getDeclaredAnnotations();
            String type;
            String name;
            int min;
            int max;
            String message;
            for (Annotation a : annotation) {
                if (a instanceof Size) {
                    Size size = (Size) a;
                    if (f.getType().toGenericString().contains("java")) {
                        type = f.getType().toGenericString().split("\\.")[2];
                    } else {
                        type = f.getType().toGenericString();
                    }
                    name = f.getName();
                    max = size.max();
                    min = size.min();
                    message = size.message();
                    try {
                        f.setAccessible(true);
                        String procesMessage = message.replaceAll("\\{max}", Integer.toString(max));
                        procesMessage = procesMessage.replaceAll("\\{min}", Integer.toString(min));
                        if (f.get(p) instanceof String) {
                            String value = f.get(p).toString();
                            if (value.length() > max || value.length() < min) {
                                ValidationError errorValidate = new ValidationError(name, type, procesMessage);
                                errors.add(errorValidate);
                            }
                        } else if (f.get(p) instanceof Integer) {
                            int value = f.getInt(p);
                            if (value > max || value < min) {
                                ValidationError errorValidate = new ValidationError(name, type, procesMessage);
                                errors.add(errorValidate);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    public static void print(List<ValidationError> errors) {
        for (ValidationError e : errors) {
            System.out.println(e.getVariableName() + "(" + e.getVariableType() + "): " + e.getMessage());
        }
    }
}