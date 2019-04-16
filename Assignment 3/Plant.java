/*Filename: Plant.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package edu.neu.csye6200.assignment3;
import java.util.ArrayList;
import java.util.Collections;

public class Plant {
	String Type_name;
	int Specimen_id;
	int checkbstem;
	int base_location_x;
	int base_location_y;

	int countt =0;
	ArrayList<Stem> StemList = new ArrayList<Stem>();// holds child stems
	Stem BaseStem ;
	ArrayList<Integer> x = new ArrayList<Integer>();
	ArrayList<Integer> y = new ArrayList<Integer>();
	ArrayList<Stem> MasterChildStem = new ArrayList<Stem>();


	//CONSTRUCTOR
	public Plant(int id, String name, int chckbse, int base_location_x, int base_location_y) {
		this.Type_name =name;
		this.Specimen_id =id;
		this.checkbstem = chckbse;
		this.base_location_x = base_location_x;
		this.base_location_y = base_location_y;
	}

	//CHECKING FOR A BASE STEM IN A  PLANT
	public boolean check_for_BaseStem() {
		if(this.checkbstem==0) {
			return true;
		}
		else	
			return false;
	}

	//this is method to pass parameters from stem to Plant
	public void Plant_growth() {
		if (this.check_for_BaseStem()){ 
			if( BaseStem == null) {			
				BaseStem = new Stem(2,45,base_location_x,base_location_y);
				x.add(BaseStem.getStart_location()[1][0]);
				y.add(BaseStem.getStart_location()[1][1]);
			}
			else {growth_funct(BaseStem);
			}
		}
		else {
			if (this.StemList.isEmpty()) {
				int angle_count =0;
				for (int i=0;i<2;i++) {
					angle_count=i;
					Stem S = new Stem(2,angle_count,base_location_x,base_location_y);
					StemList.add(S);
					MasterChildStem.add(S);
					x.add(S.getStart_location()[1][0]);
					y.add(S.getStart_location()[1][1]);
				}
			}
			else if (!this.StemList.isEmpty()){
				for(Stem s1:StemList) {
					//s1.growth_funct(s1);
					growth_funct(s1);
				}
			}
			else {
				for(Stem st :BaseStem.ChildStemList)	{
					growth_funct(st);

					x.add(st.getStart_location()[1][0]);
					y.add(st.getStart_location()[1][1]);           	
				}
			}
		}
	}
	public void growth_funct(Stem st) {
		if(st.ChildStemList.isEmpty()) { 
			for(int i =  0; i<2; i++) {
				Stem Child_stem = new Stem(st.getLength(),st.getGrowth_angle(),st.getStart_location()[1][0],st.getStart_location()[1][1]);
				st.adding_method(Child_stem);
				MasterChildStem.add(st);
			}
		}
		else {
			for (Stem child:st.ChildStemList){
				growth_funct(child);
			}
		}	
	}

	//method to return list of children
	public int no_of_childern() {
		if(this.check_for_BaseStem()) {
			if(BaseStem!=null && BaseStem.ChildStemList.isEmpty()) {
				countt=countt+1;
			}
			else {
				countt+= BaseStem.list_no_of_childern();
				countt++;//To include base stem
			}
		}
		else {

			for(Stem child:StemList) {
				countt++;
				countt+=child.list_no_of_childern();
			}
		}
		return countt;
	}

	//to print plant with stems
	public void Plant_print() {
		System.out.println("Plant - " + this.Type_name);
		if (!this.StemList.isEmpty()) {
			for (Stem s: StemList) {
				s.stem_print();
			}
		}
		else if(BaseStem !=null) {
			(BaseStem).stem_print();
			for(Stem s : BaseStem.ChildStemList) {
				s.stem_print();
			}
		}
	}

	//printing format
	public String toString() {
		return String.format("Plant> %1$12s %2$01d %3$01d %4$01d %5$01d", Type_name, Specimen_id,checkbstem,base_location_x, base_location_y);
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


}






