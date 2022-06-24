package assignment1;
/*

APSC 279 - Assignment 1
Nicholas Alderman, 16naa5, 20060982

GuessMaster class is used to run the game.

*/
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
	
    private static final int ARRAY_LEN = 25;
	//nOCE = number of candidate entities
	private int nOCE = 0;
	private Entity[] entities = new Entity[ARRAY_LEN];
	
	public void addEntity(Entity entity) {
		//adds new entity to Entity[] array
		this.entities[this.nOCE] = entity;
		this.nOCE++;
		
	}
	
	public void playGame(Entity entity) {
		//play game given an entity
	    System.out.print("Welcome to GuessMaster - A Date Guessing Game! \n");
	    System.out.printf("Guess when %s's birthday is.", entity.getName());
	    
	    //local variable to check if the user was correct or not
	    boolean gameOver = false;
	    
	    //scanner object that is used to read users input
	    Scanner reader = new Scanner(System.in);
	    
	    //infinite loop until either user gets correct answer or opts to quit
	    while (gameOver == false) {
	    	System.out.println("\nPlease enter a guess in the format 'Month Day Year', or type 'quit' to end the game.");
	            
	        //String input = reader.nextLine();
	        Date inDate = new Date();
	        inDate.readInput();
	        Date realDate = new Date(entity.getDate());
	        
	        //Logic used to determine whether guess was correct, too early, or too late
	        //uses precedes function to determine this
	        if (inDate.precedes(realDate)) {
	         	System.out.println("Incorrect. Try a later date.");
	        } else if (inDate.equals(realDate)) {
	        	System.out.println("BINGO! You got it!");
	            gameOver = true;
	            this.playGame();
	        } else {
	        	System.out.println("Incorrect. Try an earlier date.");
	        }
	    }
	}
	    
		
	
	
	public void playGame(int entityInd) {
		//play game given entity index, uses this value to fetch corresponding element
		//in Entity[] array and play game by invoking above method
        if (entityInd + 1 > nOCE) {
            System.out.println("Invalid index.");
            return;
        } else {
            playGame(entities[entityInd]);
        }
    }
	
	public void playGame() {
		//generates random number to pick element in Entity[]
		//invokes above method to play game
		int rndInd = gREI();
		playGame(rndInd);
	}
	
	public int gREI() {
		//returns random number for the use of the above method
		Random rnd = new Random();
		int i = rnd.nextInt(this.nOCE);
		return i;
	}
	
	//setters
    public void setNumberOfCandidateEntities(int nOCE) {
        //function to set numberOfCanditateEntities
        this.nOCE = nOCE;
    }

    public void setEntities(Entity[] entities) {
        //function to set Entities
        this.entities = entities;
    }
	
	//getters
	public int getNOCE() {
        //function to retrieve numberOfCanditateEntities
        return this.nOCE;
    }

    public Entity[] getEntities() {
        //function to retrieve a copy of the entity array
        return Arrays.copyOf(this.entities, this.nOCE);
    }
	
	public static void main(String[] args) {
		//setting up entities for use in the game
		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968)); 
		Entity usa = new Entity("United States", new Date("July", 4, 1776));
		Entity nicholas = new Entity("Nicholas", new Date("December", 19, 1999));
		Entity canada = new Entity("Canada", new Date("July", 1, 1867));
		
		//instantiates new guessMaster object to play the game 
		GuessMaster gm = new GuessMaster();
		
		//adds entities that were set up to the guessMaster object
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(usa);
		gm.addEntity(nicholas);
		gm.addEntity(canada);
		
		//starts game
		gm.playGame();
		
	}
	
}	
