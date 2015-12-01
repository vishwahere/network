package com.coding.graph.trip.constraint;

import com.coding.graph.models.Train;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by vsundareshan on 11/25/15.
 */
public class ExactStopsTest {
    @Test
    public void met(){
        //passes
        assertEquals(true, new ExactStops(2).met(Arrays.asList(new Train("A","B",20),new Train("A","B",10))));

        //fails
        assertEquals(false, new ExactStops(2).met(Arrays.asList(new Train("A","B",20))));
        assertEquals(false, new ExactStops(1).met(Arrays.asList(new Train("A","B",20),new Train("A","B",20))));
        assertEquals(false, new ExactStops(1).met(null));
        assertEquals(false, new ExactStops(1).met(new ArrayList<Train>()));
    }
    @Test
    public void exceeded(){
        //passes
        assertEquals(true, new ExactStops(1).exceeds(Arrays.asList(new Train("A", "B", 20), new Train("A", "B", 10))));

        //fails
        assertEquals(false, new ExactStops(2).exceeds(Arrays.asList(new Train("A", "B", 20))));
        assertEquals(false, new ExactStops(1).exceeds(null));
        assertEquals(false, new ExactStops(1).exceeds(new ArrayList<Train>()));
    }
}
