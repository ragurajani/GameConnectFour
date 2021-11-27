package game;
/* CST8110 - Introduction to Computer Programming
 * Section: 450
 * Semester: 20S
 * Professor: Piyush Jangam
 * Student ID: 040590102
 * Student Email: ragu0005@algonquinlive.com
 * Practical Assessment #2 
 */ 

 /*This class kicks off the game NibbleNabble, and continues playing until the user quits.
  */
public class Main
    {
	 /* Execute the playGame method while the quit method continues to return false.
	  * If the playGame method returns false, exit the loop.*/
	    public static void main(String[] args) 
	        {
		        NibbleNabble n=new NibbleNabble();
				do{
			          if (n.playGame() == false)
			          break;
		                   } while (n.quit() == false);


	        }
    }

