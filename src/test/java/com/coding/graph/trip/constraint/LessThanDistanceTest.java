package com.coding.graph.trip.constraint;

import com.coding.graph.models.Train;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by vsundareshan on 11/25/15.
 */
public class LessThanDistanceTest {
    @Test
    public void met(){
        //passes
        assertEquals(true, new LessThanDistance(30).met(Arrays.asList(new Train("A", "B", 20), new Train("A", "B", 9))));
        assertEquals(true, new LessThanDistance(30).met(Arrays.asList(new Train("A","B",20))));

        //fails
        assertEquals(false, new LessThanDistance(30).met(Arrays.asList(new Train("A", "B", 20), new Train("A", "B", 10))));//exact 30
        assertEquals(false, new LessThanDistance(10).met(Arrays.asList(new Train("A","B",20))));
        assertEquals(false, new LessThanDistance(20).met(Arrays.asList(new Train("A","B",10),new Train("A","B",20))));
        assertEquals(false, new LessThanDistance(30).met(null));
        assertEquals(false, new LessThanDistance(20).met(new ArrayList<Train>()));
    }
    @Test
    public void exceeded(){
        //passes
        assertEquals(true, new LessThanDistance(1).exceeds(Arrays.asList(new Train("A", "B", 20), new Train("A", "B", 10))));

        //fails
        assertEquals(false, new LessThanDistance(30).exceeds(Arrays.asList(new Train("A", "B", 20))));
        assertEquals(false, new LessThanDistance(30).exceeds(null));
        assertEquals(false, new LessThanDistance(30).exceeds(new ArrayList<Train>()));
    }
}
