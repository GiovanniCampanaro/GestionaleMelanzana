package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void shouldAnswerWithFalse()
    {
        assertFalse( false );
    }
    @Test
    public void testApp()
    {
        App.main(null);
    }
    @Test
    public void testIstanza()
    {
        App pippo = new App();
        assertNotNull(pippo);
    }
}
