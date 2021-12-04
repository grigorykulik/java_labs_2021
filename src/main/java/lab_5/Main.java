package lab_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//
//        //entering integers, method 1
//        ArrayList<Integer> array1 = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter integers. When finished, type \"Quit\"");
//
//        while (true) {
//            try {
//                String sInput = br.readLine();
//                if (sInput.equals("quit")) {
//                    break;
//                }
//                try {
//                    Integer iInput = Integer.parseInt(sInput);
//                    array1.add(iInput);
//                } catch (NumberFormatException e) {
//                    System.out.println("I said integers you dumbass");
//                }
//            } catch (IOException e) {
//                System.out.println("Error reading input");
//            }
//        }
//
//        //get the average value
//        Double average = getAverage(array1);
//        System.out.println("Average value:" + average);
//
//
//        //entering string, method 2
//        ArrayList<String> array2 = new ArrayList<>();
//        System.out.println("Enter strings. When finished, type \"quit\"");
//
//        while (true) {
//            try {
//                String sInput = br.readLine();
//                if (sInput.equals("quit")) {
//                    break;
//                }
//                array2.add(sInput);
//            } catch (IOException e) {
//                System.out.println("Error reading input");
//            }
//        }
//
//        toUpperCase(array2);
//
//
//        //entering integers, method 3
//        ArrayList<Integer> array3 = new ArrayList<>();
//        System.out.println("Enter integers. When finished, type \"Quit\"");
//
//        while (true) {
//            try {
//                String sInput = br.readLine();
//                if (sInput.equals("quit")) {
//                    break;
//                }
//                try {
//                    Integer iInput = Integer.parseInt(sInput);
//                    array3.add(iInput);
//                } catch (NumberFormatException e) {
//                    System.out.println("I said integers you dumbass");
//                }
//            } catch (IOException e) {
//                System.out.println("Error reading input");
//            }
//        }
//
//        getUniqueSquare(array3)
//                .stream()
//                .forEach(s -> System.out.println(s));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        //entering string, method 2
//        ArrayList<String> array4 = new ArrayList<>();
//        System.out.println("Enter strings. When finished, type \"quit\"");
//
//        while (true) {
//            try {
//                String sInput = br.readLine();
//                if (sInput.equals("quit")) {
//                    break;
//                }
//                array4.add(sInput);
//            } catch (IOException e) {
//                System.out.println("Error reading input");
//            }
//        }
//        System.out.println("Enter the desired letter.");
//        try {
//            String letter = br.readLine();
//            strsStartWithLetterSortedAlp(array4, letter)
//                    .stream()
//                    .forEach(s -> System.out.println(s));
//        } catch (IOException e) {
//            System.out.println("Error reading input");
//        }

//        List<Integer> list = new ArrayList<>();
//        System.out.println(getLastElement(list));

//        int[] array = {1, 2, 3};
//        System.out.println(getSumOfEvenNumbers(array));

        List<String> list = new ArrayList<>();
        list.add("greg");
        System.out.println(convertListStringToMap(list));

    }

    public static Double getAverage(ArrayList<Integer> arr) {
        return
                arr
                        .stream()
                        .mapToDouble(Integer::doubleValue)
                        .average()
                        .getAsDouble();
    }

    public static void toUpperCase(ArrayList<String> arr) {
        arr
                .stream()
                .map(s -> s.toUpperCase())
                .forEach(s -> {
                    s = "new" + s;
                    System.out.println(s);
                });
    }

    public static ArrayList<Integer> getUniqueSquare(ArrayList<Integer> arr) {
        return arr
                .stream()
                .distinct()
                .map(integer -> integer * integer)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<String> strsStartWithLetterSortedAlp(ArrayList<String> strings, String letter) {

        return strings
                .stream()
                .filter(s -> s.startsWith(letter))
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLastElement(Collection<T> collection) {
        return collection
                .stream()
                .reduce((first, second) -> second)
                .orElseThrow(NoSuchElementException::new);
    }

    public static int getSumOfEvenNumbers(int[] array) {
        return Arrays
                .stream(array)
                .filter(i -> (i%2==0))
                .sum();
    }

    public static Map<String, String> convertListStringToMap(List<String> list) {
        Map<String, String> convertredStrings = new HashMap<>();

        list
                .stream()
                .forEach(s -> {
                    convertredStrings.put(s.substring(0, 1), s.substring(1, s.length()));
                });

        return convertredStrings;
    }

}
