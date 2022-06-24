package assignment2;
/*

APSC 279 - Assignment 2
Nicholas Alderman, 16naa5, 20060982

Singer class extends entity class and contains additional information about this type of entity

*/
public class Singer extends Person {

	private String album;
	private Date albumDate;
	
	//super-constructor to set proper parameters in entity
	public Singer(String nameIn, Date dateIn, String gender, String album, Date albumDate, double diff) {
		super(nameIn, dateIn, gender, diff);
		this.album = album;
		this.albumDate = albumDate;
	}
	
	//copy-constructor to set proper entity parameter in entity class
	public Singer(Singer singer) {
		super(singer);
		this.album = singer.album;
		this.albumDate = singer.albumDate;
	}

	//customizes toString() to ensure proper closing message that includes 'capital'
	public String toString() {
		return (super.toString() + "\nDebut Album: " + this.album + "\nRelease Date: " + this.albumDate);

	}

	//overrided method to ensure proper welcome message
	@Override
	public String entityType() {
		return "Singer!";
	}

	//overrided method to create a copy of an entity
	@Override
	public Singer clone() {
		return new Singer(this);
	}
}
