package com.coding.graph.trip;

import com.coding.graph.TrainNetwork;
import com.coding.graph.models.City;
import com.coding.graph.trip.constraint.ExactStops;
import com.coding.graph.trip.constraint.LessThanDistance;
import com.coding.graph.trip.constraint.MaxStops;
import org.junit.Before;
import org.junit.Test;

import static com.coding.graph.trip.fixture.RailNetworkFixture.defaultRailNetwork;
import static org.junit.Assert.assertEquals;
/**
 * Created by vsundareshan on 11/25/15.
 */
public class TripCounterTest {
    private TrainNetwork trainNetwork;

    @Before
    public void setUp(){
        trainNetwork = defaultRailNetwork();
    }
    @Test
    public void getNumberOfRoutes(){
        assertEquals(2,new TripCounter(trainNetwork,new City("C"),new City("C"),new MaxStops(3)).count());
        assertEquals(3,new TripCounter(trainNetwork,new City("A"),new City("C"),new ExactStops(4)).count());
        assertEquals(7,new TripCounter(trainNetwork,new City("C"),new City("C"),new LessThanDistance(30)).count());
    }
}
