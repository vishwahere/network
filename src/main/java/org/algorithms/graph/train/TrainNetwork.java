package com.coding.graph;

import com.coding.graph.models.City;
import com.coding.graph.models.Train;

import java.util.*;

/**
 * Created by vsundareshan on 11/25/15.
 */
public class TrainNetwork {
    private Map<City,Map<City,Train>> networkMap = new HashMap<City,Map<City,Train>>();

    public TrainNetwork(List<Train> trains) {
        for(Train train:trains){
            Map<City,Train> sourceTrains = null;
            if(networkMap.containsKey(train.getStartCity())){
                sourceTrains = networkMap.get(train.getStartCity());
            }else{
                sourceTrains = new HashMap<City,Train>();
                networkMap.put(train.getStartCity(), sourceTrains);
            }
            sourceTrains.put(train.getEndCity(),train);
        }
    }
    public Map<City,Train> getConnections(City city){
        return Collections.unmodifiableMap(networkMap.get(city));
    }
    public Set<City> getAllCities() {
        return Collections.unmodifiableSet(networkMap.keySet());
    }

    public boolean containsCity(City city){
        return networkMap.containsKey(city);
    }
    public Train getDirectTrain(City from, City to){
        if(!containsCity(from) || !containsCity(to)){
            return null;
        }
        return networkMap.get(from).get(to);
    }
}
