package sorting;

import spock.lang.Specification;

class RackSpecTest extends Specification {
		
	def  LotteryRack rackMock
	
	def setup(){
		rackMock = new LotteryRackImpl(0, 59);
		
	}
	
	def "Initial drawing board must be empty"() {
		given: "There is no balls in the board"
		expect:
			rackMock.getElements().size()==0;
	}
	
	def "Add a new ball"() {
		given: "New ball value is 10 (inside range limit)"
			def firstBall = "10"

		when: 
			rackMock.add(firstBall)
		
		then:
			rackMock.getElements().size()==1;
			rackMock.getElements() == [10]
		
	}
	
	def "Add a smaller ball "() {
		given: "New ball value is 1"
			def currentBall = "5"
			def smallertBall = "1"

		when:
			rackMock.add(currentBall)
			rackMock.add(smallertBall)
		
		then:
			rackMock.getElements().size()==2;
			rackMock.getElements() == [1,5]
		
	}
	
	def "Add a larger ball"() {
		given: "New ball value is 50"
			def currentBall = "5"
			def smallertBall = "1"
			def largerBall = "50"

		when:
			rackMock.add(currentBall)
			rackMock.add(smallertBall)
			rackMock.add(largerBall)
			
		
		then:
			rackMock.getElements().size()==3;
			rackMock.getElements() == [1,5,50]
	}
	
	def "Invalid ball number: smaller then minimum limit"(){
		given: "Ball with negative number"
			def negativeNumBall = "-1"
			when:
				rackMock.add(negativeNumBall)
			
			then:
				def exception = thrown(InvalidBallNumberException)
		
	}
	
	def "Invalid ball number: bigger then maximum limit"(){
		given: "Ball with negative number or bigger than limit"
			def overMaxLimitBall = "100"
			when:
				rackMock.add(overMaxLimitBall)
			then:
				def exception = thrown(InvalidBallNumberException)
		
	}

}
