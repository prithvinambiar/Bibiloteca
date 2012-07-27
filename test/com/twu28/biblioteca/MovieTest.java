package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    private Movie movie;

    @Before
    public void before() throws Exception {
        movie = new Movie("New Movie", "Director");
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSetRating() throws Exception {
        Method method = Movie.class.getDeclaredMethod("setRating", int.class);
        method.setAccessible(true);
        method.invoke(movie, 20);
        assertEquals(movie.getRating(), 0);
    }

} 
