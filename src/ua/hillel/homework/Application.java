package ua.hillel.homework;

public class Application {
    public static void main(String[] args) {
        TestMethod testMethod = new TestMethod();
        TestRunner.start(testMethod.getClass());
    }
}
