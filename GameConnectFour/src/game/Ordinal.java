package game;

/* CST8110 - Introduction to Computer Programming
 * Section: 450
 * Semester: 20S
 * Professor: Piyush Jangam
 * Student ID: 040590102
 * Student Email: ragu0005@algonquinlive.com
 * Practical Assessment #2 
 */ 

public class Ordinal {

	
	/* Returns the ordinal value of the specified integer value*/
	
	public static String getOrdinal(int integer) {
		
		  {
	        integer = integer%10;
	        String string = "";
	        switch(integer)
	        {
	        case 1:     
	            string = "st";
	            break;
	        case 2:     
	            string = "nd";
	            break;
	        case 3:     
	            string = "rd";
	            break;
	        default: 
	            string = "th";             
	        }
	        return string;
		
	}
	
}
}