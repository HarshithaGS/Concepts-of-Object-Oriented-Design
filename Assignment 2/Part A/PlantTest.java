/*Filename: PlantTest.java
* NUID: (001444756)
* @author (Harshitha Sangameshwarappa Gaddadhar)
* */
package oop_java_assignmnet_2a;

import oop_java_assignmnet_2a.Plant;

public class PlantTest {

	public static void main(String[] args) {
		Plant p1 = new Plant(); // Make a Plant instance
		p1.Plant_Growth(0.1);
		System.out.println("Plant p1 's old lenth is :"+ p1.current_length);
		System.out.println("Plant p1 's new lenth is :"+ p1.Plant_length);
		System.out.println("Plant p1 's old age is :"+ p1.current_age);
		System.out.println("Plant p1 's new age is :"+ p1.Plant_age);

		Plant p2 = new Plant("Tulip" ,2,0.9,3,12);
		p2.Plant_Growth(0.9);
		System.out.println("Plant p2 's old lenth is :"+ p2.current_length);
		System.out.println("Plant p2 's new lenth is :"+ p2.Plant_length);
		System.out.println("Plant p2 's old age is :"+ p2.current_age);
		System.out.println("Plant p2 's  new age is :"+ p2.Plant_age);

		Plant p3 = new Plant("Lily" ,3,0.2,4,14);
		p3.Plant_Growth(0.2);
		System.out.println("Plant p3 's old lenth is :"+ p3.current_length);
		System.out.println("Plant p3 's new lenth is :"+ p3.Plant_length);
		System.out.println("Plant p3 's old age is :"+ p3.current_age);
		System.out.println("Plant p3 's new age is :"+ p3.Plant_age);

		Plant p4 = new Plant("Dahlia",4,1.1,8,20);
		p4.Plant_Growth(1.1);
		System.out.println("Plant p3 's old lenth is :"+ p3.current_length);
		System.out.println("Plant p3 's new lenth is :"+ p3.Plant_length);
		System.out.println("Plant p3 's old age is :"+ p3.current_age);
		System.out.println("Plant p3 's new age is :"+ p3.Plant_age);

		Plant p5 = new Plant("Daisy" ,5,0.4,2,30);
		p3.Plant_Growth(0.4);
		System.out.println("Plant p3 's old lenth is :"+ p3.current_length);
		System.out.println("Plant p3 's new lenth is :"+ p3.Plant_length);
		System.out.println("Plant p3 's old age is :"+ p3.current_age);
		System.out.println("Plant p3 's new age is :"+ p3.Plant_age);

		System.out.println("Plant   Type_name   Specimen_id   Plant_age   Plant_length   Ring_width(after growth)");
		System.out.println(p1.Plant_data_printing());
		System.out.println(p2.Plant_data_printing());
		System.out.println(p3.Plant_data_printing());
		System.out.println(p4.Plant_data_printing());
		System.out.println(p5.Plant_data_printing());

	}

}
