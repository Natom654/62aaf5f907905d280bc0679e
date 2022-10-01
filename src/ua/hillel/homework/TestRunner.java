package ua.hillel.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;

public class TestRunner {
    private static Object obj;

    public static void start(Class myClass) {
        if (!areBeforeAfterAnnotationsCorrect(myClass)) {
            throw new RuntimeException("BeforeSuite or AfterSuite Annotations are not in one exemplar");
        }
        try {
            obj = myClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Method methodBefore = null;
        Method methodAfter = null;
        ArrayList<Method> testMethods = new ArrayList<>();
        Method[] objMethods = myClass.getDeclaredMethods();

        for (Method method : objMethods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                methodBefore = method;
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                methodAfter = method;
            } else if (method.getAnnotation(Test.class) != null) {
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));

        if (methodBefore != null) {
            testMethods.add(0, methodBefore);
        }

        if (methodAfter != null) {
            testMethods.add(methodAfter);
        }
        try {
            for (Method testMethod : testMethods) {
                if (Modifier.isPrivate(testMethod.getModifiers())) {
                    testMethod.setAccessible(true);
                }
                testMethod.invoke(obj);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    private static boolean areBeforeAfterAnnotationsCorrect(Class myClass) {
        int beforeAnnotationCount = 0;
        int afterAnnotationCount = 0;

        for (Method method : myClass.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeAnnotationCount++;
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                afterAnnotationCount++;
            }
        }
        return (beforeAnnotationCount < 2) && (afterAnnotationCount < 2);
    }
}





