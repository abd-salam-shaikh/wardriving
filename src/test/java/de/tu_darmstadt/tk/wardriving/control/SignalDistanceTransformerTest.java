/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tu_darmstadt.tk.wardriving.control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author abd_salam_shaikh
 */
public class SignalDistanceTransformerTest {
    
    public SignalDistanceTransformerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of transformSignal method, of class SignalDistanceTransformer.
     */
    @Test
    public void testTransformSignal() {
        System.out.println("transformSignal");
        double rssi = -60.0;
        SignalDistanceTransformer instance = new SignalDistanceTransformer();
        double expResult = 2.6240189280042014;
        double result = instance.transformSignal(rssi);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of calFeetToMeter method, of class SignalDistanceTransformer.
     */
    @Test
    public void testCalFeetToMeter() {
        System.out.println("calFeetToMeter");
        double distance = 0.0;
        double expResult = 0.0;
        double result = SignalDistanceTransformer.calFeetToMeter(distance);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
