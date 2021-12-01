package lab_2.exceptions;

public class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {
        super("Division by zero");
    }
}
