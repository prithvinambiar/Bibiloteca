/**
 * Created with IntelliJ IDEA.
 * User: prashu
 * Date: 24/7/12
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
package com.twu28.biblioteca;

import junit.framework.TestCase;

public class CustomerTests extends TestCase {
    private Customer customer;

    public CustomerTests(String test) {
        super(test);
    }


    protected void setUp() throws Exception {
        customer = new Customer("LibraryNumber","CustomerName");
    }

    protected void tearDown() throws Exception {
    }

    public void testFindingLibraryNumber() throws Exception {
        // TODO - no point testing getters.
        String ExpectedId = customer.getLibraryNumber();
        assertEquals(ExpectedId,"LibraryNumber");
    }

    public void testFindingCustomerName() throws Exception{
        // TODO - no point testing getters.
        String ExpectedId = customer.getCustomerName();
        assertEquals(ExpectedId,"CustomerName");
    }
} 