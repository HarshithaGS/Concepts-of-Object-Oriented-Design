/*Filename: Plant.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package assignment2b;

import java.util.ArrayList;

public class Plant {
	String Type_name;
	int Specimen_id;
	int checkbstem;
	int base_location_x;
	int base_location_y;

	ArrayList<Stem> StemList = new ArrayList<Stem>();// holds child stems

	Stem BaseStem ;

	public Plant(int id, String name, int chckbse, int base_location_x, int base_location_y) {
		this.Type_name =name;
		this.Specimen_id =id;
		this.checkbstem = chckbse;
		this.base_location_x = base_location_x;
		this.base_location_y = base_location_y;
	}

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
			}
			else {BaseStem.growth_funct(BaseStem);
			}
		}
		else {//no base stem
			if (this.StemList != null) {
				int angle_count =0;
				for (int i=0;i<2;i++) {
					angle_count=i;
					Stem S = new Stem(2,angle_count,0,0);
					StemList.add(S);
				}
			}
			else {
				for(Stem st :BaseStem.ChildStemList)	{
					st.growth_funct(st);
				}


			}
		}
	}	


	//method to return list of children
	public int no_of_childern() {
		int countt =0;
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
				for(Stem grandchild: child.ChildStemList) {
					countt+=grandchild.list_no_of_childern();
				}
			}
		}
		return countt;
	}


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

		}}
	public String toString() {
		return String.format("Plant> %1$12s %2$01d %3$01d %4$01d %5$01d", Type_name, Specimen_id,checkbstem,base_location_x, base_location_y);
	}

}
