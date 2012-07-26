package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {
    private Book book;
    private Customer customer;
    private Customer mockedCustomer;

    public BookTest() {
    }

    @Before
    public void setUp() throws Exception {
        book = new Book("Id1", "Java");
        customer = new Customer("Num1", "Prithvi");
        mockedCustomer = mock(Customer.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddingToBookCollection() throws Exception {
        book.reserveBook(mockedCustomer);

        verify(mockedCustomer).addToBookCollection(book);
    }

    @Test
    public void testRemovingFromBookCollection() throws Exception {
        book.reserveBook(mockedCustomer);
        book.unReserveBook();

        verify(mockedCustomer).removeFromBookCollection(book);
    }

    @Test
    public void testReserveBook() throws Exception {
        book.reserveBook(customer);
        boolean Reserved = book.isReserved();
        assertEquals(Reserved, true);

        Customer BookHolder = book.getBookHolder();
        assertEquals(BookHolder, customer);

        List BookCollection = customer.getBookCollection();
        boolean IsBookPresent = BookCollection.contains(book);
        assertEquals(IsBookPresent, true);
    }

    @Test
    public void testUnReserveBook() throws Exception {
        book.reserveBook(customer);
        book.unReserveBook();
        boolean Reserved = book.isReserved();
        assertEquals(Reserved, false);

        Customer BookHolder = book.getBookHolder();
        assertEquals(BookHolder, null);

        List BookCollection = mockedCustomer.getBookCollection();
        boolean IsBookPresent = BookCollection.contains(book);
        assertEquals(IsBookPresent, false);
    }
}