/*Filename: Stem.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package edu.neu.csye6200.assignment3;
import java.util.ArrayList;

public class Stem {
	static private int idCounter = 0;
	int x;
	int y;

	private int[][] start_location = new int[2][2];
	private int id;
	private double length;
	private double growth_angle;//in radians

	ArrayList<Stem> ChildStemList = new ArrayList<Stem>();

	//COSTRUCTOR
	public Stem(double length,double growth_direction,int x,int y) {
		id =(idCounter++);//gives a unique id
		this.length=length; //length measured in centimeters
		this.growth_angle=(Math.toRadians(growth_direction)); // measured in radians
		this.start_location[0][0] =x;
		this.start_location[0][1] =y;
		// gives me the end location
		this.start_location[1][0] = x+ (int) (start_location[0][0] +length*Math.cos(growth_direction));//x new
		this.start_location[1][1] = y+(int) (start_location[0][1] +length*Math.cos(growth_direction));//y new
	}

	//growth function
	public void growth_funct(Stem st) {
		if(ChildStemList.isEmpty()) { 
			for(int i =  0; i<2; i++) {
				Stem Child_stem = new Stem(length,growth_angle,this.start_location[1][0],this.start_location[1][1]);
				this.adding_method(Child_stem);	               	
			}
		}
		else {
			for (Stem child:ChildStemList){
				child.growth_funct(child);
			}
		}	
	}


	// routine to print stems
	public void stem_print() {
		System.out.println("\nStem - ");
		System.out.println("length =" +this.length);
		System.out.println("growth_angle" + this.growth_angle);
		System.out.println("startx ="+this.start_location[0][0] );
		System.out.println("starty ="+this.start_location[0][1]);
		System.out.println("endx ="+this.start_location[1][0]);
		System.out.println("endy ="+this.start_location[1][1]);
		if(!ChildStemList.isEmpty()) { 
			for(Stem child:ChildStemList) 
				child.stem_print();}
	}


	public void adding_method(Stem ChildStems) {
		ChildStemList.add(ChildStems);
	}
	public void getting_method(int ChildStems) {
		ChildStemList.get(ChildStems);
	}
	public void removing_method(Stem ChildStems) {
		ChildStemList.remove(ChildStems);
	}


	public int list_no_of_childern() {//method to list number of children for each stem
		int count_children=ChildStemList.size();
		return count_children;
	}

	//method to determine if child list is empty
	public boolean check_child_list() {
		if(this.ChildStemList.isEmpty()) {
			System.out.println("yes child list is empty");
			return true;
		}
		else
			System.out.println("no child list is not empty");
		return false;
	}

	public String toString1() {
		return String.format("Stem> %1$01d %2$5.2f %3$5.2f %4$01d %5$01d" ,id, length,growth_angle,start_location[1][0],start_location[1][1]);
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
