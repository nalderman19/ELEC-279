package assignment2;

/*

APSC 279 - Assignment 2
Nicholas Alderman, 16naa5, 20060982

Guessmaster class is used to define run game using objects created with entity class

*/
import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
	private int numOfEntities;
	private Entity[] entities;
	private int totTickets;
	private int winTickets;
	
	public GuessMaster() {
		numOfEntities = 0;
		entities = new Entity[100]; 
	}

    //function to retrieve a copy of the entity array
	public void addEntity(Entity entity) {
		entities[numOfEntities++] = entity.clone();
	}
	
	public void playGame(int entityId) {
		Entity entity = entities[entityId];
		playGame(entity);
	}
	
	public void playGame(Entity entity) {
		System.out.printf(entity.wMsg());
		System.out.printf("\nGuess %s's birthday\n", entity.getName());
		System.out.println("\nEnter a date in the form of (mm/dd/yyyy), or type 'quit' to quit game");
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String answer = scanner.nextLine();
			answer = answer.replace("\n", "").replace("\r", "");

			if (answer.equals("quit")) {
				System.out.println("Quitting Game...");
				System.exit(0);
			}

			Date date = new Date(answer);

			if (date.precedes(entity.getDate())) {
				System.out.println("Incorrect. Try a later date.");
			} else if (entity.getDate().precedes(date)) {
				System.out.println("Incorrect. Try an earlier date.");
			} else {
				//win code
				//uses function in Entity class to 'get awarded tickets number' and assigns it to a variable
				winTickets = entity.gATN();
				//adds total tickets number
				totTickets += winTickets;
				System.out.printf("*************Bingo!***************\n");
				System.out.printf("*******You Won %d Tickets!********\n", winTickets);
				System.out.printf("******Ticket Balance is: %d*******\n\n", totTickets);
				//prints closing message using function in Entity class
				System.out.printf(entity.cMsg());
				System.out.printf("\n\n");				
				break;
			}
		}
		
		
	}
	
	public void playGame() {
		while (true) {
			int entityId = genRandomEntityId();
			playGame(entityId);
		}
	}

    //function to retrieve numberOfCanditateEntities
	public int genRandomEntityId() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(numOfEntities);
	}

	public static void main(String[] args) {
		// The last parameter of the follow line is the difficulty score described above. 
		Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
		/*The first Date parameter in the parameter in the following line is the birth date of the singer and the second Date parameter is the release date of the debut album.*/
		Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
		Person Nicholas = new Person("Nicholas Alderman", new Date("December", 19, 1999),"Male", 1);
		Country usa = new Country("United States", new Date("July", 4, 1776), "Wasington D.C.", 0.1);

		//instantiates new guessMaster object to play the game 
		GuessMaster gm = new GuessMaster();
		//adds entities that were set up to the guessMaster object
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(Nicholas);
		gm.addEntity(usa);
		
		gm.playGame();
	}
}
