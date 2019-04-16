/*Filename: PlantTest.java
* NUID: (001444756)
* @author (Harshitha Sangameshwarappa Gaddadhar)
* */
package oop_java_assignmnet_2a;

public class Plant {

		public static final int AVERAGE_INCREASE_IN_HEIGHT = 20; //measurement in centimeter
		public static  final int GROWTH_RATE =2;
		public static final double AVERAGE_INCREASE_IN_RING_WIDTH =0.3;// measurement in centimeter

		String Type_name;
		int Specimen_id;
		double Plant_age; // age measured in number of  months
		double Plant_length; //length measured in centimeters
		double ring_width; // measured in centimeters
		double Ring_width; // measured in centimeters


		double current_age;// measured in number of months
		double current_length;// measured in centimeters

		public Plant() {
			Type_name = "Rose";
			Specimen_id = 1;
			ring_width = 0.1; 
			current_age = 5;
			current_length = 10 ;
		}

		public Plant(  String Type_name,int Specimen_id, double ring_width, double current_age, double current_length ) {
			this.Type_name = Type_name;
			this.Specimen_id =Specimen_id;
			this.ring_width =  ring_width;
			this.current_age = current_age;
			this.current_length = current_length;
		}
		public Plant (double Plant_age , double Plant_length) {
			this.Plant_age = 0 ;
			this.Plant_length = 0;
		}


		public void Plant_Growth (double ring_width) {	//method to increase the length and age of the planti.e increase growth of the plant if the average increase in ring width is kept same for all the plants
			this.Ring_width =	(this.ring_width + AVERAGE_INCREASE_IN_RING_WIDTH);// assuming the ring width increases at a constant rate
			if (this.Ring_width > 0.5) {
				this.Plant_age=  ((Ring_width *GROWTH_RATE)+ current_age);	
				this.Plant_length = (this.Plant_age *GROWTH_RATE + AVERAGE_INCREASE_IN_HEIGHT )+ current_length ;}
			else {// which means plant hasn't grown due to various reasons
				this.Plant_age =current_age;
				this.Plant_length = current_length;
			}
		}

		public String Plant_data_printing() {
			if (this.Ring_width > 0.5) {
				String st = java.lang.String.format("Plant %1$8s\t\t %2$01d\t %3$5.2f\t\t %4$5.2f\t\t %5$5.2f" , Type_name,Specimen_id,Plant_age,Plant_length, Ring_width);
				return st;}
			else {
				String st = java.lang.String.format("Plant %1$8s\t\t %2$01d\t %3$5.2f\t\t  %4$5.2f\t\t %5$5.2f" , Type_name,Specimen_id,current_age,current_length, Ring_width);
				return st;}
		}
	}


