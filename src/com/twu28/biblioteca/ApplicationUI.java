package com.twu28.biblioteca;

import java.io.*;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: prashu
 * Date: 23/7/12
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
// TODO - replace all static methods. Static is EVIL.
public class ApplicationUI {

    private static List<Book> Books;
    private static List<Customer> Customers;

    private static void PopulateBooks(){
        for(int i=0;i<10;i++)
        {
            Book MyBook = new Book(i+"","BOOK"+i);
           // MyBook.setAvailable(true);
           // MyBook.setReserved(false);
            Books.add(MyBook);
        }
    }

    private static void PopulateCustomers(){
        for(int i=0;i<10;i++)
        {
            Customer MyCustomer = new Customer(i+"","CUSTOMER"+i);
            Customers.add(MyCustomer);
        }
    }

    public static void Initialize(){
        Books = new ArrayList<Book>();
        Customers = new ArrayList<Customer>();
        PopulateBooks();
        PopulateCustomers();
    }

    public static String readInput(){
        BufferedReader readInput = new BufferedReader(new InputStreamReader(System.in));
        try{
            return readInput.readLine();
        }
        catch (Exception e){System.out.println("Exception while reading from console. Exception details - "+e.getMessage());}
        return "";
    }

    private static Book getBookById(String BookId){
        for(Book EachBook : Books)
        {
            if(EachBook.getBookId().equals(BookId))
                return EachBook;
        }
        return null;
    }

    private static Customer getCustomerByLibraryNumber(String LibraryNumber){
        for(Customer EachCustomer : Customers)
        {
            if(EachCustomer.getLibraryNumber().equals(LibraryNumber))
                return EachCustomer;
        }
        return null;
    }

    public static void displayBooks(){
        for(Book EachBook : Books)
        {
            System.out.println("\n"+EachBook.getBookId()+"  :   "+EachBook.getBookName());
        }
    }

    public static void reserveBook(){
        System.out.print("Enter The Book Id   :   ");
        String BookId = readInput();
        System.out.println("Enter the Library Number before Reserving Book   :   ");
        String LibraryNumber = readInput();
        Book BookOfInterest = getBookById(BookId);
        Customer customer = getCustomerByLibraryNumber(LibraryNumber);

        boolean IsReserved = BookOfInterest.reserveBook(customer);
        if(IsReserved)
            System.out.println("Thank you ! Enjoy the book");
        else
            System.out.println("Sorry We don't have that book yet");
    }

    public static void getLibraryNumber(){
        System.out.println("Enter The Library Number   :    ");
        String LibraryNumber = readInput();
        Customer CustomerOfInterest = getCustomerByLibraryNumber(LibraryNumber);
        if(CustomerOfInterest == null)
        {
            System.out.println("Sorry! Customer with such library number doesn't exist");
        }
        else
            System.out.println("Please talk to Librarian. Thank You");
    }
}
