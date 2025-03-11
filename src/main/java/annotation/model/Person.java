package main.java.annotation.model;

/**
 * @author zarin
 * @since 12/18/2021
 */
public class Person {

    @Size(max = 10)
    private String name;

    @Size(min = 18, message = "Age can not be less than {min}")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}