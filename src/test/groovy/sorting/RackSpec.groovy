package sorting;

import common.exceptions.InvalidNumberException
import spock.lang.Specification;

class RackSpec extends Specification {
		
	def  LotteryRack testObject
	
	def setup(){
		testObject = new LotteryRackImpl(0, 59);
		
	}
	
	def "Initial drawing board must be empty"() {
		given: "There is no balls in the board"
		expect:
			testObject.getElements()==[];
	}
	
	def "Add a new ball"() {
		given: "New ball value is 10 (inside range limit)"
			def firstBall = "10"

		when: 
			testObject.add(firstBall)
		
		then:
			testObject.getElements() == [10]
		
	}
	
	def "Add a smaller ball "() {
		given: "New ball value is 1"
			def currentBall = "5"
			def smallertBall = "1"

		when:
			testObject.add(currentBall)
			testObject.add(smallertBall)
		
		then:
			testObject.getElements() == [1,5]
		
	}
	
	def "Add a larger ball"() {
		given: "New ball value is 50"
			def currentBall = "5"
			def smallertBall = "1"
			def largerBall = "50"

		when:
			testObject.add(currentBall)
			testObject.add(smallertBall)
			testObject.add(largerBall)
			
		
		then:
			testObject.getElements() == [1,5,50]
	}
	
	def "Invalid ball number: smaller then minimum limit"(){
		given: "Ball with negative number"
			def negativeNumBall = "-1"
			when:
				testObject.add(negativeNumBall)
			
			then:
				thrown(InvalidNumberException)
		
	}
	
	def "Invalid ball number: bigger then maximum limit"(){
		given: "Ball with negative number or bigger than limit"
			def overMaxLimitBall = "100"
			when:
				testObject.add(overMaxLimitBall)
			then:
				thrown(InvalidNumberException)
		
	}
	
	def "Invalid ball number: not numeric"(){
		given: "Character sequence"
			def characterInsteadNumberBall = "abc"
			when:
				testObject.add(characterInsteadNumberBall)
			then:
				thrown(InvalidNumberException)
		
	}
	
	def "Invalid ball number: empty"(){
		given: "Empty string"
			def emptyNumberBall = ""
			when:
				testObject.add(emptyNumberBall)
			then:
				thrown(InvalidNumberException)
		
	}
	
	def "Print current drawed balls"(){
		given: "List of drawed balls"
			def ball1 = "50"
			def ball2 = "0"
			def balln = "4"
			def expectedPrint = "Numbers: 0 4 50"
			def expectedList = [0,4,50]
			when:
				testObject.add(ball1)
				testObject.add(ball2)
				testObject.add(balln)
			then:
				testObject.printPresentElements()==expectedPrint
				testObject.getElements()==expectedList
	}

}
