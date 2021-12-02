package lab4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ClassWithAnnotations {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation
    {
        int n();
    }

    @MyAnnotation(n=2)
    private void method1() {
        System.out.println("Executing method 1");
    }

    @MyAnnotation(n=3)
    private void method2() {
        System.out.println("Executing method 2");
    }

    private void method3() {
        System.out.println("Executing method 3");
    }
}
