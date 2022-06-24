package assignment2;
/*

APSC 279 - Assignment 2
Nicholas Alderman, 16naa5, 20060982

Country class extends entity class and contains additional information about this type of entity

*/
public class Country extends Entity {
	
	
	private String capital;
	
	//super-constructor to set proper parameters in entity
	public Country(String nameIn, Date dateIn, String capital, double diff) {
		super(nameIn, dateIn, diff);
		this.capital = capital;
	}
	
	//copy-constructor to set proper entity parameter in entity class
	public Country(Country country) {
		super(country);
		this.capital = country.capital;
	}

	//customizes toString() to ensure proper closing message that includes 'capital'
	public String toString() {
		return (super.toString() + "\nCapital: " + this.capital);
	}

	//overrided method to ensure proper welcome message
	@Override
	public String entityType() {
		return "Country!";
	}

	//overrided method to create a copy of an entity
	@Override
	public Country clone() {
		return new Country(this);
	}
}
