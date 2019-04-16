/*Filename: Plant.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package edu.neu.csye6200.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class RegisterIO<FlowerPlant> {
	private static final  String base = "C:/Users/HarshithaGS/Desktop/csye6200/Assign3/src/edu/neu/csye6200/assignment3/PlantFile.txt";
	public void save_method2(Flower f) {
		useByfferedFileWriter2(f);

	}
	public void save_method1(FlowerPlant fp) {
		useByfferedFileWriter1(fp);

	}
	public void save_method(Plant pt) {
		useByfferedFileWriter(pt);
	}
	//To print plant data with stems
	private  void useByfferedFileWriter(Plant pt) {
		Writer fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(base,true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(pt.toString());
			bufferedWriter.write(System.getProperty("line.separator"));
			for (Stem s: pt.MasterChildStem) {
				bufferedWriter.write(s.toString1());
				bufferedWriter.write(System.getProperty("line.separator"));	
			}
			bufferedWriter.newLine();
			fileWriter.flush();
			//fileWriter.close();
			bufferedWriter.close();

		} catch (IOException e) {
			System.out.println("ERROR:"+e.getLocalizedMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();}
	}
	// to print flowerplant data into fie
	private  void useByfferedFileWriter1(FlowerPlant fp) {
		Writer fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(base,true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(fp.toString());
			bufferedWriter.write(System.getProperty("line.separator"));
			bufferedWriter.newLine();
			fileWriter.flush();
			//fileWriter.close();
			bufferedWriter.close();

		} catch (IOException e) {
			System.out.println("ERROR:"+e.getLocalizedMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();}
	}
	// to print flowers from flower list into file
	private  void useByfferedFileWriter2(Flower f) {
		Writer fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(base,true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(f.toString2());
			bufferedWriter.write(System.getProperty("line.separator"));
			bufferedWriter.newLine();
			fileWriter.flush();
			//fileWriter.close();
			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();}
	}
	//to print data on console after reading from the text file
	public static void load() {
		try {

			File file = new File(base); 

			BufferedReader br = new BufferedReader(new FileReader(file)); 

			String st; 
			while ((st = br.readLine()) != null) 
				System.out.println(st); 
						
		} catch(IOException io) {
			io.printStackTrace();
		}
	}

}










