package lab_2;

import lab_2.exceptions.FileDoesNotExistException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File input = new File("/media/greg/New Volume/development/java_labs_21/src/main/resources/input");
        File output = new File("/media/greg/New Volume/development/java_labs_21/src/main/resources/output");

        if (output.exists()) {
            output.delete();
        }

        String nameArray;
        try {
            Array array = new Array(input);
            array.print();

            for (int i = 0; i < 3; i++) {
                array.rotate();
                array.print();
                nameArray = "Array " + (90 * (i + 1)) + " degrees";
                array.outputFile(output, nameArray);
            }
        } catch (FileDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (OutOfMemoryError error) {
            throw new RuntimeException("Not enough memory!");
        }
    }
}

