/*Filename: PlantTest.java

 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package assignment2b;
import java.util.ArrayList;
import java.util.HashMap;


public class PlantTest 
{	Plant Plant1;
Plant Plant2;
Plant Plant3;
Plant Plant4;
Plant Plant5;

private HashMap<Integer,Plant> PlantMap;// a hashmap to store all plants
private ArrayList <Plant> PlantList;//create an arraylist instance

public PlantTest() {
}

private void run_method() //run method containing all test codes
{
	PlantMap = new HashMap<Integer,Plant>(); //Create a hashmap instance
	PlantList= new ArrayList<Plant>();

	Plant1 = new Plant(1,"Rose",0,4,5) ;// plant with base stem
	for(int h=0;h<2;h++) {
		Plant1.Plant_growth();
	}
	System.out.println("Plant1 's id is:"+ Plant1.Specimen_id);
	System.out.println("Plant1 's length :"+ Plant1.Type_name);
	System.out.println("Plant1 's base stem present or no is :"+ Plant1.checkbstem);
	System.out.println("number of children is :"+ Plant1.no_of_childern());
	Plant1.Plant_print();


	Plant2 = new Plant(2,"herbs",1,2,3);// plant with no base stem
	for(int h=0;h<5;h++) {
		Plant2.Plant_growth();
	}
	System.out.println("\n\n\nPlant2's id is:"+ Plant2.Specimen_id);
	System.out.println("Plant2 's length :"+ Plant2.Type_name);
	System.out.println("Plant2 's base stem present or no is :"+ Plant2.checkbstem);
	System.out.println("number of children is :"+ Plant2.no_of_childern());
	Plant2.Plant_print();


	Plant3 = new Plant(3,"Shrubs",0,11,5) ;// plant with base stem
	for(int h=0;h<2;h++) {
		Plant3.Plant_growth();
	}
	System.out.println("\n\n\nPlant3 's id is:"+ Plant3.Specimen_id);
	System.out.println("Plant3 's length :"+ Plant3.Type_name);
	System.out.println("Plant3 's base stem present or no is :"+ Plant3.checkbstem);
	System.out.println("number of children is :"+ Plant3.no_of_childern());
	Plant3.Plant_print();

	Plant4 = new Plant(4,"Tree",0,10,10) ;// plant with base stem
	for(int h=0;h<2;h++) {
		Plant4.Plant_growth();
	}
	System.out.println("\n\n\nPlant4 's id is:"+ Plant4.Specimen_id);
	System.out.println("Plant4 's length :"+ Plant4.Type_name);
	System.out.println("Plant4 's base stem present or no is :"+ Plant4.checkbstem);
	System.out.println("number of children is :"+ Plant4.no_of_childern());
	Plant4.Plant_print();

	Plant5 = new Plant(5,"Creeper",1,9,0) ;// plant with base stem
	for(int h=0;h<2;h++) {
		Plant5.Plant_growth();
	}
	System.out.println("\n\n\nPlant5 's id is:"+ Plant5.Specimen_id);
	System.out.println("Plant5 's length :"+ Plant5.Type_name);
	System.out.println("Plant5 's base stem present or no is :"+ Plant5.checkbstem);
	System.out.println("number of children is :"+ Plant5.no_of_childern());
	Plant5.Plant_print();



	PlantMap.put(1, Plant1);
	PlantMap.put(2, Plant2);
	PlantMap.put(3, Plant3);
	PlantMap.put(4, Plant4);
	PlantMap.put(5, Plant5);

	for (Plant pl : PlantMap.values()) {
		System.out.println("Map: "+pl);
	}

}

public static void main(String[] args) {
	PlantTest run_object = new PlantTest();
	run_object.run_method();

}

}
