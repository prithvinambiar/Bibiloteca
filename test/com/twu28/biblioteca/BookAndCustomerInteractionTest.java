/**
 * Created with IntelliJ IDEA.
 * User: prashu
 * Date: 24/7/12
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
package com.twu28.biblioteca;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import java.util.*;

// TODO - move these test to BookTest since invoking method on Book class
public class BookAndCustomerInteractionTest extends TestCase {
    private Book book;
    private Customer customer;
    private Customer MockedCustomer;

    public BookAndCustomerInteractionTest(String test) {
        super(test);
    }


    protected void setUp() throws Exception {
        book = new Book("Id1","Java");
        customer = new Customer("Num1","Prithvi");
        MockedCustomer = mock(Customer.class);
    }

    protected void tearDown() throws Exception {
    }

    public void testAddingToBookCollection() throws Exception{
        book.reserveBook(MockedCustomer);

        verify(MockedCustomer).addToBookCollection(book);
    }

    public void testRemovingFromBookCollection() throws Exception{
        book.reserveBook(MockedCustomer);
        book.unReserveBook();

        verify(MockedCustomer).removeFromBookCollection(book);
    }

    public void testReserveBook() throws Exception {
        book.reserveBook(customer);
        boolean Reserved = book.isReserved();
        assertEquals(Reserved,true);

        Customer BookHolder = book.getBookHolder();
        assertEquals(BookHolder,customer);

        List BookCollection = customer.getBookCollection();
        boolean IsBookPresent = BookCollection.contains(book);
        assertEquals(IsBookPresent,true);
    }

    public void testUnReserveBook() throws Exception{
        book.reserveBook(customer);
        book.unReserveBook();
        boolean Reserved = book.isReserved();
        assertEquals(Reserved,false);

        Customer BookHolder = book.getBookHolder();
        assertEquals(BookHolder,null);

        List BookCollection = MockedCustomer.getBookCollection();
        boolean IsBookPresent = BookCollection.contains(book);
        assertEquals(IsBookPresent,false);
    }

} 