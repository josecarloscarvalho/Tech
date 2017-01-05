package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.exceptions.InvalidNumberException;

/**
* This Main program implements an application that receive 
* an input numbers on console and inserts him on
* a ordered list of current numbers. For each inserted number
* the list will be printed.
* <p>
*
* @author Jose Carvalho
*/
public class Main{
	
   /**
   * This is the main method which use a BufferedReader to
   * receive an input number from the console and call the 
   * add method of LotteryRack. Print the current list 
   * at the end of input.
   * @param args Unused.
   * @return Nothing.
   */
	public static void main( String[] args) {

		BufferedReader buffer = null;
		LotteryRackImpl rack = new LotteryRackImpl(0, 59);

		try {
			buffer = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("Insert new ball number (Or q to quit): ");
				String lineValue = buffer.readLine();

				// check for quit order
				if (lineValue.contains("q")) {
					System.out.println("Finish.");
					System.exit(0);
				}
				try {
					// add new ball
					rack.add(lineValue);
					System.out.println(rack.printPresentElements());
				} catch (InvalidNumberException e) {
					System.out.println("Please enter a valid number between 0-59.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
