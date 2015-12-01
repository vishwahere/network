package com.coding.graph.trip;

import com.coding.graph.TrainNetwork;
import com.coding.graph.models.City;
import com.coding.graph.models.Train;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by vsundareshan on 11/25/15.
 *
 * Returns shortest distance between 2 points. Also handles cycles.
 */
public class ShortestDistance {

    private TrainNetwork network;

    public ShortestDistance(TrainNetwork network){
        this.network = network;
    }
    public double get(City start,City end){
        Set<City> unvisited = new HashSet<City>();
        Map<City,Double> distanceMap = new HashMap<City, Double>();
        boolean roundTrip = start.equals(end)? true:false; //way to indicate this could be roundtrip path.
        for(City city: network.getAllCities()){
            distanceMap.put(city,Double.MAX_VALUE);
            unvisited.add(city);
        }
        distanceMap.put(start, 0.d);
        City next;
        while(!unvisited.isEmpty()){
            next = nextClosest(distanceMap,unvisited);

            if(next == null) {
                break;
            }//next is null for unreachable vertex or after all vertices are visited
            unvisited.remove(next);
            relaxEdge(next, distanceMap);
            if (roundTrip) {
                //we started with zero distance for origin, but should be reset if we want to find roundtrip shortest distance.
                roundTrip = false;
                distanceMap.put(start, Double.MAX_VALUE);
                unvisited.add(start);
            }
        }
        return distanceMap.get(end);
    }
    //Resolve the edge
    private void relaxEdge(City city,Map<City,Double> distanceMap){
        Map<City,Train> neighbours = network.getConnections(city);
        for(Map.Entry<City,Train> entry: neighbours.entrySet()){
            final double distance = distanceMap.get(city) + entry.getValue().getDistance();
            if(distance < distanceMap.get(entry.getKey())){
                distanceMap.put(entry.getKey(),distance);
            }

        }
    }
    //Get next closest city
    private City nextClosest(Map<City,Double> distanceMap,Set<City> unvisited){
        Double max = Double.MAX_VALUE;
        City nextClosest = null;
        for(City city: distanceMap.keySet()){
            if(unvisited.contains(city) && distanceMap.get(city).compareTo(max) == -1){
                max = distanceMap.get(city);
                nextClosest = city;
            }
        }
        return nextClosest;
    }
}
