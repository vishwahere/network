package com.coding.graph.trip;

import com.coding.graph.TrainNetwork;
import com.coding.graph.models.City;
import com.coding.graph.models.Train;
import com.coding.graph.trip.constraint.TripConstraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by vsundareshan on 11/24/15.
 */

/**
 * For a given network counts the number of trips between start and end city following the given tripConstraint.
 * This is not threadsafe as yet.
 */
public class TripCounter {
    private List<Stack<Train>> paths = new ArrayList<Stack<Train>>();
    private City startCity;
    private City endCity;
    private TrainNetwork network;
    private TripConstraint tripConstraint;

    public TripCounter(TrainNetwork network, City start, City end, TripConstraint tripConstraint){
        this.network = network;
        this.startCity = start;
        this.endCity = end;
        this.tripConstraint = tripConstraint;
    }
    public int count(){
        paths = new ArrayList<Stack<Train>>();
        generate(new Stack<Train>(),startCity,null,true);
        if(paths.size() == 0){
            throw new IllegalArgumentException("NO ROUTE(S) EXIST");
        }
        return paths.size();
    }
    //As of now I don't see enough abstraction for path generator to make it a separate class.
    private void generate(Stack<Train> path,City city,Train train,boolean start){

        if(tripConstraint.exceeds(path)){//Terminating condition
            return;
        }
        if(!start) {
            path.push(train);
        }
        if(city.equals(endCity) && tripConstraint.met(path)){
            Stack distinctPath = new Stack();
            distinctPath.addAll(path);
            paths.add(distinctPath);
        }
        for(Map.Entry<City,Train> entry:network.getConnections(city).entrySet()){
            generate(path,entry.getKey(),entry.getValue(),false);
        }

        if(!start) {
            path.pop();
        }
    }
}
