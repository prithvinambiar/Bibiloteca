package com.twu28.biblioteca;

import java.util.*;
// TODO - remove customer since not used functionally.
public class Customer {
    // TODO - naming convention
    private String CustomerName;
    private String LibraryNumber;
    // TODO - use generics properly, have List<Book>
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

    // TODO - breaking encapsulation, rather delegate required behavior to Customer
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
