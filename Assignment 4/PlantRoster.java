/*Filename: PlantRooster.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package edu.neu.csye6200.sim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class PlantRoster {


	public static Logger log = Logger.getLogger(PlantRoster.class.getName());

	static ArrayList<Plant> Plants_List_Rooster = new ArrayList<Plant>();


	private static PlantRoster instance = null; // The one and only copy of the inst
	
	//file handler for logs
	public PlantRoster() {
		java.util.logging.Handler handler = null;
		log.info("constructing a PlantRooster instance ");

		try {
			handler = new FileHandler(
					"C:\\Users\\HarshithaGS\\Desktop\\csye6200\\oop_assignment _4\\src\\edu\\neu\\csye6200\\sim\\server.log");
			handler.setFormatter(new SimpleFormatter());
			handler.setLevel(Level.ALL);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		log.addHandler(handler);
	}


	// method to have a list of plants in this class
	public void add_Plant_list(Plant pr) {
		Plants_List_Rooster.add(pr);
		log.warning("Added a PlantList in Rooster class");
	}


	//sorting using collections package
	public  void sorting() {
		Collections.sort(Plants_List_Rooster);

	}

	public void disply_method() {
		for (Plant p : Plants_List_Rooster) {
			System.out.println("List: "+p);
			log.info("Printing  Plants of the  Rooster class");
		}
	}

		//sorting using the quick sort algorithm- call the sort function 
		public void quick_sort() {
			try {
				sort(Plants_List_Rooster , 0 , Plants_List_Rooster.size()-1);
				log.warning("Sorting function called to sort the PlantList in Rooster class");}
			catch(SecurityException e){
				e.getStackTrace();	
				log.severe(" Exception raised ");
			}

		}
		
		//recursive sort function
		ArrayList<Plant> sort(ArrayList<Plant> Plants_List_Rooster, int startIndex, int EndIndex){
			if (startIndex < EndIndex){
				int splitPoint = partition(Plants_List_Rooster, startIndex, EndIndex);
				sort(Plants_List_Rooster, startIndex, splitPoint);
				sort(Plants_List_Rooster, splitPoint +1, EndIndex);
			}
			return Plants_List_Rooster;
		}

		private int partition(ArrayList<Plant> Plants_List_Rooster, int startIndex, int EndIndex){
			Plant pivot = Plants_List_Rooster.get(startIndex);//fixing the center element as the pivot
			startIndex--;
			EndIndex++;
			while (true){
				startIndex++;
				while (startIndex<EndIndex && (  (Plant) Plants_List_Rooster.get(startIndex)).compareTo(pivot) < 0){
					startIndex++;
				}
				EndIndex--;
				while (EndIndex>startIndex && Plants_List_Rooster.get(EndIndex).compareTo(pivot) >= 0){
					EndIndex--;
				}
				if (startIndex<EndIndex){
					swap(Plants_List_Rooster, startIndex, EndIndex);
				}else {
					return EndIndex;
				}
			}
		}
		
		//method to swap elemenst within the same list
		private ArrayList<Plant> swap(ArrayList<Plant>Plants_List_Rooster , int a, int b){
			Plant temp = Plants_List_Rooster.get(a);
			Plants_List_Rooster.set(a, Plants_List_Rooster.get(b));
			Plants_List_Rooster.set(b, temp);
			return Plants_List_Rooster;
		}

		public static PlantRoster instance() {// makes this class a singleton class
			if (instance ==null) instance = new PlantRoster();
			return(instance);
		}

	}















