package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Application application;
    private Book mockedBook;

    @Before
    public void before() throws Exception {
        application = new Application();
        mockedBook = mock(Book.class);
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testReserveAndInform() throws Exception {
        Method method = Application.class.getDeclaredMethod("reserveAndInform", Book.class);
        method.setAccessible(true);
        method.invoke(application, mockedBook);

        verify(mockedBook).reserveBook();
    }

} 
