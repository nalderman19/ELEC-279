package assignment2;
/*

APSC 279 - Assignment 2
Nicholas Alderman, 16naa5, 20060982

Person class extends entity class and contains additional information about this type of entity

*/
public class Person extends Entity {
	
	private String gender;
	
	//super-constructor to set proper parameters in entity
	public Person(String nameIn, Date dateIn, String gender, double diff) {
		super(nameIn, dateIn, diff);
		this.gender = gender;
	}
	
	//copy-constructor to set proper entity parameter in entity class
	public Person(Person person) {
		super(person);
		this.gender = person.gender;
	}

	//customizes toString() to ensure proper closing message that includes 'capital'
	public String toString() {
		return (super.toString() + "\nGender: " + this.gender);
	}

	//overrided method to ensure proper welcome message
	@Override
	public String entityType() {
		return "Person!";
	}

	//overrided method to create a copy of an entity
	@Override
	public Person clone() {
		return new Person(this);
	}
}
