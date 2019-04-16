/*Filename: Flower.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package edu.neu.csye6200.assignment3;

public class Flower {
	int idcounter =0;
	int id;
	private String color;
	private int petals;
	
	public Flower(String color, int petals) {
		id =idcounter++;
		this.color = color;
		this.petals = petals;
		
	}
	
//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcolor() {
		return color;
	}
	
	public void setcolor(String color) {
		this.color = color;
	}
	
	public int getpetals() {
		return petals;
	}

	public void setPetals(int petals) {
		this.petals = petals;
	}

	public String toString2() {
		return String.format("Flower>  %1$12s %2$01d " , color,  petals );
	}
	

}
