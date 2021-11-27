package game;

/* CST8110 - Introduction to Computer Programming
 * Section: 450
 * Semester: 20S
 * Professor: Piyush Jangam
 * Student ID: 040590102
 * Student Email: ragu0005@algonquinlive.com
 * Practical Assessment #2 
 */ 


 /* This class is a single Column on the board, containing vertically stacked X and O tokens.*/

public class Column
    {

	private static final int MAX_HEIGHT = 6;
	private int height = 0;
	private char[] column;
	
	
	/* Default constructor - initialize the column array and each element of the column array to contain a blank space.*/
	
	public Column()
	    {
		    this.column=new char[MAX_HEIGHT ];
		    for(int row=0; row<MAX_HEIGHT; row++)
	               {
			        column[row]=' ';
		        }
	    }
	
	
	 /* Return the value in the specified row.*/
	
	public char get(int row) 
	    {
		    return column[row];
	    }
	
	/* Put the specified token character at the top of the column, increments the height, and returns true.*/
	
	public boolean put(char token)
	    {
		    boolean success = false;
		        if ((token == 'X') || (token == 'O'))
		            {
			            if (getHeight() < MAX_HEIGHT) 
			                {
				                column[height] = token;
				                height++;
				                success = true;

			                 } 
			    else 
			        {
				        success = false;
			        }
		    }
		return success;

	}
		
	 /* Check if the column contains a Nibble.
	  return True if the column contains 4 or more consecutive 'O' tokens, else false.*/
	
	public boolean checkVictory() 
	    {
		    for (int i=0; i<MAX_HEIGHT-3; i++)
		        {
			        if(column[i]!= ' ' &&
			           column[i] == 'O' && 
			           column[i] == column[i+1] &&
				   column[i] == column[i+2]  &&
				   column[i] == column[i+3] ){
				return true;
			       }
		         }
		     return false;
	      }
	
		
	
	 /* Returns the current height of the Column.*/
	
	 public int getHeight() 
	    {
		    return height;
            }
}
