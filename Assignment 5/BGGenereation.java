/*
* NUID: 001444756
* @author Harshitha Sangameshwarappa Gaddadhar
*/
package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @author HarshithaGS
 *BGGenereation class holds the method to growth a plant. First the BaseStem is grown and then the child stems are grown.
 *The rules that the user had selected  are applied in thw growth method. 
 *the rules are looked up fromt he BGRule class.
 */
public class BGGenereation{
	String Type_name;
	int Specimen_id;
	int base_location_x;
	int base_location_y;
	String ruleNum;
	


	int countt =0;
	BGStem BaseStem ;
	ArrayList<BGStem> StemList = new ArrayList<BGStem>();// holds child stems
	ArrayList<BGStem> MasterChildStem = new ArrayList<BGStem>();//Master Stem List which holds evry stem in the plant including the BAseStem
	ArrayList<Integer> x = new ArrayList<Integer>();//holds all the x coordinates to measure the width of the plant
	ArrayList<Integer> y = new ArrayList<Integer>();// holds all the y coordinates to measure the height of the plant

	ArrayList<Integer> angleeee = new ArrayList<Integer>();//contaims a list of angles that are required to grow each  child stem
	double Lengthhhh ;
	double n = MasterChildStem.size();

	//CONSTRUCTOR
	public BGGenereation(int id, String name , int base_location_x, int base_location_y ,String ruleVal) {
		this.Type_name =name;
		this.Specimen_id =id;
		this.base_location_x = base_location_x;
		this.base_location_y = base_location_y;
		this.ruleNum = ruleVal;

	}

	//Initial growth of BaseStem
	public void Plant_growth() {
			if( BaseStem == null) {//	if base stem is not yet grown then grow one		
				{BaseStem = new BGStem(50,90,base_location_x,base_location_y);
				MasterChildStem.add(BaseStem);
				x.add(BaseStem.getStart_location()[1][0]);
				y.add(BaseStem.getStart_location()[1][1]);
				}}
			else {growth_funct(BaseStem);//over the base stem grow the stems
			}
	}
	
	//Method to grow Childstems recursively
	public void growth_funct(BGStem st) {
		if(st.ChildStemList.isEmpty()) { 
			//First the rule the user has selected is checekd here and the required values are assigned
			if(ruleNum == "1") {
				BGRule1 rule = new BGRule1();
				angleeee = rule.lookup_angle(st.getGrowth_angle());
				Lengthhhh = rule.lookup_length(n);
			}else if (ruleNum == "2") {
				BGRule2 rule = new BGRule2();
				angleeee = rule.lookup_angle(st.getGrowth_angle());	
				Lengthhhh = rule.lookup_length(n);

			}
			for(Integer a : angleeee) {// Since angleeee has a set of 3 numbers  i.e 3 angles . Hence for each angle a stem is created
			BGStem Child_stem = new BGStem(Lengthhhh,a,st.getStart_location()[1][0],st.getStart_location()[1][1]);
			st.adding_method(Child_stem);
			MasterChildStem.add(st);
			x.add(Child_stem.getStart_location()[1][0]);
			y.add(Child_stem.getStart_location()[1][1]);
			}
		}

		else {
			for (BGStem child:st.ChildStemList){
				growth_funct(child);
			}
		}	
	}

	//method to return list of children
	public int no_of_childern() {
			if(BaseStem!=null && BaseStem.ChildStemList.isEmpty()) {
				countt=countt+1;
			}
			else {
				countt+= MasterChildStem.size();
				countt++;//To include base stem
			}
			return countt;
	}

	//method to print the plants with their stems on the console
	public void Plant_print(){
		if(BaseStem!=null) {
		System.out.println("BaseStem is :" + BaseStem.toString1());
			BaseStem.Display();
		
		}else
		if (StemList != null)
		{
			for (BGStem t : StemList) {
				System.out.println("Parent Stem: " + t.toString());
				t.Display();
			}
		}
		}
	
	//to calculate plant height
	public int Check_height() {
		int length = Collections.max(y) ;
		return length;			
	}

	//to calculate plant width
	public int Check_width() {
		int width = Collections.max(x)-Collections.min(x);
		return width;
	}

	//printing format
	public String toString() {
		return String.format("Plant> %1$12s %2$01d %3$01d %4$01d %5$01d", Type_name, Specimen_id,base_location_x, base_location_y);
	}

	//getters and setters
	public int getSpecimen_id() {
		return Specimen_id;
	}

	public void setSpecimen_id(int specimen_id) {
		Specimen_id = specimen_id;
	}

	public ArrayList<BGStem> getMasterChildStem() {
		return MasterChildStem;
	}

	public void setMasterChildStem(ArrayList<BGStem> masterChildStem) {
		MasterChildStem = masterChildStem;
	}
}



