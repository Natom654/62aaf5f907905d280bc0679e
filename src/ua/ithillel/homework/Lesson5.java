package ua.ithillel.homework;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lesson5 {
    public static void main(String[] args) {
        findSymbolOccurance("HAHAHHHHH", 'h');
        System.out.println(findWordPosition("Appolo", "olo"));
        stringReverse("Good morning");
        isPalindrome("Erre");
        Scanner console = new Scanner(System.in);
        System.out.println("Print name of plant");
        System.out.println(wordGame(console.nextLine()).toLowerCase());
        console.close();
    }

    // task 2
    public static void findSymbolOccurance(String text, char a) {
        String newtext = text.toLowerCase();
        char[] array = newtext.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a)
                count++;
        }
        System.out.println(count);
    }

    // task 3
    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    // task 4
    public static void stringReverse(String inputtext) {
        int stringLength = inputtext.length();
        String result = "";
        for (int i = 0; i < stringLength; i++) {
            result = inputtext.charAt(i) + result;
        }
        System.out.println(result);
    }

    // task 5
    public static void isPalindrome(String texts) {
        String texts1 = texts.toLowerCase();
        StringBuffer buffer = new StringBuffer(texts1);
        buffer.reverse();
        String newtext = buffer.toString();
        if (newtext.equals(texts1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
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


// 2   Создать метод findSymbolOccurance. Метод принимает в качестве параметров строку и символ.
//        Необходимо вычислить,
//        сколько раз символ встречается в переданной строке и вернуть это числовое значение.

//    Создать метод findWordPosition.
//    Метод принимает в качестве параметров две строки (source, target).
//    Необходимо выяснить, является ли target (подстрока) частью строки source.
//    Если да, тогда вернуть номер позиции (индекс) первого элемента подстроки в строке,
//    иначе вернуть -1.
// Пример 1:
//        Source: Apollo
//        Target: pollo
//        Result: 1
//        Пример 2:
//        Source: Apple
//        Target: Plant
//        Result: -1

//     4. Создать метод stringReverse.
// Метод принимает в качестве параметра строку. Необходимо ее развернуть и вернуть измененный вариант.
//        Например:
//        Hello -> olleH

//        5. Создать метод isPalindrome. Метод принимает в качестве параметра строку
//        Необходимо Проверить является ли переданная строка палиндромом.
//        Если да, тогда вернут true, иначе false.
//        Пример 1:
//        ERE -> true
//        Пример 2:
//        Allo -> false

//6. * Создать массив из слов String[] words =
// {"apple", "orange", "lemon", "banana", "apricot", "avocado",
// "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
// "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
// "pepper", "pineapple", "pumpkin", "potato"};

//       При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
//        Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//        apple – загаданное
//        apricot - ответ игрока
//        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//        Для сравнения двух слов посимвольно, можно пользоваться:
//        String str = "apple";
//        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//        Играем до тех пор, пока игрок не отгадает слово
//        Используем только маленькие буквы


