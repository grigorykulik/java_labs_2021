package lab_2;

import lab_2.exceptions.DivisionByZeroException;
import lab_2.exceptions.FileDoesNotExistException;
import lab_2.exceptions.NumberTooLargeException;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Array {
    private double[][] array;
    private int n;

    public Array(File file) throws FileDoesNotExistException {
        try {
            getN(file);
        } catch (FileNotFoundException e) {
            throw new FileDoesNotExistException();
            } catch (NumberTooLargeException e) {
            System.out.println(e.getMessage());
        }
        array = new double[n][n];
        Random random = new Random();
        int min = -10;
        int max = 10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double random_number = random.nextInt(max * 2 + 1) + min;
                array[i][j] = random_number;
            }
        }
    }

    public void getN(File file) throws FileNotFoundException, NumberTooLargeException {
        try (FileReader reader = new FileReader(file)) {
            Scanner scanner = new Scanner(reader);
            n = scanner.nextInt();

            if (n > 1_000_000) {
                throw new NumberTooLargeException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rotate() {
        try {
            divideNumberSum();
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }

        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = array[j][n - i - 1];
            }
        }
        array = arr;
    }

    public void divideNumberSum() throws DivisionByZeroException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0;
                try {
                    sum += array[i][j - 1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
                try {
                    sum += array[i][j + 1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }

                if (sum == 0) {
                    array[i][j] = (double) Math.round((array[i][j] / sum) * 100.0) / 100.0;
                } throw new DivisionByZeroException();
            }
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println("");
    }

    public void outputFile(File file, String str) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(str);
            for (int i = 0; i < n; i++) {
                writer.write("\n");
                for (int j = 0; j < n; j++) {
                    writer.write(array[i][j] + " ");
                }
            }
            writer.write("\n\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
