package com.coding.graph.trip.constraint;

import com.coding.graph.models.Train;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by vsundareshan on 11/25/15.
 */
public class MaxStopsTest {
    @Test
    public void met(){
        //passes
        assertEquals(true, new MaxStops(2).met(Arrays.asList(new Train("A","B",30))));
        assertEquals(true, new MaxStops(2).met(Arrays.asList(new Train("A","B",20),new Train("A","B",10))));

        //fails
        assertEquals(false, new MaxStops(1).met(Arrays.asList(new Train("A","B",20),new Train("A","B",20))));
        assertEquals(false, new MaxStops(1).met(null));
        assertEquals(false, new MaxStops(1).met(new ArrayList<Train>()));
    }
}
