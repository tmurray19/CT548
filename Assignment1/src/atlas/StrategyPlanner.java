package atlas;

public interface StrategyPlanner {
	//This file is to allow for the 'Strategy' design pattern
	//Interface which allows algorithm selection at runtime
	//In this case, instead of an algorithm, it chooses travel type
	
	/*
	This should allow users to choose whether they travel by
		Plane
		Bus
		Train
	To get where they want to go.
	
	*/
	
	static void fromTo(String A, String B) {
		Country a = new Country(A);
		Country b = new Country(B);
	}
	
	static String byPlane() {
		return "Plane";
	}
	
	static String byBus() {
		return "Bus";
	}

	static String byTrain() {
		return "Train";
	}
	
	/*TODO:
	 * Add Population to data
	 * Allow for reading from 
	 */
}