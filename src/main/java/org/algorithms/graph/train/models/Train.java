package com.coding.graph.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by vsundareshan on 11/16/15.
 */
public class Train {
    private City startCity;
    private City endCity;
    private double distance;

    public Train(City startCity, City endCity, double distance) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.distance = distance;
    }
    public Train(String start, String end, double distance) {
        this.startCity = new City(start);
        this.endCity = new City(end);
        this.distance = distance;
    }
    public City getStartCity() {
        return startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(startCity).append(endCity).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Train other = (Train) obj;
        return new EqualsBuilder().append(startCity,other.startCity).append(endCity,other.endCity).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(startCity).append("->",endCity).append(": ",distance).toString();
    }
}
