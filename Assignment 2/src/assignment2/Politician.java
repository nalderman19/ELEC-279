package assignment2;
/*

APSC 279 - Assignment 2
Nicholas Alderman, 16naa5, 20060982

Politician class extends entity class and contains additional information about this type of entity

*/
public class Politician extends Person {

	private String party;
	
	//super-constructor to set proper parameters in entity
	public Politician(String nameIn, Date dateIn, String gender, String party, double diff) {
		super(nameIn, dateIn, gender, diff);
		this.party = party;
	}
	
	//copy-constructor to set proper entity parameter in entity class
	public Politician(Politician politician) {
		super(politician);
		this.party = politician.party;
	}

	//customizes toString() to ensure proper closing message that includes 'capital'
	public String toString() {
		return (super.toString() + "\nParty: " + this.party);

	}

	//overrided method to ensure proper welcome message
	@Override
	public String entityType() {
		return "Politician!";
	}

	//overrided method to create a copy of an entity
	@Override
	public Politician clone() {
		return new Politician(this);
	}
}
