package com.coding.graph.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by vsundareshan on 11/16/15.
 */
public class City {
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        City other = (City) obj;
        return new EqualsBuilder().append(name,other.name).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name",name).toString();
    }
}
