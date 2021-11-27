package game;
/* CST8110 - Introduction to Computer Programming
 * Section: 450
 * Semester: 20S
 * Professor: Piyush Jangam
 * Student ID: 040590102
 * Student Email: ragu0005@algonquinlive.com
 * Practical Assessment #2 
 */ 


/* This class implements a simple Player of the game NibbleNabble.*/
public class Player 
    {

	/* Two private properties: String name and character token */
	private String name;
	private char token;
	
	
	 /* No-args constructor initializes the name to Computer and token to the letter O.*/
	public Player()
            {
	        this.name="Computer";
		this.token='O';
	    }

	
	 /* Initial constructor initializes the Player name to the specified parameter and token to the                letter X. */
	public Player(String playerName) 
            {
		this.name=playerName;
		this.token='X'; 
	
	    }
	
	/* Getter method that returns the Player's name. */
	public String getName()
	    {
	        return name;	
	    }
		

	 /* Returns the Player's token (X or O).*/
	public char getToken()
	    {  
		if (getName()=="Computer")
		token= 'O';
		else token='X';
		
		return token;
	    }
	
	
	
}
