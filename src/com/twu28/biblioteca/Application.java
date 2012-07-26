package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private List<Book> bookList;
    private List<Integer> libraryNumber;

    private void populateBooks() {
        for (int iterator = 1; iterator < 10; iterator++) {
            Book myBook = new Book(iterator + "", "BOOK" + iterator);
            bookList.add(myBook);
        }
    }

    private void populateLibraryNumbers() {
        for (int iterator = 1; iterator < 10; iterator++) {
            libraryNumber.add(iterator);
        }
    }

    public Application() {
        bookList = new ArrayList<Book>();
        libraryNumber = new ArrayList<Integer>();
        populateBooks();
        populateLibraryNumbers();
    }

    public String readInput() {
        BufferedReader readInput = new BufferedReader(new InputStreamReader(System.in));
        try {
            return readInput.readLine();
        } catch (Exception e) {
            System.out.println("Exception while reading from console. Exception details - " + e.getMessage());
        }
        return null;
    }

    private Book getBookById(String bookId) {
        for (Book eachBook : bookList) {
            if (eachBook.getBookId().equals(bookId))
                return eachBook;
        }
        return null;
    }

    private boolean getCustomerByLibraryNumber(String libraryNumber) {
        boolean isCustomerPresent = this.libraryNumber.contains(Integer.parseInt(libraryNumber));
        if (isCustomerPresent)
            return true;
        else
            return false;
    }

    public void displayBooks() {
        for (Book eachBook : bookList) {
            System.out.println("\n" + eachBook.getBookId() + "  :   " + eachBook.getBookName());
        }
    }

    private boolean getCustomer() {
        System.out.println("Enter the Library Number  :   ");
        String libraryNumber = readInput();
        return getCustomerByLibraryNumber(libraryNumber);
    }

    private Book getBook() {
        System.out.print("Enter The Book Id   :   ");
        String bookId = readInput();
        return getBookById(bookId);
    }

    private void reserveAndInform(Book bookOfInterest) {
        if (bookOfInterest.reserveBook())
            System.out.println("Thank you ! Enjoy the book");
        else
            System.out.println("Sorry We don't have that book yet");
    }

    public void reserveBook() {
        Book bookOfInterest = getBook();
        reserveAndInform(bookOfInterest);
    }

    public void getLibraryNumber() {
        boolean isUserPresent = getCustomer();
        if (isUserPresent) {
            System.out.println("Please talk to Librarian. Thank You");
        } else
            System.out.println("Sorry! User with such library number doesn't exist");
    }
}
