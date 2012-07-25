package com.twu28.biblioteca;

import java.io.*;
import java.util.*;

// TODO - replace all static methods. Static is EVIL.
public class Application {

    private static List<Book> Books;
    private static List<Customer> Customers;

    private void PopulateBooks(){
        for(int i=0;i<10;i++)
        {
            Book MyBook = new Book(i+"","BOOK"+i);
            Books.add(MyBook);
        }
    }

    private void PopulateCustomers(){
        for(int i=0;i<10;i++)
        {
            Customer MyCustomer = new Customer(i+"","CUSTOMER"+i);
            Customers.add(MyCustomer);
        }
    }

    public void Initialize(){
        Books = new ArrayList<Book>();
        Customers = new ArrayList<Customer>();
        PopulateBooks();
        PopulateCustomers();
    }

    public String readInput(){
        BufferedReader readInput = new BufferedReader(new InputStreamReader(System.in));
        try{
            return readInput.readLine();
        }
        catch (Exception e){System.out.println("Exception while reading from console. Exception details - "+e.getMessage());}
        return "";
    }

    private Book getBookById(String BookId){
        for(Book EachBook : Books)
        {
            if(EachBook.getBookId().equals(BookId))
                return EachBook;
        }
        return null;
    }

    private Customer getCustomerByLibraryNumber(String LibraryNumber){
        for(Customer EachCustomer : Customers)
        {
            if(EachCustomer.getLibraryNumber().equals(LibraryNumber))
                return EachCustomer;
        }
        return null;
    }

    public void displayBooks(){
        for(Book EachBook : Books)
        {
            System.out.println("\n"+EachBook.getBookId()+"  :   "+EachBook.getBookName());
        }
    }

    // TODO - simplify method to make it easily understandable
    public void reserveBook(){
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

    public void getLibraryNumber(){
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
