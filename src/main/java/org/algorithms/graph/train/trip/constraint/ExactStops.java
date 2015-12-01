package com.coding.graph.trip.constraint;

import com.coding.graph.models.Train;

import java.util.List;

/**
 * Created by vsundareshan on 11/25/15.
 *
 * Trip constraint representing exact number of stops of a path.
 */
public class ExactStops implements TripConstraint{
    protected int stops;

    public ExactStops(int stops){
        this.stops = stops;
    }
    @Override
    public boolean met(List<Train> path) {
        if(isEmpty(path)){
            return false;
        }
        return path.size() == stops;
    }

    @Override
    public boolean exceeds(List<Train> path) {
        if(isEmpty(path)){
            return false;
        }
        return path.size() > stops;
    }
    public boolean isEmpty(List<Train> path){
        return path == null || path.size() <= 0;
    }
}
