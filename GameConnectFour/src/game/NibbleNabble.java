package game;
/* CST8110 - Introduction to Computer Programming
 * Section: 450
 * Semester: 20S
 * Professor: Piyush Jangam
 * Student ID: 040590102
 * Student Email: ragu0005@algonquinlive.com
 * Practical Assessment #2 
 */ 

import java.util.Scanner;
import java.util.Random;

  /*This class implements a simple version of Connect Four, called NibbleNabble.*/
  
public class NibbleNabble {

	private Player currentPlayer;
	private Player computer;
	private Player user;
	private Board board;
	private Scanner input;
	
	/*Outputs a welcome message. Prompts the user for their name, and instantiates a new Player with the name.
	 *  Initializes the Scanner, Board, user and computer variables.*/

	public NibbleNabble() 
	    {
		    System.out.println("Welcome to connect 4 game please enter your your name");
		    this.input=new Scanner(System.in);
            String userName=input.nextLine();
			
            this.board=new Board();
	        this.user=new Player(userName);
		    this.computer=new Player();
		
	      }
	
	public boolean playGame() 
	    {
			
		    while (true) 
		        {
			        board.display();
			        int column = 0;
			        currentPlayer = togglePlayer();
			
			        System.out.print(currentPlayer.getName() + " > ");
			
			            while (column == 0)
			                {
				                if (currentPlayer == computer) 
				                    {
					                    column = new Random().nextInt(7) + 1;
					                    System.out.println(column);
				                    } 
				                else 
				                    {
					                    String move = input.next();
					                    if (move.toUpperCase().charAt(0) == 'Q')
						                return false;
					                    column = Integer.parseInt(move);
				                    }
				
				                if (!board.makeMove(column, currentPlayer.getToken()))
				                    {
					                    column = 0;
				                    }
			                 }

			if (currentPlayer == computer && board.checkVictory())
			    {
				    System.out.println("Oh no! The computer won!");
				    board.display();
				    break;
			    }  
			if (currentPlayer == user && board.checkUserVictory())
			    {
				    System.out.println("You are victorious!!!");
				    board.display();
				    break;
				} 
			
			   }	
		
		return true;
	}
	
	 /* Outputs prompt to user: Enter Q to quit, or any key to keep playing:
	  If the user enters any variation of Q, q, Quit, quit, quit the game.*/
	
	public boolean quit()
	    {
		    System.out.println(" Enter Q to quit, or any key to keep playing");
		    String userResponse = input.nextLine();
		    if ((userResponse.toLowerCase().equals("q")) || (userResponse.toLowerCase().equals                    ("quit"))){
			return true;
		    }
		board = new Board();
		return false;
	     }

	/* If the currentPlayer is the user, returns computer. Otherwise, returns the user.*/

	private Player togglePlayer()
	    {	
		    if (currentPlayer==user)
			return computer;
		    return user;
	    }
}
