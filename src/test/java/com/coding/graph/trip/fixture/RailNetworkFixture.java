package com.coding.graph.trip.fixture;

import com.coding.graph.TrainNetwork;
import com.coding.graph.models.City;
import com.coding.graph.models.Train;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vsundareshan on 11/25/15.
 */
public class RailNetworkFixture {
    public static TrainNetwork defaultRailNetwork(){
        List<Train> trains = new ArrayList<Train>();
        trains.add(new Train(new City("A"),new City("B"),5));
        trains.add(new Train(new City("B"),new City("C"),4));
        trains.add(new Train(new City("C"),new City("D"),8));
        trains.add(new Train(new City("D"),new City("C"),8));
        trains.add(new Train(new City("D"),new City("E"),6));
        trains.add(new Train(new City("A"),new City("D"),5));
        trains.add(new Train(new City("C"),new City("E"),2));
        trains.add(new Train(new City("E"),new City("B"),3));
        trains.add(new Train(new City("A"),new City("E"),7));

        return new TrainNetwork(trains);

    }
}
