package edu.wctc.eligrow.test;

import edu.wctc.eligrow.SortMap;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SortMapTest {

    HashMap<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new HashMap<String, Integer>();
        map.put("a", 3);
        map.put("b", 2);
        map.put("c", 1);
        SortMap.sortByValue(map);
    }

    @Test
    public void testSortByValue() {
        String s = map.keySet().toString();
        assertEquals("C", s);
    }
}