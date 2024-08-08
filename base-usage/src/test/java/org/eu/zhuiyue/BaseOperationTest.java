package org.eu.zhuiyue;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BaseOperationTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BaseOperationTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BaseOperationTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        BaseOperation.sinceAdd();
        assertFalse( BaseOperation.compare() );
    }
}
