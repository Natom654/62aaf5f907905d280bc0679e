package ua.hillel.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws Throwable {
        ArrayList<Product2> searchList = new ArrayList<Product2>();
        Product2 book = new Product2("Book", 150, 0, 1001);
        Product2 pen = new Product2("Pen", 50, 5, 1002);
        Product2 book2 = new Product2("Book", 250, 10, 1003);
        Product2 note = new Product2("Note", 1500, 5, 1004);
        Product2 book3 = new Product2("Book", 450, 7, 1005);
        Product2 pen2 = new Product2("Pen", 100, 6, 1006);
        searchList.add(book);
        searchList.add(pen);
        searchList.add(book2);
        searchList.add(note);
        searchList.add(book3);
        searchList.add(pen2);
        System.out.println(searchBook(searchList));
        System.out.println(searchBookDiscount(searchList, "Book"));
        System.out.println(findcheap(searchList, "Book"));
        // System.out.println(findcheap(searchList, "note"));
        System.out.println(threeLastProducts(searchList));
        System.out.println("Summ of all Products 2022 year - " + summaryOfproducts(searchList, "Book"));
        System.out.println(MapOfProducts(searchList));
    }

    public static List<Product2> searchBook(List<Product2> listofproducts) {
        return listofproducts.stream()
                .filter(product2 -> (product2.getType().equals("Book")) && (product2.getPrice() >= 250))
                .collect(Collectors.toList());
    }

    public static List<Product2> searchBookDiscount(List<Product2> listofproducts, String type) {
        return listofproducts.stream()
                .filter(product2 -> (product2.getType().equals(type)) && (product2.getDiscount() > 0))
                .peek(position -> position.setPrice(position.getPrice() * (100 - position.getDiscount()) / 100))
                .toList();
    }

    public static Product2 findcheap(List<Product2> listofproducts, String type) throws Throwable {
        try {
            return listofproducts.stream()
                    .filter(product2 -> (product2.getType().equals(type)))
                    .min(Comparator.comparing(Product2::getPrice))
                    .get();
        } catch (RuntimeException e) {
            throw new UnfinedType(type).initCause(e);
        }
    }

    public static List<Product2> threeLastProducts(List<Product2> listofproducts) {
        return listofproducts.stream()
                .sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate()))
                .limit(3)
                .toList();
    }


    public static int summaryOfproducts(List<Product2> listofproducts, String type) {
        return listofproducts.stream()
                .filter(product2 -> product2.getType().equals(type)
                        && product2.getPrice() >= 75
                        && product2.getDate().getYear() == 2022)
                .mapToInt(Product2::getPrice)
                .sum();
    }

    public static Map<String, List<Product2>> MapOfProducts(List<Product2> listofproducts) {
        return listofproducts.stream()
                .collect(Collectors.groupingBy(Product2::getType));
    }
}
