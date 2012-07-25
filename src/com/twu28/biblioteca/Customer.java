package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: prashu
 * Date: 22/7/12
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;

public class Customer {

    private String CustomerName;
    private String LibraryNumber;
    private List BookCollection;

    public  Customer(String LibraryNumber,String CustomerName){
        this.CustomerName = CustomerName;
        this.LibraryNumber = LibraryNumber;
        BookCollection = new ArrayList<Book>();
    }

    public String getCustomerName(){
        return CustomerName;
    }

    public String getLibraryNumber(){
        return LibraryNumber;
    }

    public List<Book> getBookCollection(){
        return BookCollection;
    }

    public void addToBookCollection(Book book){
        BookCollection.add(book);
    }

    public void removeFromBookCollection(Book book){
        BookCollection.remove(book);
    }
}
