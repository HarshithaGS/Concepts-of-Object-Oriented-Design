/*Filename: PlantTest.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */

package edu.neu.csye6200.sim;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class PlantTest{
	Plant Plant1;
	Plant Plant2;
	Plant Plant3;
	Plant Plant4;
	Plant Plant5;

	FLowerPlant fp;

	private HashMap<Integer,Plant> PlantMap;// a hashmap to store all plants
	private ArrayList <Plant> PlantList;//create an arraylist instance
	private RegisterIO r;
	PlantRoster pr = PlantRoster.instance();
	
	public static Logger log = Logger.getLogger(PlantTest.class.getName());

	
	String fName = "C:/Users/HarshithaGS/Desktop/csye6200/Assign3/src/edu/neu/csye6200/assignment3/PlantFile.txt";

	//RUN METHOD CONTAINING ALL TEST CODES
	private void run_method() { 
		{	RegisterIO r = new RegisterIO();
		PlantMap = new HashMap<Integer,Plant>(); //Create a hashmap instance
		PlantList= new ArrayList<Plant>();

		//Plant 1
		Plant1 = new Plant(1,"ROSE!!",1,4,5) ;
		for(int h=0;h<5;h++) {
			Plant1.Plant_growth();
		}
		System.out.println("Plant1 's id is:"+ Plant1.Specimen_id);
		System.out.println("Plant1 's length :"+ Plant1.Type_name);
		System.out.println("Plant1 's base stem present or no is :"+ Plant1.checkbstem);
		System.out.println("number of children is :"+ Plant1.no_of_childern());
		Plant1.Plant_print();
		System.out.println("Lengt="+ Plant1.Check_height());
		System.out.println("Width="+ Plant1.Check_width());
		System.out.println("-----------------------------------------------");}

		//Plant 2
//		Plant2 = new Plant(2,"HERBS!!",1,2,3);
//		for(int h=0;h<2;h++) {
//			Plant2.Plant_growth();
//		}
//		System.out.println("\n\n\nPlant2's id is:"+ Plant2.Specimen_id);
//		System.out.println("Plant2 's length :"+ Plant2.Type_name);
//		System.out.println("Plant2 's base stem present or no is :"+ Plant2.checkbstem);
//		System.out.println("number of children is :"+ Plant2.no_of_childern());
//		Plant2.Plant_print();
//		System.out.println("Lengt="+ Plant2.Check_height());
//		System.out.println("Width="+ Plant2.Check_width());
//		System.out.println("-----------------------------------------------");


		//Plant 3
//		Plant3 = new Plant(3,"SHRUBS!!",1,11,5) ;// plant with base stem
//		for(int h=0;h<2;h++) {
//			Plant3.Plant_growth();
//		}
//		System.out.println("\n\n\nPlant3 's id is:"+ Plant3.Specimen_id);
//		System.out.println("Plant3 's length :"+ Plant3.Type_name);
//		System.out.println("Plant3 's base stem present or no is :"+ Plant3.checkbstem);
//		System.out.println("number of children is :"+ Plant3.no_of_childern());
//		Plant3.Plant_print();
//		System.out.println("Lengt="+ Plant3.Check_height());
//		System.out.println("Lengt="+ Plant3.Check_width());
//		System.out.println("-----------------------------------------------");


		//Plant 4
//		Plant4 = new Plant(4,"TREE!!",1,10,10) ;// plant with base stem
//		for(int h=0;h<2;h++) {
//			Plant4.Plant_growth();
//		}
//		System.out.println("\n\n\nPlant4 's id is:"+ Plant4.Specimen_id);
//		System.out.println("Plant4 's length :"+ Plant4.Type_name);
//		System.out.println("Plant4 's base stem present or no is :"+ Plant4.checkbstem);
//		System.out.println("number of children is :"+ Plant4.no_of_childern());
//		Plant4.Plant_print();
//		System.out.println("Lengt="+ Plant4.Check_height());
//		System.out.println("Lengt="+ Plant4.Check_width());
//		System.out.println("-----------------------------------------------");


		//Plant 5
//		Plant5 = new Plant(5,"CREEPER!!",1,9,0) ;// plant with base stem
//		for(int h=0;h<2;h++) {
//			Plant5.Plant_growth();
//		}
//		System.out.println("\n\n\nPlant5 's id is:"+ Plant5.Specimen_id);
//		System.out.println("Plant5 's length :"+ Plant5.Type_name);
//		System.out.println("Plant5 's base stem present or no is :"+ Plant5.checkbstem);
//		System.out.println("number of children is :"+ Plant5.no_of_childern());
//		Plant5.Plant_print();
//		System.out.println("Lengt="+ Plant5.Check_height());
//		System.out.println("Width="+ Plant5.Check_width());
//		System.out.println("-----------------------------------------------");
//

		//adding to the map
//		PlantMap.put(4, Plant4);
//		PlantMap.put(2, Plant2);
//		PlantMap.put(1, Plant1);
//		PlantMap.put(5, Plant5);
//		PlantMap.put(3, Plant3);

		//adding to the list
//		PlantList.add(Plant3);
//		PlantList.add(Plant1);
//		PlantList.add(Plant5);
//		PlantList.add(Plant2);	
//		PlantList.add(Plant4);

//creating a new flower plant
//		fp = new FLowerPlant(90,"hersheys",1,5,4,"BLUE",5);	
//		fp.FlowerPlant_growth();
//		fp.FlowerPlant_growth();
//		fp.FlowerPlant_growth();
//		fp.Plant_print();
//		System.out.println("-----------------------------------------------");
		
		//to clear the text file evrytime before writing to it
		/*PrintWriter writer;
		try {
			writer = new PrintWriter(fName);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//writing Plant to a file
		for(Plant  pt : PlantList) {
			r.save_method(pt);
		}
		
		//writing FlowerPlant to a file
		r.save_method1(fp);
		
		//writing the number of flowers and its details to the file
		fp.copy_flower_to_file( );
		
		//reading from a text file and printing on console
		r.load();
		System.out.println("-----------------------------------------------");

		//sending plant list to plantroster
		for(Plant  pllll : PlantList) {
			pr.add_Plant_list(pllll);
		}
		//sending flower plant instnace to the plantroster
		pr.add_Plant_list(fp);
		
		//to print the Plant before sorting
		System.out.println("PLANT LIST BEFORE SORTING");
		pr.disply_method();
		System.out.println("-----------------------------------------------");

		//call the sorting (quick sort) function
		pr.quick_sort();
		
		//to print plants after after sorting
		System.out.println("PLANT LIST AFTER SORTING");
		pr.disply_method();
		}*/
	}
	
	
	
	
	//MAIN FUNCTION
	public static void main(String[] args) {
		System.out.flush();
		PlantTest run_object = new PlantTest();
		log.info("run method executing");
		run_object.run_method();
		log.warning("Program EXECUTED successfully");
	}
}


