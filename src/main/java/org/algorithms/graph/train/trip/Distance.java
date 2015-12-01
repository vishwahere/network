package com.coding.graph.trip;

import com.coding.graph.TrainNetwork;
import com.coding.graph.models.City;
import com.coding.graph.models.Train;

/**
 * Created by vsundareshan on 11/25/15.
 *
 * Sums up all direct distances between 2 points specified in the route. If there is not path between any successive
 * cities if the route, returns distance as -1.
 */
public class Distance {
    private TrainNetwork network;
    public Distance(TrainNetwork network){
        this.network = network;
    }
    public double ofRoute(City[] route){
        double distance = 0d;
        Train train = null;
        for(int index =0; index < route.length - 1;index ++){
            train = network.getDirectTrain(route[index],route[index + 1]);
            if(train != null){
                distance += train.getDistance();
            }else{
                distance = -1;
                break;
            }
        }
        return distance;
    }
}
