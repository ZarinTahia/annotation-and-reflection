package main.java.annotation.model;

/**
 * @author zarin
 * @since 12/18/2021
 */
public class ValidationError {

    private String name;
    private String type;
    private String message;

    public ValidationError(String name, String type, String message) {
        this.name = name;
        this.type = type;
        this.message = message;
    }

    public String getVariableName() {
        return name;
    }

    public String getVariableType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}