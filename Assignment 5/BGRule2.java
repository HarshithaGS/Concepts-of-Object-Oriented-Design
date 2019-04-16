
/*
* NUID: 001444756
* @author Harshitha Sangameshwarappa Gaddadhar
*/
package edu.neu.csye6200.bg;

import java.util.ArrayList;

/**
 * @author HarshithaGS
 * This rule has two different subrules to select the angle with which the stems will grow and also gives length of the stems and the 
 *
 */
public class BGRule2 {
	//lookup method to assign the length for each stem
	ArrayList<Integer> angles = new ArrayList<Integer>();
	double lengths_for_stems;// holds the value of length for each stem to grow

	public double lookup_length(double childrenval ) {
			lengths_for_stems = 20;
		
		return lengths_for_stems;
	}
	
	//lookup method to assign the angles for each stem
	public ArrayList<Integer> lookup_angle(double angle) {
		if(angle==Math.toRadians(90)) {
			angles.add(20);
			angles.add(90);
			angles.add(160);}
		else if(angle==Math.toRadians(20)) {
			angles.add(20);
			angles.add(90);
			angles.add(160);}
		else if( angle==Math.toRadians(90)){
			angles.add(20);
			angles.add(90);
			angles.add(160);}
		else if(angle ==Math.toRadians(160)) 
		{
			angles.add(160);
			angles.add(90);
			angles.add(135);}
		else if( angle ==Math.toRadians(60) )
		{
			angles.add(160);
			angles.add(90);
			angles.add(135);}					
		return angles;
	}
}
