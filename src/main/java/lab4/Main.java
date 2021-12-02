package lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        ClassWithAnnotations cwa = new ClassWithAnnotations();

        //get array of class methods
        Method[] methArray = cwa
                .getClass()
                .getDeclaredMethods();

        //set them all as accessible
        for (int i = 0; i < methArray.length; i++) {
            methArray[i].setAccessible(true);
        }

        //get
        for (int i = 0; i < methArray.length; i++) {
            try {
                if (cwa
                        .getClass()
                        .getDeclaredMethod(methArray[i].getName())
                        .getAnnotation(ClassWithAnnotations.MyAnnotation.class) == null) continue;

                Integer number = cwa
                        .getClass()
                        .getDeclaredMethod(methArray[i].getName())
                        .getAnnotation(ClassWithAnnotations.MyAnnotation.class)
                        .n();

                for (int j = 0; j < number; j++) {
                    try {
                        if (number != null)
                            methArray[i].invoke(cwa);
                    } catch (IllegalAccessException e) {
                        System.out.println("Could not access method");
                    } catch (InvocationTargetException e) {
                        System.out.println("Could not invoke method");
                    }
                }
            } catch (NoSuchMethodException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

    }
}

