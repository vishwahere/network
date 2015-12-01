package com.coding.graph.trip.constraint;

import com.coding.graph.models.Train;

import java.util.List;

/**
 * Created by vsundareshan on 11/25/15.
 *
 * Trip constraint representing max stops of a path.
 */
public class MaxStops extends ExactStops {
    public MaxStops(int stops){
        super(stops);
    }
    @Override
    public boolean met(List<Train> path) {
        if(isEmpty(path)){
            return false;
        }
        return path.size() <= stops;
    }
}
