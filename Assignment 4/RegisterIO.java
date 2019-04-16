/*Filename: Plant.java
 * NUID: 001444756
 * @author Harshitha Sangameshwarappa Gaddadhar
 */
package edu.neu.csye6200.sim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class RegisterIO<FlowerPlant> {
	
	public static Logger log = Logger.getLogger(PlantRoster.class.getName());
	
	private static final  String base = "C:/Users/HarshithaGS/Desktop/csye6200/Assign3/src/edu/neu/csye6200/assignment3/PlantFile.txt";
	
	//file handler for logs
	public RegisterIO() {
		java.util.logging.Handler handler = null;
		try {
			handler = new FileHandler(
					"C:\\Users\\HarshithaGS\\Desktop\\csye6200\\oop_assignment _4\\src\\edu\\neu\\csye6200\\sim\\server.log");
			} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		log.addHandler(handler);
	}
	
	
	
	//to write flowers into the file
	public void save_method2(Flower f) {
		useByfferedFileWriter2(f);
		log.warning("saving flower of flwer plant to the text file");
	}
	//to write the flower plant in to the file
	public void save_method1(FlowerPlant fp) {
		useByfferedFileWriter1(fp);		
		log.warning("saving flowerPlant to the text file");

	}
	//to write the plants along with their stems into the file 
	public void save_method(Plant pt) {
		useByfferedFileWriter(pt);
		log.warning("saving Plants to the text file");

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
				log.warning("printing plant data to the text file");

			}
			bufferedWriter.newLine();
			fileWriter.flush();
			//fileWriter.close();
			bufferedWriter.close();

		} catch (IOException e) {
			System.out.println("ERROR:"+e.getLocalizedMessage());
			e.printStackTrace();
			log.severe("IO exception caught");
		}
		catch (Exception e) {
			e.printStackTrace();
			log.severe("exception caught");
}
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
			log.warning("printing flowerplant data to the text file");

			fileWriter.flush();
			//fileWriter.close();
			bufferedWriter.close();

		} catch (IOException e) {
			System.out.println("ERROR:"+e.getLocalizedMessage());
			e.printStackTrace();
			log.severe("IO exception caught");
		}
		catch (Exception e) {
			e.printStackTrace();
			log.severe("exception caught");
		}
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
			System.out.println("ERROR:"+e.getLocalizedMessage());
			e.printStackTrace();
			log.severe("IO exception caught");
		}
		catch (Exception e) {
			e.printStackTrace();
			log.severe("exception caught");
		}
	}
	
	//to print data on console after reading from the text file
	public static void load() {
		try {
			File file = new File(base); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
			while ((st = br.readLine()) != null) 
				System.out.println(st); 
			log.warning("loading data from text file to console");
		} catch (IOException e) {
			System.out.println("ERROR:"+e.getLocalizedMessage());
			e.printStackTrace();
			log.severe("IO exception caught");
		}
		catch (Exception e) {
			e.printStackTrace();
			log.severe("exception caught");}
	}

}










