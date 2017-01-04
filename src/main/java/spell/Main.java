package spell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import common.exceptions.InvalidNumberException;

public class Main{
		
	public static void main( String[] args) {

		BufferedReader buffer = null;
		SpellNumber spellProvider = new SpellNumber(0, 1000000000);

		try {
			buffer = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("Insert new number (Or q to quit): ");
				String lineValue = buffer.readLine();

				// check for quit order
				if (lineValue.contains("q")) {
					System.out.println("Finish.");
					System.exit(0);
				}
				try {
					// spell new number
					String numberToWords = spellProvider.getWordRepresentation(lineValue);
					System.out.println(lineValue+": "+ numberToWords);
				} catch (InvalidNumberException e) {
					System.out.println("Please enter a valid number between 0-1000000000.");
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
