package spell;

import common.exceptions.InvalidNumberException;
import sorting.DrawningBoard;
import sorting.LotteryRackImpl;

/**
* <h1>Implementation of Spell Number</h1>
* Implements a class to use the translator engine
* and spell the input number. Before spell the number, 
* validates the number.
* <p>
*
* @author  Jose Carvalho
*/
public class SpellNumber {

	private final static String INVALID_INPUT_MSG = "Invalid number input";

	private Translator translationProvider;

	private final int minNumberLimit;
	private final int maxNumberLimit;

	public SpellNumber(int min, int max) {
		this.minNumberLimit = min;
		this.maxNumberLimit = max;
		this.translationProvider = new Translator();
	}
	
	/**
	* This is the main method which:
	* - valid the new number.
	* - call the engine translator provider to spell the number
	* @param String new number.
    * @return String words representation of number.
    * @exception InvalidNumberException on invalid input.
    * @see Translator
    */
	public String getWordRepresentation(String number) throws InvalidNumberException {
		// check for invalid number
		if (isValidNumber(number) == false)
			throw new InvalidNumberException(INVALID_INPUT_MSG);

		String wordRepresentation = this.translationProvider.translate(Integer.parseInt(number));
		return wordRepresentation;
	}
	
	/**
	* This method implement the number validation logic
	* The input String must be numeric and respect limits range
	* @param String new input number.
    * @return boolean with true if number is valid, otherwise false.
    */
	private boolean isValidNumber(String input) {
		int intValue;
		if (input.isEmpty())
			return false;
		try {
			intValue = Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return false;
		}
		if (intValue < this.minNumberLimit || intValue > this.maxNumberLimit)
			return false;
		return true;
	}
}