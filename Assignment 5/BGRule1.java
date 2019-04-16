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
public class BGRule1 {
	ArrayList<Integer> angles = new ArrayList<Integer>(); // holds the list of angles for stem growth
	double lengths_for_stems;// holds the value of length for each stem to grow
	
	//lookup method to assign the length for each stem
	public double lookup_length(double childrenval ) {
		
			lengths_for_stems = 10.1;
		
		return lengths_for_stems;
	}
	
	//lookup method to assign the angles for each stem
	public ArrayList<Integer> lookup_angle(double angle) {
		if(angle==Math.toRadians(90)) {
			angles.add(45);
			angles.add(90);
			angles.add(135);/*
			angles.add(170);*/}
		else if(angle==Math.toRadians(45)) {
			angles.add(60);
			angles.add(90);
			angles.add(35);			angles.add(170);}

		else if( angle==Math.toRadians(135)){
			angles.add(60);
			angles.add(90);
			angles.add(35);			angles.add(170);}

		else if(angle ==Math.toRadians(35)) 
		{
			angles.add(80);
			angles.add(20);
			angles.add(22);			angles.add(170);}

		else if( angle ==Math.toRadians(60) )
		{
			angles.add(36);
			angles.add(99);
			angles.add(170);}				
		return angles;
	}}
