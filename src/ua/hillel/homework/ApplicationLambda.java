package ua.hillel.homework;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ApplicationLambda {
    public static void main(String[] args) {
        // task 1
        System.out.println(emptyText(""));
        System.out.println(emptyText("Hello Java"));
        // task 2
        System.out.println(checkLetters("Java"));
        // task 3
        CargoBox cargoBox = new CargoBox("Box of toys", "120");
        TransferCargo(cargoBox);
        // task 4
        System.out.println(convertNumber(6));
        // task 5
        System.out.println(randomNumber());
    }

    public static boolean emptyText(String text) {
        Predicate<String> emptyTest = string -> text.isEmpty();
        return emptyTest.test(text);
    }

    public static boolean checkLetters(String text) {
        Predicate<String> lettersTest1 = string -> string.toLowerCase().startsWith("j");
        Predicate<String> lettersTest2 = string -> string.toLowerCase().startsWith("h");
        Predicate<String> lettersTest3 = string -> string.toLowerCase().endsWith("a");
        Predicate<String> lettersTest = lettersTest1.or(lettersTest2).and(lettersTest3);
        return lettersTest.test(text);
    }

    public static void TransferCargo(CargoBox cargobox) {
        Consumer<CargoBox> trans = cargoBox1 -> System.out.println("Shipped " + cargoBox1);
        Consumer<CargoBox> trans2 = cargoBox1 -> System.out.println("Sent " + cargoBox1);
        trans.andThen(trans2).accept(cargobox);
    }

    public static double convertNumber(int number) {
        Function<Integer, Double> function = Math::sqrt;
        return function.apply(number);
    }

    public static int randomNumber() {
        Supplier<Integer> supplier = () -> (int) (Math.random() * 10);
        return supplier.get();
    }
}

