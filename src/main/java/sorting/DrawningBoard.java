package sorting;

public class DrawningBoard{

	private int[] list;
	private int length = 0;
	
	public DrawningBoard() {
		list = new int[this.length];
	}
	
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
	
	public int[] getList(){
		return this.list;
	}
	
	
	@Override
	public String toString(){
		String stringResult = "Numbers:";
	    for (int element: this.list) {
	    	stringResult += " " + element;
	    }
	    return stringResult;
	}
	
}
