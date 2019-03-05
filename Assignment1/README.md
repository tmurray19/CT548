# CT548 Assignment 1 - Taidgh Murray - ID: 15315901

An attempt at assignment 1, trying to implement as much as asked in the md files

# The Program itself

### Functional Requriements
This program can:
-list all countries
-list the borders of a given country
-check if two countries are bordering
-get the population of a city or country (country adds up all cities population in its arraylist)
-List all the cities in the country
-List the capital of the country
-Prints the most efficient travel plan between two cities(In some cases, where a train and a plane are equally likely, the program will tend towards the plane)

### Non-functional Requirements
-The program has a 'Points of Interest' system implemented.
  = An arrayList is initialised in the Area class (so can easily be extended)
  = Accessors and Mutator implemented
  = In practice, the POIs should be stored in the json file
-Country population is (at the very least) equal to sum of cities
  = Only the city holds a population in the json file
  = It adds up all populations in cities and returns it
-Journey prioritises lowest legs possible through method implemented
  = You're always moving towards the destination in the most efficient way
-Journey always prefers flying plans if possible
-Data is all read from json file, user only queries the database

### Data Requirements

-Data is a modified json file from Blackboard
-Bordering list ensures travel by train is pairwise possible
  =Though, missing borders are possible, my geography is poor
-Flight is only possible between Capitals

### Design Requirements

-A strategy design pattern was attempted
  = I believe the implementation is correct
  = There may be much to be desired,  I only used the different strategies to print out different variants of the same texxt
  = Though that may be sufficient
-Polymorphism was implemented
  =Area class defines most of the generic vaiables, accesors & mutators
  =City & Country implement this Area class
  =Also allows for a Region class to be implemented easily
-I'm unsure if my deserialiser is sufficient for the assignment
  = I'm using org.simple.JSON


### Running the code
Simply run the 'WorldAtlas' java file, which includes the 'Main()' function driving the rest of the java files written.
When querying the JSON database, Please use capital letters. Error handling has been implemented, so the program escapes safely if an issue occurs.


# The submission
Included in this .zip file are:
  =Every 'java' file, in the 'src' folder
  =This readme
  =a .png of the finished program, generated with starUML
  =the modified json file, cities.json
  =the json reader, 'json-simple-1.1.1', in the 'lib' folder
Maven was not used
