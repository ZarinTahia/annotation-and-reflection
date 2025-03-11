package main.java.annotation.controller;

import main.java.annotation.model.*;
import main.java.annotation.validator.AnnotatedValidator;

import java.util.*;

/**
 * @author zarin
 * @since 12/18/2021
 */
public class MainController {

    public static void main(String[] args) {
        Person person = new Person("Abcde Fghijk", 5);
        List<ValidationError> errors = new ArrayList<>();
        AnnotatedValidator.validate(person, errors);
        AnnotatedValidator.print(errors);
    }
}