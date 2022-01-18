package com.cursor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    // Task 1
    public static void Task1() {
        Map<LocalDate, String> catalogOfBooks = new HashMap<>();
        LocalDate date = LocalDate.of(2019, 5, 21);
        String title = "Marry Poppins";
        catalogOfBooks.put(date, title);

        catalogOfBooks.put(LocalDate.of(2019, 5, 22), "A Christmas Carol");
        catalogOfBooks.put(LocalDate.of(2019, 5, 23), "The Hound of the Baskerville");
        catalogOfBooks.put(LocalDate.of(2019, 5, 24), "1984");
        catalogOfBooks.put(LocalDate.of(2019, 5, 25), "Forrest Gump");
        catalogOfBooks.put(LocalDate.of(2019, 5, 26), "The Old Man and the Sea");
        String myBook = getBook(LocalDate.of(2019, 5, 22), catalogOfBooks);
        System.out.println(myBook);
        String notMyBook = getBook(LocalDate.of(2019, 5, 27), catalogOfBooks);
        System.out.println(notMyBook);
        System.out.println();
        String dates = catalogOfBooks.keySet().stream().map(x -> x.toString()).collect(Collectors.joining(", "));
        System.out.println(dates);
        String titles = catalogOfBooks.values().stream().collect(Collectors.joining(", "));
        System.out.println(titles);
    }

    public static String getBook(LocalDate date, Map<LocalDate, String> catalogOfBooks) {
        if (catalogOfBooks.containsKey(date)) return catalogOfBooks.get(date);
        else return "There are no books for this date";
    }

    public static void Task2() {
        Map<LocalDate, List<String>> catalogOfBooks = new HashMap<>();
        LocalDate date1 = LocalDate.of(2019, 5, 21);
        LocalDate date2 = LocalDate.of(2019, 5, 22);
        LocalDate date3 = LocalDate.of(2019, 5, 23);

        List<String> title1 = List.of("Marry Poppins", "The Hound of the Baskervilles", "1984");
        List<String> title2 = List.of("Forrest Gump", "The Old Man and the Sea", "Billy Budd");
        List<String> title3 = List.of("The Prince and The Pauper", "Robin Hood", "Treasure Island");
        catalogOfBooks.put(date1, title1);
        catalogOfBooks.put(date2, title2);
        catalogOfBooks.put(date3, title3);
        String myBook = getBooks(LocalDate.of(2019, 5, 22), catalogOfBooks);
        System.out.println(myBook);
        String notMyBook = getBooks(LocalDate.of(2019, 5, 27), catalogOfBooks);
        System.out.println(notMyBook);
        System.out.println();
        PrintDates(5, 2019, catalogOfBooks);
    }

    public static String getBooks(LocalDate date, Map<LocalDate, List<String>> catalogOfBooks) {
        if (catalogOfBooks.containsKey(date))
            return catalogOfBooks.get(date).stream().collect(Collectors.joining(", "));
        else return "There are no books for this date";
    }

    public static void PrintDates(Integer month, Integer year, Map<LocalDate, List<String>> catalogOfBooks) {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = LocalDate.of(year, month, day);
            if (catalogOfBooks.containsKey(date)) System.out.println(date + " - " + catalogOfBooks.get(date).size());
            else System.out.println(date + " - 0");
        }
    }

    public static void main(String[] args) {
        Task1();
        System.out.println();
        Task2();
    }
}


