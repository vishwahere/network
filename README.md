## Synopsis


This is the solution for rail network challenge where routes are directed (i.e A->B doesn't imply B->A). There are algorithms for below queries

1. Shotest path between 2 cities (including roundtrip)

2. Number of paths/trips between 2 cities with distance less than given distance (distance = weight)

3. Number of paths/trips between 2 cities with maximum stops

4. Number of paths/trips between 2 cities with exact number of stops

All above network related queries also handles cases where a given city is traversed more than once. For example a query can be shortest path between City A and City A.


##Details
Programming language: Java using version 1.8.0_51

Automated Tests: Junit, Jbehave

Build tool: gradle

##Design:
For finding shortest path, modified version of dijkstra's algorithm is used in order to handle a route traversing a vertex/city multiple times.
Shortest path algorithm could be improvised using a priority queue and also caching routes.

For finding number of trips customized dfs is used. Each time a path is created whether constraint is exceeded check is made
to avoid path explosion since we want to allow traversing through a city multiple times.

## Command to run test
./gradlew test

## Adding jbehave test
Open the text file at location: com/coding/assignment/train_network_b_d_d.story
This is the jbehave story file to add any new test

The test is organized as one scenario containing one setup and multiple steps.
setup step starts with below text
Given the routes with distance in the below table:

followed by pipe delimited format of a train connection. The first row of pipe delimited data is the below header row
|StartCity|EndCity|Distance|

Above header row acts as key within the code to read the column wise data for each row.

Following this a train connection between 2 cities is represented as
|A|B|5|

meaning there is a Train connection between cities A and B with distance 5
