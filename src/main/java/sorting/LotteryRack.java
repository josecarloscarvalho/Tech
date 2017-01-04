package sorting;

import common.exceptions.InvalidNumberException;

public interface LotteryRack {
	
	//add (sigle) new element
	public void add(String elementValue) throws InvalidNumberException;
	
	//print elements using toString implemeted method by elements object
	public String printPresentElements();
	
	//get current elements
	public int[] getElements();

}
