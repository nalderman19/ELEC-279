package assignment2;
/*

APSC 279 - Assignment 2
Nicholas Alderman, 16naa5, 20060982

Entity abstract class is used to define entities using information from guessMaster class

*/

public abstract class Entity {
	
	private String name;
	private Date born;
	private double difficulty;

	public abstract String entityType();
	public abstract Entity clone();
	
	
	//method to get the number of awarded tickets using the difficulty double
	public int gATN() {
		double diffInt = this.difficulty*100;
		int tVal = (int) diffInt;
		return tVal;	
	}
	
	//copy constructor method
	public Entity(Entity entity) {
		this.name = entity.name;
		this.born = new Date(entity.born); //no privacy leak
		this.difficulty = entity.difficulty;
	}
	
	//constructor method that defines entities with new difficulty parameter
	public Entity(String name, Date birthDate, double difficulty) {
		this.name = name;
		this.born = new Date(birthDate); //no privacy leak
		this.difficulty = difficulty;
	}
	
	//Welcome method message - uses entityType() to return a string
	public String wMsg() {
		String type = this.entityType();
		return ("Welcome! Let's Begin! The entity is a " + type );
	}
	
	//Closing message - uses toString() from subclasses to return a string
	public String cMsg() {
		String closingMsg = this.toString();
		return closingMsg;
	}

	
	//method to return Name of entity for use in GuessMaster
	public String getName() {
		return this.name;
	}
	
	//method to return Date of entity for use in the GuessMaster
	public Date getDate() {
		return new Date(born);
	}
	
	//setters for setting the name and date for each entity
	public void setName(String newName) {
		this.name = newName;
	}

	public void setBorn(Date newDate) {
		this.born = newDate;
	}


	//combines name and born variables to make readable sentence
	public String toString() {
		return (this.name + ", born on " + this.born.getMonth() + " "
	    + this.born.getDay() + ", " + this.born.getYear());
	}
	
	//compares content of two entities
	public boolean equals(Entity otherEntity) {
		if (otherEntity == null)
			return false;
		else
			return (this.name.equals(otherEntity.getName()) 
				&& this.born.equals(otherEntity.getDate())); 
	 }
}