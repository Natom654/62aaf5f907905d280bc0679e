package ua.hillel.homework;

public class TestMethod {
    @BeforeSuite
    public static void methodBefore() {
        System.out.println("methodBefore");
    }

    @AfterSuite
    public static void methodAfter() {
        System.out.println("methodAfter");
    }

    @Test(priority = 1)
    public static void methodTest1() {
        System.out.println("methodTest1 priority 1 (high)");
    }

    @Test(priority = 10)
    public static void methodTest2() {
        System.out.println("methodTest2 priority 10 (low)");
    }

    @Test(priority = 5)
    public static void methodTest3() {
        System.out.println("methodTest3 priority 5 (middle)");
    }
    //           task 5
    //    @BeforeSuite
    //    public static void methodBefore2() {
    //        System.out.println("methodBefore2");
    // }
}
