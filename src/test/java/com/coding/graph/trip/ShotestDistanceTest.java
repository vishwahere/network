package com.coding.graph.trip;

import com.coding.graph.TrainNetwork;
import com.coding.graph.models.City;
import org.junit.Before;
import org.junit.Test;

import static com.coding.graph.trip.fixture.RailNetworkFixture.defaultRailNetwork;
import static org.junit.Assert.assertEquals;


/**
 * Created by vsundareshan on 11/25/15.
 */
public class ShotestDistanceTest {
    private TrainNetwork trainNetwork;

    @Before
    public void setUp(){
        trainNetwork = defaultRailNetwork();
    }

    @Test
    public void shortestDistance(){
        ShortestDistance shortestDistance = new ShortestDistance(trainNetwork);
        assertEquals(9.0d, shortestDistance.get(new City("A"), new City("C")),0.d);
        assertEquals(9.0d, shortestDistance.get(new City("B"), new City("B")),0.d);
    }
}
