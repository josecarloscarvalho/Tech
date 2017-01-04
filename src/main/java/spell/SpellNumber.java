package spell;

import common.exceptions.InvalidNumberException;
import sorting.LotteryRackImpl;

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

	public String getWordRepresentation(String number) throws InvalidNumberException {
		// check for invalid number
		if (isValidNumber(number) == false)
			throw new InvalidNumberException(INVALID_INPUT_MSG);

		String wordRepresentation = this.translationProvider.translate(Integer.parseInt(number));
		return wordRepresentation;
	}

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