## Synopsis

This is the solution for Problem one: Trains.

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
./gradlew test //Runs all the tests including jbehave

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

Once the setup is done, each test input given in original coding assignment maps to one when: block
ex: if problem statement states The distance of the route then there is corresponding when clause exactly matching this.


##Test results
The tests are all 100% passing. Check the directory /build/reports/tests and file index.html which has the details of each test run
