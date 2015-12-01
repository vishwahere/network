package com.coding.graph.trip.constraint;

import com.coding.graph.models.Train;

import java.util.List;

/**
 * Created by vsundareshan on 11/25/15.
 */
public interface TripConstraint {

    public boolean met(List<Train> path);
    public boolean exceeds(List<Train> path);
}
