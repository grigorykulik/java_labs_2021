package lab_2;

//Array 270 degrees
//        13.3-0.2-2.56
//        0.2-2.230.81
//        1.59-1.270.64

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Array {
    private double[][] array;
    private int n;

    public Array(File file) throws FileNotFoundException {
        getN(file);

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

    public void getN(File file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);
        n = scanner.nextInt();
    }

    public void rotate() {
        divideNumberSum();
        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = array[j][n - i - 1];
            }
        }
        array = arr;
    }

    public void divideNumberSum() {
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

                array[i][j] = (double) Math.round((array[i][j] / sum) * 100.0) / 100.0;
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
        try (RandomAccessFile writer = new RandomAccessFile(file, "rw")) {
            long position = writer.length();
            writer.seek(position);

            writer.write(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append("\n");

                for (int j = 0; j < n; j++) {
                    sb.append(array[i][j] + " ");
                }
            }

            sb.append("\n\n");

            position = writer.length();
            writer.seek(position);
            writer.write(sb.toString().getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
