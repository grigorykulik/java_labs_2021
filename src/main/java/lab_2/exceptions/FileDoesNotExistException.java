package lab_2.exceptions;

public class FileDoesNotExistException extends Exception {
    public FileDoesNotExistException() {
        super("Cannot find the file");
    }
}
