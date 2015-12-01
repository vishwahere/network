package com.coding.graph;

import com.coding.graph.models.City;
import com.coding.graph.models.Train;
import com.coding.graph.trip.Distance;
import com.coding.graph.trip.ShortestDistance;
import com.coding.graph.trip.TripCounter;
import com.coding.graph.trip.constraint.ExactStops;
import com.coding.graph.trip.constraint.LessThanDistance;
import com.coding.graph.trip.constraint.MaxStops;
import com.coding.graph.trip.constraint.TripConstraint;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.RethrowingFailure;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by vsundareshan on 11/25/15.
 */
public class TrainNetworkBDD extends JUnitStory {
    City[] route;
    private TrainNetwork network;
    private TripConstraint tripConstraint;
    private City startCity;
    private City endCity;

    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useFailureStrategy(new RethrowingFailure())
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withFormats(Format.CONSOLE, Format.HTML,
                                Format.IDE_CONSOLE, Format.TXT, Format.STATS, Format.XML));

    }

    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), this)
                .createCandidateSteps();
    }

    @Given("the routes with distance in the below table: $weightedRoutingTable")
    public void giveRoutesWithDistance(ExamplesTable weightedRoutingTable){
        List<Train> trains = new ArrayList<Train>();
        for (Map<String,String> row : weightedRoutingTable.getRows()) {
            trains.add(new Train(row.get("StartCity"), row.get("EndCity"),Double.parseDouble(row.get("Distance"))));
        }
        network = new TrainNetwork(trains);
    }
    @When("The number of trips starting at $start and ending at $end with a maximum of $stops stops")
    public void maxStops(String start,String end,int stops){
        startCity = new City(start);
        endCity = new City(end);
        tripConstraint = new MaxStops(stops);
    }
    @When("The number of trips starting at $start and ending at $end with exactly $stops stops")
    public void exactStops(String start,String end,int stops){
        startCity = new City(start);
        endCity = new City(end);
        tripConstraint = new ExactStops(stops);
    }
    @When("The number of different routes from $start to $end with a distance of less than $distance")
    public void lessThanDistance(String start,String end,String distance){
        startCity = new City(start);
        endCity = new City(end);
        tripConstraint = new LessThanDistance(Double.parseDouble(distance));
    }
    @Then("number of trips is $expectedTrips")
    public void expectedTrips(int expectedTrips){
        assertEquals(expectedTrips,new TripCounter(network,startCity,endCity,tripConstraint).count());
    }
    @When("The length of the shortest route from $start to $end")
    public void findLengthOfShortestDistance(String start,String end){
        startCity = new City(start);
        endCity = new City(end);
    }
    @Then("length shortest distance is $shortestDistance")
    public void lengthOfShortestDistance(String shortestDistance){
        assertEquals(Double.parseDouble(shortestDistance),new ShortestDistance(network).get(startCity,endCity));
    }
    @When("The distance of the route $cities")
    public void givenCities(List<String> cities){
        route = new City[cities.size()];
        int index = 0;
        for(String city:cities){
            route[index++] = new City(city);
        }
    }
    @Then("distance of route is $expected")
    public void distanceOfRoute(String expected){
        double actualDistance = new Distance(network).ofRoute(route);
        if(actualDistance == -1){
            assertEquals(expected,"NO SUCH ROUTE");
        }else{
            assertEquals(Double.parseDouble(expected),actualDistance);
        }
    }
}
