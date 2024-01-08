

package rPSGame;
import java.util.Random;
import java.util.Scanner;
public class rockPaperScissors
{
 
	//These are the global variables
	public static final String ROCK = "1";
	public static final String PAPER = "2";
	public static final String SCISSORS = "3";
	public static int count=0;
	public static int computer=0;
	
	/**
     * Main method
     **/	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("WELCOME TO ROCK PAPER SCISSORS!");
		System.out.println("");
		System.out.println("Please enter your name: ");
		
		//This code will prevent you from inputing any numbers or special characters
		String name = input.nextLine();
		while(!name.matches("[a-zA-Z]+"))
		{
	        System.out.println("Please enter a valid name");
	        name = input.nextLine();
		}
		playGame();
		playAgain();

	}
	
	//This class is where we initialize the whole game
	public static void playGame()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of rounds you want to play: ");
		
		//This code will decrease the number of rounds by 1 by what your input for the # of rounds was
		int nR = input.nextInt();
		for (int i = 1; i <= nR; i++)
			{
				System.out.println("\nRound # " + i);
				System.out.println("Rock = 1, Paper= 2, and Scissors = 3");
				String userInput = getUsersMove();  
				
				//This piece of code is used that you can only enter the numbers 1, 2 and 3 when it asks you for your play
				int n = 0;

				if (userInput.equals(PAPER) || userInput.equals(ROCK) || userInput.equals(SCISSORS))
				{ 
	                 getResult(userInput, getComputersMove());
	            }
				else 
				{ 
					while (n == 0) 
	                {
	                	System.out.println("Invalid input, please input again ");
	                    userInput = getUsersMove();
	                    if (userInput.equals(PAPER) || userInput.equals(ROCK) || userInput.equals(SCISSORS)) 
	                    { 
	                         n = 1;
	                         getResult(userInput, getComputersMove());
	                    }
	                }
				}
			}
			
			//This code is used to finalize the winnings of each members and tally them up to find out who won the game
			int total1 = count;
			int total2 = computer;
			if(count>computer)
			{
				System.out.println(total1 + "-" + total2 + "\nYou win the whole game!");
			}
			else if (count<computer)
			{
				System.out.println(total1 + "-" + total2 + "\nThe computer wins this game!");
			}
			else if (count==computer)
			{
				System.out.println("It's a tie, no one wins!");
			}
	}	
	
	
	//This class will determine if you will like to play again or not
	public static void playAgain() 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nDo you want to play again? ");
		String answer = input.nextLine();
		if(answer.equals("y")||answer.equals("Y"))
		{
			playGame();
		}
		else if(answer.equals("n")||answer.equals("N"))
		{
			System.out.println("Thanks for playing!");
		}
		else
		{
			System.out.println("Invalid answer. Please type y for yes and n for no");
			playAgain();		
		}  
		
	}
	
	
	//This class determines based on the computers and users move who won the game
	public static void getResult(String usersMove, String computersMove) 
	{
        System.out.println("Computer's move is: " + computersMove);
        System.out.println("Your move is: " + usersMove);
        
        if (usersMove.equals(computersMove))
        {
	        System.out.println("It's a tie!");
	        
        }
        else if (usersMove.equals(ROCK)) 
        {
	        if (computersMove.equals(SCISSORS))
	        {
		        System.out.println("You win! Rock crushes scissors.");
		        count+=1;
	        }
	        else if (computersMove.equals(PAPER))
		    {
	        	System.out.println("You lose! Paper eats rock.");
	        	computer+=1;
		    }
        } 
        else if (usersMove.equals(PAPER)) 
        {
            if (computersMove.equals(ROCK))
		    {
            	System.out.println("You win! Paper eats rock.");
            	count+=1;
		    }
	        else if (computersMove.equals(SCISSORS))
		    {
	        	System.out.println("You lose! Scissor cuts paper.");
	        	computer+=1;
		    }
        } 
        else if (usersMove.equals(SCISSORS)) 
        {
	        if (computersMove.equals(PAPER))
		    {
	        	System.out.println("You win! Scissor cuts paper.");
	        	count+=1;
	        	
		    }
	        else if (computersMove.equals(ROCK))
	        {
		        System.out.println("You lose! Rock breaks scissors.");
		        computer+=1;
	        }
        } 
        else
        {
    	    System.out.println("Invalid user input."); 
    	    
        }
        
	}
	

    
	//This class is to get the users move
		public static String getUsersMove()
		{
			Scanner input = new Scanner(System.in);
		    System.out.println("Enter your play: ");
			int userNum = input.nextInt();
			String usersMove="";
			if (userNum == 1)
			{
				usersMove = ROCK;
				System.out.println("You chose Rock!");
			}
			else if (userNum == 2)
			{
				usersMove = PAPER;
				System.out.println("You chose Paper!");
			}
			else if (userNum == 3)
			{
				usersMove = SCISSORS;
				System.out.println("You chose Scissors!");
			}
			return usersMove;       
	    }
	//This class is to get the computers move
	public static String getComputersMove()
	{
		int computersNum;
		String computersMove="";
		Random random = new Random();
		computersNum = random.nextInt(3) + 1;
		if (computersNum == 1)
		{
			computersMove = ROCK;
			System.out.println("The AI chose Rock");
		}
		else if (computersNum == 2)
		{
			computersMove = PAPER;
			System.out.println("The AI chose Paper");
		}
		else if (computersNum == 3)
		{
			computersMove = SCISSORS;
			System.out.println("The AI chose Scissors");
		}
		return computersMove;
	}
	
	
	//End of main method
	
}

//End of code
