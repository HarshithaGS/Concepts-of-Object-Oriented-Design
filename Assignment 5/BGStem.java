/*
* NUID: 001444756
* @author Harshitha Sangameshwarappa Gaddadhar
*/
package edu.neu.csye6200.bg;

import java.util.ArrayList;

public class BGStem {

	static private int idCounter = 0;
	int x;
	int y;

	private int[][] start_location = new int[2][2];
	private int id;
	private double length;
	private double growth_angle;//in radians

	ArrayList<BGStem> ChildStemList = new ArrayList<BGStem>();

	//COSTRUCTOR
	public BGStem(double length,double growth_direction,int x,int y) {
		id =(idCounter++);//gives a unique id
		this.length=length; //length measured in centimeters
		this.growth_angle=(Math.toRadians(growth_direction)); // measured in radians
		//gives the start_location
		this.start_location[0][0] =x;
		this.start_location[0][1] =y;
		// gives me the end location
		this.start_location[1][0] = (int) (start_location[0][0] +length*Math.cos(Math.toRadians(growth_direction)));//x new
		this.start_location[1][1] = (int) (start_location[0][1] +length*Math.sin(Math.toRadians(growth_direction)));//y new
	}


	public void Display(){
	//System.out.println("-------------------------------");
	if(!this.ChildStemList.isEmpty()) {
		for (BGStem st : ChildStemList) {
			System.out.println("Child stems:" + st.toString1());
			st.Display();
			}
		System.out.println("-----------------------------");
	}}

	//method to add child stems to list
	public void adding_method(BGStem ChildStems) {
		ChildStemList.add(ChildStems);
	}

	//method to list number of children for each stem
	public int list_no_of_childern() {
		int count_children=ChildStemList.size();
		return count_children;
	}

	//method to determine if child list is empty
	public boolean check_child_list() {
		if(this.ChildStemList.isEmpty()) {
			return true;
		}
		else
		return false;
	}
	
	//printing format
	public String toString1() {
		return String.format("Stem> %1$01d %2$5.2f %3$5.2f %4$01d %5$01d %6$01d %7$01d" ,id, length,growth_angle,start_location[0][0],start_location[0][1],start_location[1][0],start_location[1][1]);
	}
	
	//getters and setters for all
		public int[][] getStart_location() {
			return start_location;
		}

		public void setStart_location(int[][] start_location) {
			this.start_location = start_location;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getLength() {
			return length;
		}

		public void setLength(double length) {
			this.length = length;
		}

		public double getGrowth_angle() {
			return growth_angle;
		}

		public void setGrowth_angle(double growth_angle) {
			this.growth_angle = getGrowth_angle();
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
