package com.coding.graph;

import com.coding.graph.models.City;
import com.coding.graph.models.Train;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.coding.graph.trip.fixture.RailNetworkFixture.defaultRailNetwork;
import static org.junit.Assert.*;


/**
 * Created by vsundareshan on 11/23/15.
 */
public class TrainNetworkTest {
    private static TrainNetwork trainNetwork;

    @BeforeClass
    public static void setUp(){
        trainNetwork = defaultRailNetwork();
    }
    @Test
    public void getConnections(){
        Map<City,Train> cityTrainMap = trainNetwork.getConnections(new City("A"));

        assertEquals(3, cityTrainMap.size());
        assertEquals(new Train(new City("A"),new City("B"),5),cityTrainMap.get(new City("B")));
        assertEquals(new Train(new City("A"),new City("D"),5),cityTrainMap.get(new City("D")));
        assertEquals(new Train(new City("A"), new City("E"), 7), cityTrainMap.get(new City("E")));
    }
    @Test
    public void getAllCities(){
        assertEquals(5, trainNetwork.getAllCities().size());
    }
    @Test
    public void containsCity(){
        assertTrue(trainNetwork.containsCity(new City("A")));
        assertFalse(trainNetwork.containsCity(new City("Z")));
    }
    @Test
    public void getDirectTrain(){
        assertEquals(new Train(new City("A"),new City("B"),5), trainNetwork.getDirectTrain(new City("A"),new City("B")));
        assertNull(trainNetwork.getDirectTrain(new City("A"), new City("C")));

    }
}
