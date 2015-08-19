package kz.essc.test;

import java.io.IOException;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws IOException {
        App app = new App();
        Map<String, Double> map = app.process();
        assertTrue(map.get("({a, o},6)") == 2.5);
        assertTrue(map.get("({a, o},5)") == 2.0);
        assertTrue(map.get("({a, e},4)") == 2.0);
    }
}
