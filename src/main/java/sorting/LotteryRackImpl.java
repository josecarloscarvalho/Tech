package sorting;

import common.exceptions.InvalidNumberException;

/**
* <h1>Implementation of Lottery rack</h1>
* Implements a class to manage the inserted numbers.
* Also implements the number validation
* <p>
*
* @author  Jose Carvalho
*/
public class LotteryRackImpl implements LotteryRack {
	
	private final static String INVALID_INPUT_MSG = "Invalid number input";
	
	private DrawningBoard board;
	
	private final int minBallNumber;
	private final int maxBallNumber;
	
	public LotteryRackImpl(int minNumber, int maxNumber) {
		this.board = new DrawningBoard();
		this.minBallNumber = minNumber;
		this.maxBallNumber = maxNumber;
	}
	
	/**
	* This is the main method which:
	* - valid the new number.
	* - add the number to current data structure DrawningBoard
	* @param String new number.
    * @return Nothing.
    * @exception InvalidNumberException on invalid input.
    * @see DrawningBoard
    */
	@Override
	public void add(String numberValue) throws InvalidNumberException{
		//need validate the value
		if(elementIsValid(numberValue) == false)
			throw new InvalidNumberException(INVALID_INPUT_MSG);
		
		int number = Integer.parseInt(numberValue);
		//if valid, add new ball to present list
		this.board.add(number);
	}
	
	/**
	* Method to return current list of DrawningBoard
	* @param Nothing.
    * @return int[] current ordered number list.
    * @see DrawningBoard
    */
	@Override
	public int[] getElements(){
		return this.board.getList();
	}
	
	/**
	* Method to return printable list of numbers
	* @param Nothing.
    * @return String formated number list.
    */
	@Override
	public String printPresentElements(){
		return this.board.toString();
	}
	
	/**
	* This method implement the number validation logic
	* The input String must be numeric and respect limits range
	* @param String new input number.
    * @return boolean with true if number is valid, otherwise false.
    */
	private boolean elementIsValid(String input) {
		int intValue;
		if (input.isEmpty())
			return false;
		try {
			intValue = Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return false;
		}
		if (intValue < this.minBallNumber || intValue > this.maxBallNumber)
			return false;

		return true;
	}

}
