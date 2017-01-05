package spell;

import common.exceptions.InvalidNumberException
import spock.lang.Specification;

class SpellingSpec extends Specification {
		
	def  SpellNumber testObject
	
	def setup(){
		testObject = new SpellNumber(0, 100000000);
		
	}
	
	def "Spell number 0"() {
		given: "input 0 value"
			def zeroValue = "0"
			def expected = "zero"

		when: 
			def returnedValue = testObject.getWordRepresentation(zeroValue)
		
		then:
			returnedValue==expected
		
	}
	
	def "Spell value smaller then 20"() {
		given: "input 15 value"
			def value = "15"
			def expected = "fifteen"

		when:
			def returnedValue = testObject.getWordRepresentation(value)
		
		then:
			returnedValue==expected
		
	}
	
	def "Spell value bigger then 100"() {
		given: "input 125 value"
			def value = "125"
			def expected = "one hundred twenty-five"

		when:
			def returnedValue = testObject.getWordRepresentation(value)
		
		then:
			returnedValue==expected
		
	}
	
	def "Spell value on thousands"() {
		given: "input 768900 value"
			def value = "768900"
			def expected = "seven hundred sixty-eight thousand nine hundred"

		when:
			def returnedValue = testObject.getWordRepresentation(value)
		
		then:
			returnedValue==expected
		
	}
	
	def "Spell value on millions"() {
		given: "input 1049875 value"
			def value = "1049875"
			def expected = "one million forty-nine thousand eight hundred seventy-five"

		when:
			def returnedValue = testObject.getWordRepresentation(value)
		
		then:
			returnedValue==expected
		
	}
	
	
	def "Invalid number: smaller then minimum limit"(){
		given: "negative number"
			def value = "-1"
			when:
				testObject.getWordRepresentation(value)
			
			then:
				thrown(InvalidNumberException)
		
	}
	
	def "Invalid number: bigger then maximum limit"(){
		given: "number over 1 billion"
			def value = "1000000001"
			when:
				testObject.getWordRepresentation(value)
			then:
				thrown(InvalidNumberException)
		
	}
	
	
	def "Invalid number: not numeric"(){
		given: "Character sequence"
			def value = "xcvb"
			when:
				testObject.getWordRepresentation(value)
			then:
				thrown(InvalidNumberException)
		
	}
	

}
