/**
 * Filename: asignment_1.java
 * NUID: 001444756
 * @author (Harshitha Sangameshwarappa Gaddadhar)
 */


package oop_java_assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class assignment_1 {

	public static void main(String[] args) throws IOException {
		String[][] Student_Data = { { "Pragna", "0", "1", "2" }, { "Harshitha", "2", "3", "3" },
				{ "Neha", "3", "3", "9" }, { "Bhavya", "4", "1", "5" }, { "John", "8", "5", "6" },
				{ "Smith", "9", "9", "9" }, { "Anurag", "6", "7", "8" }, { "Kelly", "1", "6", "4" },
				{ "Stacy", "9", "3", "10" }, { "Kavya", "5", "4", "1" }, { "Ankit", "3", "8", "4" },
				{ "Natalie", "6", "1", "7" }, { "Nancy", "7", "7", "7" }, { "Pankaj", "9", "5", "1" },
				{ "Cacy", "2", "9", "8" }, { "Purna", "7", "9", "3" }, { "Sherlock", "9", "2", "5" },
				{ "Kevin", "3", "5", "7" }, { "Daniel", "4", "5", "2" }, { "Piyush", "1", "6", "4" },
				{ "Karl", "7", "2", "7" }, { "Max", "3", "7", "9" }, { "Austin", "2", "6", "1" },
				{ "Rahul", "6", "2", "5" } };

		int count_for_same_grad_e = 0; // integer variable to keep a count of all the elementary level students
		int count_for_same_grad_m = 0; // integer variable to keep a count of all the middle level students

		ArrayList<int[]> coords = new ArrayList<int[]>(); // creation of a new arraylist for storing the coordinates
		int[][] pattern = new int[10][10]; // initialize a grid area of size 10 by 10

		char inChar = ' ';
		char inSubChar = ' ';

		ArrayList<Character> store_user_input = new ArrayList<Character>(); // creation of a new arraylist to stoe user inputs

		System.out.println("Enter your choice among the following :\n 1) Enter 1  to know the total number of students in elementary and middle .\n 2) Enter 2 to know pick up/drop off location points of the students.\n 3) Enter 3 to list the history of last 3 commands used .\n 4) Enter 4 to quit the program. \n Select one of the options and then press <enter>");
		do {
			inChar = (char) System.in.read();
			if ( inChar != ('\n'&'\r'))
			{
				store_user_input.add(inChar);
			}
			switch (inChar) {
			case '1':
				for (int i = 0; i < 24; i++) {
					if (Integer.parseInt(Student_Data[i][3]) <= 6) {
						count_for_same_grad_e++;
					}
					if (Integer.parseInt(Student_Data[i][3]) > 6) {
						count_for_same_grad_m++;
					}
				}
				System.out.println("The total number of people in elementray levele is :" + count_for_same_grad_e);
				System.out.println("The total number of people in middle levele is :" + count_for_same_grad_m);
				break;

			case '2':
				System.out.println(
						"Enter your choice among the following : 1) Enter e to print the map of locations of all elementary level students. 2) Enter m  to print the map of locations of all middle level students . 3) Enter a to print the map of all the students.Select one of the options and then press <enter>");
				do {
					inSubChar = (char) System.in.read();
					if ( inSubChar != ('\n'&'\r'))
					{
						store_user_input.add(inSubChar);
					}
					switch (inSubChar) {

					case 'e':// case to print the location of elementary  level students
						for (String[] student : Student_Data) {
							if (Integer.parseInt(student[3]) <= 6) {
								int a = Integer.parseInt(student[1]);
								int b = Integer.parseInt(student[2]);
								coords.add(new int[] { a, b });
							}
						}
						for (int[] coord : coords) {
							pattern[coord[1]][coord[0]] = 1;
						}
						for (int[] row : pattern) {
							System.out.println(Arrays.toString(row));
						}
						break;

					case 'm':// case to print the location of middle level students
						for (String[] student : Student_Data) {
							if (Integer.parseInt(student[3]) > 6) {
								int a = Integer.parseInt(student[1]);
								int b = Integer.parseInt(student[2]);
								coords.add(new int[] { a, b });
							}
						}
						for (int[] coord : coords) {
							pattern[coord[1]][coord[0]] = 1;
						}
						for (int[] row : pattern) {
							System.out.println(Arrays.toString(row));
						}
						break;

					case 'a':// case to print the location of all level students
						for (String[] student : Student_Data) {
							int a = Integer.parseInt(student[1]);
							int b = Integer.parseInt(student[2]);
							coords.add(new int[] { a, b });
						}
						for (int[] coord : coords) {
							pattern[coord[1]][coord[0]] = 1;
						}
						for (int[] row : pattern) {
							System.out.println(Arrays.toString(row));
						}
						break;

					case '\n':// OSX
					case '\r': // Win
						// Do nothing
						break;

					default:System.out.println("Invalid Selection");
					break;
					}
				} while (inSubChar != 'q');// Exit on Quit(i.e 'q')
				System.out.println("Quit");
				break;

			case '3': // to print last 3 commands 
				for ( char usrin : store_user_input) {
					System.out.println(usrin);
				}
				break;

			case '4': //to exit the program
				System.out.println("Exitted");
				System.exit(0);
				break;
			case '\n':// OSX
			case '\r': // Win
				//Do nothing
				break;
			default:
				System.out.println("Invalid Selection");
				break;					
			}
		}while (inChar != 'q');// Exit on Quit(i.e 'q')
		System.out.println("Quit");

	}
}
