package com.brina;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
    HashMap hashMap;

    @Before
    public void init() {
        hashMap = new HashMap();
    }

    @Test
    public void putTest() {
        Assert.assertEquals(true, hashMap.put(5,10));
    }

    @Test
    public void putElementsWithTheSameKeysTest() {
        hashMap.put(5, 10);
        boolean expected = true;
        boolean actual = hashMap.put(5, 80);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void putEqualElementsTest() {
        hashMap.put(8, 80);
        boolean expected = false;
        boolean actual = hashMap.put(8, 80);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeTest(){
        hashMap.put(5,75);
        hashMap.put(80, 1500);
        hashMap.put(80, 400);
        hashMap.put(80, 400);
        Assert.assertEquals(2, hashMap.size());
    }

    @Test
    public void getTest() throws Exception {
        hashMap.put(5,75);
        hashMap.put(80, 1500);
        long expected = 75;
        Assert.assertEquals(expected, hashMap.get(5));
    }

    @Test(expected = Exception.class)
    public void getDegunctElementTest() throws Exception {
        hashMap.put(80, 1500);
        hashMap.get(5);
    }

    @Test
    public void increaseCapacityTest() {
        HashMap map = new HashMap(3);
        map.put(5, 75);
        map.put(6, 8);
        map.put(78, 9);
        map.put(4, 78);
        Assert.assertEquals(4, map.size());
    }
}
