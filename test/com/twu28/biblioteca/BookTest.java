package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before() throws Exception {
        book = new Book("Id1", "Java");
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testReserveBook() throws Exception {
        book.reserveBook();
        boolean Reserved = book.isReserved();
        assertEquals(Reserved, true);
    }

    @Test
    public void testUnReserveBook() throws Exception {
        book.reserveBook();
        book.unReserveBook();
        boolean Reserved = book.isReserved();
        assertEquals(Reserved, false);
    }
}