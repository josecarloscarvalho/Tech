package sorting;

import common.exceptions.InvalidNumberException;

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
	
	@Override
	public void add(String numberValue) throws InvalidNumberException{
		//need validate the value
		if(elementIsValid(numberValue) == false)
			throw new InvalidNumberException(INVALID_INPUT_MSG);
		
		int number = Integer.parseInt(numberValue);
		//if valid, add new ball to present list
		this.board.add(number);
	}
	
	@Override
	public int[] getElements(){
		return this.board.getList();
	}
	
	@Override
	public String printPresentElements(){
		return this.board.toString();
	}
	
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
