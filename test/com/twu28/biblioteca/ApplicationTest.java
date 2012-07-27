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
    private User mockedUser;

    @Before
    public void before() throws Exception {
        application = new Application();
        mockedBook = mock(Book.class);
        mockedUser = mock(User.class);
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

    @Test
    public void testAuthenticateUser() throws Exception {
        Method method = Application.class.getDeclaredMethod("authenticateUser", User.class, String.class, String.class);
        method.setAccessible(true);
        method.invoke(application, mockedUser, "111-1111", "password");

        verify(mockedUser).confirmAuthentication("111-1111", "password");
    }
} 
