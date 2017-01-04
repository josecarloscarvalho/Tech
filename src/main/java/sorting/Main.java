package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.exceptions.InvalidNumberException;

public class Main{
		
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
