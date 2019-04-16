/*Filename: FlowerPlant.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package edu.neu.csye6200.sim;

import java.util.ArrayList;

public class FLowerPlant extends Plant{

	private String color;
	private int petals;
	ArrayList<Flower> FlowerList ;

	RegisterIO r1 = new RegisterIO();
	
	//constructor
	public FLowerPlant(int id, String name, int chckbse, int base_location_x, int base_location_y,String color, int petals) {
		super(id, name, chckbse, base_location_x, base_location_y);
		FlowerList = new ArrayList<Flower>();// holds flowers for child stems
		this.color = color;
		this.petals =petals;
	}

	//check for base stem in the flower plant
	public boolean check_for_BaseStem() {
		if(this.checkbstem==0) {
			return true;
		}
		else	
			return false;
	}

	//growth method for a flower plant
	public void FlowerPlant_growth() {
		if (this.check_for_BaseStem()){ 
			if( BaseStem == null) {			
				BaseStem = new Stem(2,45,base_location_x,base_location_y);
			}
			else {growth_funct(BaseStem);

			}
		}
		else {//no base stem
			if (this.StemList != null) {
				int angle_count =0;
				for (int i=0;i<2;i++) {
					angle_count=i;
					Stem S = new Stem(2,angle_count,base_location_x,base_location_y);
					StemList.add(S);
					Flower f  = new Flower(this.color,this.petals );//this.start_loc);
					this.FlowerList.add(f);
				}
			}
			else {
				for(Stem st :BaseStem.ChildStemList)	{
					growth_funct(st);
				}
			}
		}
	}
	public void growth_funct(Stem st) {
		if(st.ChildStemList.isEmpty()) { 
			for(int i =  0; i<2; i++) {
				Stem Child_stem = new Stem(st.getLength(),st.getGrowth_angle(),st.getStart_location()[1][0],st.getStart_location()[1][1]);
				st.adding_method(Child_stem);
				//	MasterChildStem.add(st);
				Flower f  = new Flower(this.color,this.petals );//this.start_loc);
				this.FlowerList.add(f);

				//ChildStemList.add(ChildStems);}
			}
		}
		else {
			for (Stem child:st.ChildStemList){
				growth_funct(child);
			}
		}	
	}

	//to print flower plant
	public void Plant_print() {
		super.Plant_print();
		for(Flower f:FlowerList) {
			System.out.println("\nFlower - ");
			System.out.println("color =" +this.color);
			System.out.println("petals" + this.petals);
		}
	}
	
	//flower list needed for printing 
	public void copy_flower_to_file() {
		for (Flower f : FlowerList){
			r1.save_method2(f);
		}
	}

}
