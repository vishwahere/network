package com.coding.graph.trip;

import com.coding.graph.models.City;
import org.junit.Before;
import org.junit.Test;

import static com.coding.graph.trip.fixture.RailNetworkFixture.defaultRailNetwork;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by vsundareshan on 11/25/15.
 */
public class DistanceTest {
    private Distance distance;

    @Before
    public void setUp(){
        distance = new Distance(defaultRailNetwork());
    }
    @Test
    public void distanceOfRoute(){
        assertEquals(9.0d, distance.ofRoute(new City[]{new City("A"),new City("B"),new City("C")}));
        assertEquals(5.0d, distance.ofRoute(new City[]{new City("A"),new City("D")}));
        assertEquals(13.0d, distance.ofRoute(new City[]{new City("A"),new City("D"),new City("C")}));
        assertEquals(22.0d, distance.ofRoute(new City[]{new City("A"),new City("E"),new City("B"),new City("C"),new City("D")}));
        assertEquals(-1.0d, distance.ofRoute(new City[]{new City("A"), new City("E"), new City("D")}));
    }
}
