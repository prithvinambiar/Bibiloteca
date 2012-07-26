package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LaunchTest {

    private Launch launch;
    private Application mockedApplication;

    @Before
    public void before() throws Exception {
        mockedApplication = mock(Application.class);
        launch = new Launch(mockedApplication);
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindInputActionMethodForFirstCase() throws Exception {
        launch.findInputAction(1);
        verify(mockedApplication).displayBooks();
    }

    @Test
    public void testFindInputActionMethodForSecondCase() throws Exception {
        launch.findInputAction(2);
        verify(mockedApplication).reserveBook();
    }

    @Test
    public void testFindInputActionMethodForThirdCase() throws Exception {
        launch.findInputAction(3);
        verify(mockedApplication).getLibraryNumber();
    }
} 