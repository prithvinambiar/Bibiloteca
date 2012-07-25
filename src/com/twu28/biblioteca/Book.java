package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: prashu
 * Date: 22/7/12
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
// TODO - remove template comments
public class Book {
    // TODO - follow java conentions in naming variables
    private String BookId;
    private String BookName;
    private boolean Reserved;
    private Customer BookHolder;

    public Book(String BookId,String BookName){
        this.BookId = BookId;
        this.BookName = BookName;
    }

    public String getBookId(){
        return BookId;
    }

    public String getBookName(){
        return BookName;
    }

    public boolean isReserved(){
        return Reserved;
    }
    private void setReserved(boolean Reserved){
        this.Reserved = Reserved;
    }

    public Customer getBookHolder(){
        return this.BookHolder;
    }
    private void setBookHolder(Customer customer){
        this.BookHolder = customer;
    }
    // good, not breaking encapsulation here.
    public boolean reserveBook(Customer customer){
        if(this.isReserved())
            return false;

        this.setReserved(true);
        this.setBookHolder(customer);
        customer.addToBookCollection(this);
        return true;
    }

    public boolean unReserveBook(){
        if( !this.isReserved() )
            return false;

        this.setReserved(false);
        this.BookHolder.removeFromBookCollection(this);
        this.setBookHolder(null);
        return true;
    }
}
