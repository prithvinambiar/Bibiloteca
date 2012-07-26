package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Book> bookList;
    private static List<Customer> customerList;

    private void populateBooks() {
        for (int iterator = 0; iterator < 10; iterator++) {
            Book myBook = new Book(iterator + "", "BOOK" + iterator);
            bookList.add(myBook);
        }
    }

    private void populateCustomers() {
        for (int iterator = 0; iterator < 10; iterator++) {
            Customer myCustomer = new Customer(iterator + "", "CUSTOMER" + iterator);
            customerList.add(myCustomer);
        }
    }

    public Application() {
        bookList = new ArrayList<Book>();
        customerList = new ArrayList<Customer>();
        populateBooks();
        populateCustomers();
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

    private Customer getCustomerByLibraryNumber(String libraryNumber) {
        for (Customer eachCustomer : customerList) {
            if (eachCustomer.getLibraryNumber().equals(libraryNumber))
                return eachCustomer;
        }
        return null;
    }

    public void displayBooks() {
        for (Book eachBook : bookList) {
            System.out.println("\n" + eachBook.getBookId() + "  :   " + eachBook.getBookName());
        }
    }

    private Customer getCustomer() {
        System.out.println("Enter the Library Number  :   ");
        String libraryNumber = readInput();
        return getCustomerByLibraryNumber(libraryNumber);
    }

    private Book getBook() {
        System.out.print("Enter The Book Id   :   ");
        String bookId = readInput();
        return getBookById(bookId);
    }

    private void reserveAndInform(Book bookOfInterest, Customer customer) {
        boolean isReserved = bookOfInterest.reserveBook(customer);
        if (isReserved)
            System.out.println("Thank you ! Enjoy the book");
        else
            System.out.println("Sorry We don't have that book yet");
    }

    public void reserveBook() {
        Book bookOfInterest = getBook();
        Customer customer = getCustomer();
        reserveAndInform(bookOfInterest, customer);
    }

    public void getLibraryNumber() {
        Customer customerOfInterest = getCustomer();
        if (customerOfInterest == null) {
            System.out.println("Sorry! Customer with such library number doesn't exist");
        } else
            System.out.println("Please talk to Librarian. Thank You");
    }
}
