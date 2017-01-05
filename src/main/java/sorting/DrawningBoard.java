package sorting;

/**
* <h1>Data structure</h1>
* This class implements an data structure that
* keep a ordered list of inserted numbers.
* <p>
* <b>Note:</b> Also implements a pretty print method
*
* @author  Jose Carvalho
*/

public class DrawningBoard{

	private int[] list;
	private int length = 0;
	
	public DrawningBoard() {
		list = new int[this.length];
	}
	
	/**
	* This is the main method which add the new number to current list.
	* @param new int number.
	* @return Nothing.
	*/
	public void add(int newElement){

		//search for correct position on array
		int position;
		for( position = 0; position < this.length; position ++){
			if(this.list[position] > newElement)
				break;
		}
		
		//reserve space to new element
		expandList();
		
		//shift elements
		for (int i = this.list.length-1; i > position; i--){
			this.list[i]=this.list[i-1];
		}
		
		//add new element on correct position
		this.list[position] = newElement;	
	}
	
	/**
	* Auxiliary method to allocate a new position in the current list.
	* @param Nothing.
	* @return Nothing.
	*/
	private void expandList(){	
		int newListSize = this.length + 1;
		int[] newList = new int[newListSize];
		
		for(int count = 0; count < this.length; count++){
			newList[count] = list[count];
		}
		newList[newListSize-1] = 0;
		
		this.list = newList;
		this.length++;
	}
	
	/**
	* This method return the current ordered list.
	* @param Nothing.
	* @return int[] return the current numbers list.
	*/
	public int[] getList(){
		return this.list;
	}
	
	/**
	* Method used to return a pretty representation of current list.
	* @param Nothing.
	* @return String return the printable numbers list.
	*/
	@Override
	public String toString(){
		String stringResult = "Numbers:";
	    for (int element: this.list) {
	    	stringResult += " " + element;
	    }
	    return stringResult;
	}
	
}
