/**
 * Created with IntelliJ IDEA.
 * User: prashu
 * Date: 22/7/12
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
// TODO - remove template comments.
package com.twu28.biblioteca;

import junit.framework.TestCase;
import org.mockito.Mockito.*;
import junit.framework.Assert.*;

// TODO - Rename it according to convention, BookTest rather than BookTests
public class BookTests extends TestCase {
    private Book book;

    public BookTests(String test) {
        super(test);
    }


    protected void setUp() throws Exception {
        book = new Book("BookId","BookTitle");
    }


    protected void tearDown() throws Exception {

    }

    public void testFindingBookId() throws Exception {
        // TODO - no point testing getters and setters
        String ExpectedId = book.getBookId();
        assertEquals(ExpectedId,"BookId");
    }

    public void testFindingBookName() throws Exception{
        // TODO - no point testing getters and setters
        String ExpectedName = book.getBookName();
        assertEquals(ExpectedName,"BookTitle");
    }
}