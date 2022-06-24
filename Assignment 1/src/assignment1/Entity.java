package assignment1;
/*

APSC 279 - Assignment 1
Nicholas Alderman, 16naa5, 20060982

Entity class is used to define entities using information from guessMaster class

*/

public class Entity {
	
	private String name;
	private Date born;

	public Entity(String nameIn, Date dateIn) {
		//takes in input from main method and updates entities
		this.name = nameIn;
		this.born = dateIn;
	}
	
	//method to return Name of entity for use in GuessMaster
	public String getName() {
		return this.name;
	}
	
	//method to return Date of entity for use in the GuessMaster
	public Date getDate() {
		return this.born;
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