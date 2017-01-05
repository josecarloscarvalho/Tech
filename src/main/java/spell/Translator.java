package spell;

/**
* <h1>Number spell translator</h1>
* This class implements translator engine that
* translates the numeric representation of a given number
* in his word representation
* <p>
*
* @author  Jose Carvalho
*/
public class Translator {
	
	private static final String separatorMinusToken = "-";
	
	private static final String hundredDesc = " hundred ";
	private static final String thousandDesc = " thousand ";
	private static final String millionDesc = " million ";
	private static final String billionDesc = " billion ";	

	
	private static final String[] tenDesc = {
			    "",
			    " ten",
			    " twenty",
			    " thirty",
			    " forty",
			    " fifty",
			    " sixty",
			    " seventy",
			    " eighty",
			    " ninety"
			  };

	 private static final String[] unitDesc = {
			    "zero",
			    " one",
			    " two",
			    " three",
			    " four",
			    " five",
			    " six",
			    " seven",
			    " eight",
			    " nine",
			    " ten",
			    " eleven",
			    " twelve",
			    " thirteen",
			    " fourteen",
			    " fifteen",
			    " sixteen",
			    " seventeen",
			    " eighteen",
			    " nineteen"
			  };
	 
	public Translator() {
		super();
	}
	
	/**
	* This is the main method which spell the number using 
	* their decimal length representation.
	* @param new int number.
	* @return String word representation of number.
	*/
	public String translate(int num) {
		String majorUnit = checkMajorUnit(num);
		
		if(majorUnit.equals("units")){
			return unitDesc[num].trim();
		}
		if(majorUnit.equals("tens")){ 
			return tenDesc[num/10].trim() + Translator.separatorMinusToken + checkRemain(num, 10).trim();
		}
		if(majorUnit.equals("hundreds")){ 
			return unitDesc[num/100].trim() + Translator.hundredDesc + checkRemain(num, 100).trim();
		}
		if(majorUnit.equals("thousands")){ 
			return translate(num / 1000) + Translator.thousandDesc + checkRemain(num, 1000).trim();
		}
		if(majorUnit.equals("millions")){ 
			return translate(num / 1000000) + Translator.millionDesc + checkRemain(num, 1000000).trim();
		}
		return translate(num / 1000000000) + Translator.billionDesc + checkRemain(num, 1000000000).trim();
	}
	
	/**
	* Method to check the remaining decimal units
	* @param int number.
	* @param int decimal units.
	* @return String word representation of remaining units.
	*/
	private String checkRemain(int num, int units){
		String remain = "";
		if(num % units > 0)
			remain = translate(num % units);
		return remain;
	}

	
	private String checkMajorUnit(long number){
		String major = "";	
		
	    if(number < 20)
	    	return "units";
	    if(number < 100)
	    	return "tens";
	    if(number < 1000)
	    	return "hundreds";
	    if(number < 1000000)
	    	return "thousands";
	    if(number < 1000000000)
	    	return "millions";
	    if(number < 10000000000L )
	    	return "billions";  
	    return major;
	    }
	}


