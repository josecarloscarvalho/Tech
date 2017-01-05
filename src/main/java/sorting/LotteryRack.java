package sorting;

import common.exceptions.InvalidNumberException;

/**
* <h1>Lottery rack interface</h1>
* This class defines a interface to be implemented 
* by classes that manages the inserted numbers
* <p>
*
* @author  Jose Carvalho
*/

public interface LotteryRack {
	
	//add (sigle) new element
	public void add(String elementValue) throws InvalidNumberException;
	
	//print elements using toString implemeted method by elements object
	public String printPresentElements();
	
	//get current elements
	public int[] getElements();

}
