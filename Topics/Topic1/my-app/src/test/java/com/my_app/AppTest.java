package com.my_app;



import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.my_app.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

  
    //Test for method sum between two positive numbers
    public void testSumaPositivos()
    {
    	System.out.println("adding two positive number ...");
    	App newApp = new App(3,7);
    	assertTrue(newApp.numberSum()==10);
    }
    
  //Test for method sum between two negative numbers
    public void testSumaNegativos()
    {
    	System.out.println("adding two negative number ...");
    	App newApp = new App(-3,-57);
    	assertTrue(newApp.numberSum()==-60);
    }
    //Test for method sum between positive and negative number
    public void testsumaAmbos()
    {
    	System.out.println("adding a positive number and a negative number ...");
    	App newApp = new App(3,-57);
    	assertTrue(newApp.numberSum()==-54);
    }
}
