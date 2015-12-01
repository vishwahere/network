Meta:

Narrative:
As a user
I want to find distance of a given route
I want to find number of trips between 2 cities with maximum stops
I want to find number of trips between 2 cities exactly matching number of trips
I want to find number of trips between 2 cities less than specified maximum distance
I want to find shorted path between 2 cities (it could be roundtrip also)



Scenario: Find the distance of the given route. This is the original scenario given.

Given the routes with distance in the below table:
|StartCity|EndCity|Distance|
|A|B|5|
|B|C|4|
|C|D|8|
|D|C|8|
|D|E|6|
|A|D|5|
|C|E|2|
|E|B|3|
|A|E|7|
When The number of trips starting at C and ending at C with a maximum of 3 stops
Then number of trips is 2
When The number of trips starting at A and ending at C with exactly 4 stops
Then number of trips is 3
When The number of different routes from C to C with a distance of less than 30
Then number of trips is 7
When The length of the shortest route from A to C
Then length shortest distance is 9
When The length of the shortest route from B to B
Then length shortest distance is 9
When The distance of the route A,B,C
Then distance of route is 9
When The distance of the route A,D
Then distance of route is 5
When The distance of the route A,D,C
Then distance of route is 13
When The distance of the route A,E,B,C,D
Then distance of route is 22
When The distance of the route A,E,D
Then distance of route is NO SUCH ROUTE