package com.example.msp.androidlayout;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msp on 2017/7/2.
 */
public class CalculatorTest {

    private  Calculator cal;
    @Before
    public void setUp() throws Exception {
        cal = new Calculator();
    }

    @Test
    public void testAdd() throws Exception {
        int result = cal.add(2,3);
        assertEquals(result,51);
        Log.i("tag","日志猫测试2");
    }
}