package game;
/* CST8110 - Introduction to Computer Programming
 * Section: 450
 * Semester: 20S
 * Professor: Piyush Jangam
 * Student ID: 040590102
 * Student Email: ragu0005@algonquinlive.com
 * Practical Assessment #2 
 */ 

/* This class simulates a NibbleNabble game board. */

public class Board 
    {
	
	/* Number of rows on the board */
	
	private final static int NUM_ROWS = 6;
	
	/* Number of columns on the board */
	
	private final static int NUM_COLS = 7;
	
	/* Array of Column objects, which contain token values */
	
	private Column[] board = new Column[NUM_COLS];
	
	
	/* Loop through the board array, to instantiate and initialize each element as a new Column*/
	 
	public Board() 
	    {
		
		    for (int i=0; i<NUM_COLS; i++)
		        {
			        this.board[i]=new Column();
		        }
	
	     }

	 /* Check for Is column number valid, output an error message and return false if its invalid.
	 * Try to put the token in the specified column of the board. Output an error message and return          false if it does not work.*/
	
	public boolean makeMove(int column, char token) 
	    {
		    if(column > 7)
		        {
			        System.out.println("Please Enter the valid column number between 1 to 7");
			        return false;
		        }

		    return board[column-1].put(token);
	    }
	

	 /* Checks for Computer's victory by looking for complete vertical and horizontal nibbles.*/
	public boolean checkVictory() 
	    {
		  	   
		/* Check for vertical Nibble*/
		
		for (int column = 0; column < NUM_COLS; column++)
		   {
		      if (board[column].checkVictory()) {
		         return true;
		       }
		   }
         /*checking for horizontal Nibble*/
		
		 for (int row = 0; row < NUM_ROWS; row++) 
		     {
		         for (int col = 0; col < NUM_COLS - 3; col++) 
		         {
		         Column column = board[col];
		         if (
		               board[col].get(row) == 'O' &&
		               board[col].get(row) == board[col+1].get(row) &&
		               board[col].get(row) == board[col+2].get(row) &&
		               board[col].get(row) == board[col+3].get(row) &&
		              (board[col].get(row) != ' ' || board[col+1].get(row) != ' ' || board[col                               +2].get(row) != ' ')) 
                         {
		            return true;
		         }

		      }
		   }
		   return false;
		}
	
	 /* Checks each column to see if there is room enough for at least 4 more O values.
	 * Checks final row to see if there is room enough for at least 4 O (non-X) values.*/
	 
	public boolean isFull() 
	    {
		for (int col = 0; col < NUM_COLS; col++) {
			for (int i=2; i< 3; i++){
				Column column = board[col];
				if(column.get(col) == ' '){
					return false;
				}
			}
		}

		int nonXcount = 0;
		for (int row = 0; row < NUM_ROWS; row++) {
			nonXcount =0;
			for (int col = 0; col < NUM_COLS - 3; col++) {
				Column column = board[col];
				if (column.get(col) != 'X') {
					nonXcount++;
				}
			}
			if(nonXcount > 3){
				return true;
			}
		}
		return false;
	}
    
	/*Check for User's Victory horizontally and vertically*/
	
	public boolean checkUserVictory()
            {
		/*Check for vertical Nibble*/
		
		for (int col = 0; col < NUM_COLS; col++)
		    {
		        for (int row=0; row<NUM_ROWS-3 ; row++)
		            {
		                Column column = board[col];
		                if(column.get(row) == 'X' && 
		                column.get(row) != ' ' && 
		                column.get(row) == column.get(row+1)&&
		                column.get(row) == column.get(row+2)&&
		                column.get(row) == column.get(row+3)){
		                return true;
		           }
		      }
		   }

		/*Check for horizontal Nibble for user*/
		
	   for (int row = 0; row < NUM_ROWS; row++) 
	       {
	            for (int col = 0; col < NUM_COLS - 3; col++)
		             {
		                 if (board[col].get(row) == 'X' &&
		                     board[col].get(row) == board[col+1].get(row) &&
		                     board[col].get(row) == board[col+2].get(row) && 
		                     board[col].get(row) == board[col+3].get(row) &&
		                    (board[col].get(row) != ' ' || board[col+1].get(row) != ' ' || board[col                                     +2].get(row) != ' ')) {
		               return true;
		                   }

		             }
		   }
		   return false;
		}
	
	 
	 /* Displays, in a grid  each token in a row and column*/
	
	public void display()
	    {
		    System.out.println(" 1 2 3 4 5 6 7 ");
		    System.out.println("---------------");
		        for(int i=NUM_ROWS - 1; i>=0; i--)
		        {  
			         System.out.print("|");
			    for(int k=0; k<NUM_COLS; k++)
			    {
				    Column column = board[k];
				    System.out.printf("%c",column.get(i) );
				    System.out.print("|");
			    }
			        System.out.println();
		        }
		     System.out.println("---------------");
		     System.out.println(" 1 2 3 4 5 6 7 ");
           }	

}

