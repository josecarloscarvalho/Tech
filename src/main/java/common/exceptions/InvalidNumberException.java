package common.exceptions;

/**
* <h1>Invalid input exception</h1>
* Common custom exception. Throwed for invalid given input
* <p>
*
* @author  Jose Carvalho
*/

public class InvalidNumberException extends Exception {
	

    public InvalidNumberException(String message)
    {
       super(message);
    }
}
