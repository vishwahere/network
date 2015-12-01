package com.coding.graph.trip.constraint;

import com.coding.graph.models.Train;

import java.util.List;

/**
 * Created by vsundareshan on 11/25/15.
 *
 * Trip constraint representing max distance of a path.
 */
public class LessThanDistance implements TripConstraint {

    private double distance;

    public LessThanDistance(double distance){
        this.distance = distance;
    }
    @Override
    public boolean met(List<Train> path) {
        if(isEmpty(path)){
            return false;
        }
        return getTotalDistance(path) < distance;
    }

    @Override
    public boolean exceeds(List<Train> path) {
        if(isEmpty(path)){
            return false;
        }
        return getTotalDistance(path) > distance;
    }
    private double getTotalDistance(List<Train> path){
        double totalDistance = 0d;
        for(Train train:path){
            totalDistance += train.getDistance();
        }
        return totalDistance;
    }
    public boolean isEmpty(List<Train> path){
        return path == null || path.size() <= 0;
    }
}
