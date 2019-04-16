/*
* NUID: 001444756

* @author Harshitha Sangameshwarappa Gaddadhar
*/
package edu.neu.csye6200.bg;

import java.util.Observable;

/**
 * @author HarshithaGS
 * BGenerationSet is the main class where the number of generations of the plant growth is controlled.
 * ng / numbergen is the value that is entered in the textfield on ui for number of generations.
 * ruleVal/rule is the rule that the user selects 
 *
 */
public class BGGenerationSet extends Observable implements Runnable   {

	BGGenereation PlantSet1;// Initialization o fthe plant to be grown
	int ng;// variable to obtain the value of the number of generations of grwoth required from UI
	String ruleVal;// variable to obtain the rule that is selected by the usr in the UI

	//Constructor
	public BGGenerationSet(int numbergen , String rule){
		BGCanvas bgs = BGCanvas.instance();// creating a singleton instance variable
		addObserver(bgs); //Adding the canvas as the Observer	 so evry chnage in code can be monitered and printed on the canvas
		ng = numbergen;// variable that holds the no of generations
		ruleVal = rule; // variable that holds the rule number
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * RUN METHOD CONTAINING ALL TEST CODES
	 */
	public void run() { 
		{	
			//Plant 1
			PlantSet1 = new BGGenereation(1,"ROSE!!",300,50, ruleVal );
			for(int h=0;h< ng ;h++) {
				PlantSet1.Plant_growth();
				try {
					Thread.sleep(30L);
					setChanged();//Indicate that a change has happenend
					notifyObservers(this);// And notiify the observer(BGCanvas)
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				System.out.println("Plant1 's id is:"+ PlantSet1.Specimen_id);
				System.out.println("Plant1 's length :"+ PlantSet1.Type_name);
				System.out.println("number of children is :"+ PlantSet1.no_of_childern());
				PlantSet1.Plant_print();
				System.out.println("Length="+ PlantSet1.Check_height());
				System.out.println("Width="+ PlantSet1.Check_width());
			}
		}
	}



