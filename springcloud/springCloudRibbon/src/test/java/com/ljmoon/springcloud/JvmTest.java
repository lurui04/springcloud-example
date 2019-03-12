package com.ljmoon.springcloud;

import org.junit.Test;

public class JvmTest {

    @Test
    public void testHeapGC() {
        byte[] b1 = new byte[1024 * 1024 / 2];
        byte[] b2 = new byte[1024 * 10248 * 8];
        b2 = null;
        b2 = new byte[1024 * 10248 * 8];
        System.gc();
    }
}
