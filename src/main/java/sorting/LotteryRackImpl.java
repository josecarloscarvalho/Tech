package sorting;

import common.exceptions.InvalidNumberException;

public class LotteryRackImpl implements LotteryRack {
	
	private final String INVALID_INPUT_MSG = "Invalid number input";
	
	private DrawningBoard board;
	
	private static int minBallNumber;
	private static int maxBallNumber;
	
	public LotteryRackImpl(int minNumber, int maxNumber) {
		this.board = new DrawningBoard();
		LotteryRackImpl.minBallNumber = minNumber;
		LotteryRackImpl.maxBallNumber = maxNumber;
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
		if (intValue < LotteryRackImpl.minBallNumber || intValue > LotteryRackImpl.maxBallNumber)
			return false;

		return true;
	}

}
