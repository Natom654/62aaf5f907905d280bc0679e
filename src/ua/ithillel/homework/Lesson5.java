package ua.ithillel.homework;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lesson5 {
    public static void main(String[] args) {
        System.out.println(findSymbolOccurance("HAHAHHHHH", 'h'));
        System.out.println(findWordPosition("Appolo", "olo"));
        System.out.println(stringReverse("Good morning"));
        System.out.println(isPalindrome("Eeerreee"));
        Scanner console = new Scanner(System.in);
        System.out.println("Print name of plant");
        System.out.println(wordGame(console.nextLine()).toLowerCase());
        console.close();
    }

    // task 2
    public static int findSymbolOccurance(String text, char a) {
        String newtext = text.toLowerCase();
        char[] array = newtext.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a)
                count++;
        }
        return count;
    }

    // task 3
    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    // task 4
    public static String stringReverse(String inputtext) {
        StringBuilder newtext = new StringBuilder(inputtext);
        String result = newtext.reverse().toString();
        return result;
    }

    // task 5
    public static boolean isPalindrome(String texts) {
        String texts1 = texts.toLowerCase();
        StringBuffer buffer = new StringBuffer(texts1);
        String newtext = buffer.reverse().toString();
        return newtext.equals(texts1);
    }

    // task 6
    public static String wordGame(String puttext) {
        Scanner console = new Scanner(System.in);
        System.out.println("Print name of plant");
        String[] words =
                {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                        "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                        "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                        "pepper", "pineapple", "pumpkin", "potato"};
        String hiddenWord = words[new Random().nextInt(words.length)];

        while (!hiddenWord.equals(puttext)) {
            char[] solution = new char[]{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
            for (int i = 0; i < Math.min(solution.length, puttext.length()); i++) {
                if (puttext.charAt(i) == hiddenWord.charAt(i)) {
                    solution[i] = puttext.charAt(i);
                    System.out.println(solution[i]);
                }
            }
            System.out.println("Your answer is not right");
            System.out.println("Let's look, what letters you were right");
            System.out.println(String.valueOf(solution));
            System.out.println("Enter your new word:");
            puttext = console.nextLine().toLowerCase();
        }
        console.close();
        return "That's right";
    }
}


