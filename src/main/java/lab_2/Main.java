package lab_2;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("/media/greg/New Volume/development/java_labs_21/src/main/resources/input");
        File output = new File("/media/greg/New Volume/development/java_labs_21/src/main/resources/output");
        String nameArray;
        Array array = new Array(input);

        array.print();

        for (int i = 0; i < 3; i++) {
            array.rotate();
            array.print();
            nameArray = "Array " + (90 * (i + 1)) + " degrees";
            array.outputFile(output, nameArray);
        }

    }
}

