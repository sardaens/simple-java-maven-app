package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppConstructor() {
        try {
            new App();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testAppMain()
    {
        App.main(null);
        try {
            assertEquals("Hello World!" + System.getProperty("line.separator") +"8" + System.getProperty("line.separator"), outContent.toString());
        } catch (AssertionError e) {
            fail("\"message\" is not \"Hello World!\" 8");
        }
    }
    
    @Test
    public void testMathService()
    {
    	
        try {
            assertEquals(0, new MathService().add(null, null));
        } catch (AssertionError e) {
            fail("add null dont retrun 0");
        }
        
        try {
            assertEquals(0, new MathService().add(null, 5));
        } catch (AssertionError e) {
            fail("add null dont retrun 0");
        }
        
        try {
            assertEquals(0, new MathService().add(5, null));
        } catch (AssertionError e) {
            fail("add null dont retrun 0");
        }

        try {
            assertEquals(5, new MathService().add(3, 2));
        } catch (AssertionError e) {
            fail("add 3,2 dont return 5");
        }

        
    }
    
    

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
