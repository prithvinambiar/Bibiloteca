package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void before() throws Exception {
        user = new User("111-1113", "password");
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testConfirmAuthentication() throws Exception {
        assertEquals(user.confirmAuthentication("111-1113", "password"), true);
        assertEquals(user.confirmAuthentication("111-1113", "wrongPassword"), false);
    }

    @Test
    public void testSetUsername() throws Exception {

/* 
try { 
   Method method = User.getClass().getMethod("setUsername", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
