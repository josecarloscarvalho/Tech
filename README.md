
## Lottery Sorting
The problem was modeled using object oriented programming principles as follows:
* We assume that each ball is inserted only once.
* A class (DrawningBoard) that represents the frame of balls drawn up to date, acting as data structure (since it was recommended not to use java.util structures or JDK sorting library).
* LotteryRackImpl is the implementation of the LotteryRack interface. It also implements a validation method on the received input. 
* Whenever a ball is added, if the number is not valid, an appropriate exception will be thrown (common.exceptions). If the ball number is valid, the number will be inserted in correct position. 
* The code hasn't too many comments because as a good practice, the code should only have the essential comments, and should comment on itself through the names of the methods, variables and simplicity.

## Spelling Out
The problem was modeled using object oriented programming principles as follows:
* The SpellNumber class act as a container who validate the input and uses a translator provider. 
* All the translation logic is inside Translator.
* As in the sorting problem, we use an exception that we return when the input is not valid, reusing the common.execptions.
* We could use a resources file to store number descriptions, but for that case was unnecessary, the translator could save these strings.
* The code hasn't too many comments because as a good practice, the code should only have the essential comments, and should comment on itself through the names of the methods, variables and simplicity.

### Instructions to execute
##### Applications
* Each application have a main class that allows the user to interact with it.
* Inside sort and spell packages, the Main.class can be executed directly and the user can insert the input.

##### Tests
* Tests specifications were written with spock.
* Can be executed as a junit script on eclipse or using gradle tool (command gradle test).
