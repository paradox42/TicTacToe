

import java.util.Scanner;

class TicTacToe
{
    char ttt[][] = new char[3][3];
    static final char player1 = 'O';
    static final char player2 = 'X';
    static Scanner scan  = new Scanner(System.in);
    
        
    String playerID(char player)
    {
    // Prints the identity of the player
    // For example:
    // player2: X
    
        if (player == player1)
            return "player1: "+ player;
        else
            return "player2: "+ player;
    }
    
    int[] calculateCoordinate(char cell)
    {
    	int[] coor = new int[2];

    	switch(cell)
		{
			case 'a': coor[0]=0; coor[1]=0; break;
			case 'b': coor[0]=0; coor[1]=1; break;
			case 'c': coor[0]=0; coor[1]=2; break;
			case 'd': coor[0]=1; coor[1]=0; break;
			case 'e': coor[0]=1; coor[1]=1; break;
			case 'f': coor[0]=1; coor[1]=2; break;
			case 'g': coor[0]=2; coor[1]=0; break;
			case 'h': coor[0]=2; coor[1]=1; break;
			case 'i': coor[0]=2; coor[1]=2; break;
			default :
				System.out.print("this line are not supposed to be shown (invalid)\n");
		}
    	return coor;
    }

    void getPlayerInput(char player)
    {
    	// ******* Details to fill in ************
        
        // Prompt the user for a cell input.  Make sure its a legal
        // cell designator.  Also make sure the cell doesn't already
        // have a player in it.  Prompt the user again in the case 
        // of any problem.  Once a valid spot has been found, 
        // you will issue a statement like:
    	
    	char cell;
       	int row=1,col=1;
    	
    	System.out.println("Entering input for " + playerID(player));
    	System.out.print("Enter in cell [a, b, ...i]: ");
    	cell = Character.toLowerCase(scan.nextLine().charAt(0));
    	
    	while(cell<'a' || cell>'i')
    	{
    		System.out.println("invaild input, try again: ");
    		cell = Character.toLowerCase(scan.nextLine().charAt(0));
    	}
    	row = calculateCoordinate(cell)[0];
    	col = calculateCoordinate(cell)[1];
 
    	while(ttt[row][col]=='X' || ttt[row][col]=='O')
    	{
    		row = calculateCoordinate(cell)[0];
        	col = calculateCoordinate(cell)[1];
    	}
    	ttt[row][col] = player;
    }                  
   
   
   boolean gameIsDraw()
    {
    	for (int row =0; row <3; row++)
    	{
    		for (int col =0; col<3; col++)
    		{
    			if(ttt[row][col]== ' ')
    				return false;
    		}
    	}    
    	return true;

     // ******* Details to fill in ************
     
        // If all ttt entries have been taken return true
        // otherwise return false
    }
    
    boolean winner(char player)
    {
    	for (int row =0; row <3; row++)
    	{
    		if((ttt[row][0]== player) && (ttt[row][1]==player) && (ttt[row][2]==player))
    			return true;
    	}
    	for (int j = 0; j<3; j++)
    	{
    		if((ttt[0][j]== player) && (ttt[1][j]==player) && (ttt[2][j]==player))
    			return true;
    	}
    	if (ttt[0][0]== player && ttt[1][1]==player && ttt[2][2]==player)
    		return true;
    	if (ttt[0][2]==player && ttt[1][1]== player && ttt[2][0]==player)
    		return true;
    	return false;
    	
     // ******* Details to fill in ************
     
     // Check to see if the parameter player has won
     // Winning means that player shows up in a line of 
     // three.  The line can be a column, row or a diagonal
     // Return true if player is a winner, otherwise return false.
    }


    void displayBoard()
    {
    	System.out.println("********************************");        
        System.out.println("      ---a------b------c---");
        for (int i=0; i<3; i++)
        {
            for (int j=0; j< 3; j++)
            {
              if (j == 0) System.out.print("      |  "); 
              System.out.print(ttt[i][j]);
              if (j < 2) System.out.print( "   |  ");
              if (j==2)  System.out.print("  |");
            }
            System.out.println();
            switch (i)
            {
            case 0:
                System.out.println("      ---d------e------f---");
                break;
            case 1:
                System.out.println("      ---g------h------i---");
                break;
            case 2:
                System.out.println("      ---------------------");
                break;
            }
        }
    }
    
     
    void newgame()
    {
        char currPlayer = player1;
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                ttt[i][j] =' ';
        
        boolean continueFlag = true;        
        while (continueFlag)
        {
            displayBoard();
            if (gameIsDraw())
            {
                System.out.println("Game Ends in Draw");
                continueFlag = false;
            }
            else
            {
                getPlayerInput(currPlayer);
                if (winner(currPlayer))
                {
                    System.out.println("We have a winner: " + playerID(currPlayer));
                    displayBoard();
                    continueFlag = false;
                }
                else
                { 
                    if (currPlayer == player1) 
                    	currPlayer = player2;
                    else
                    	currPlayer = player1;
                }
             }
        }
        
    }

    
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
        String str;
        do
        {
            game.newgame();
            
            System.out.println("Do you want to play Tic-Tac-Toe (y/n)?");
            str= scan.nextLine();
        } while ("y".equals(str));
        scan.close();
        System.out.println("Bye");
    }    
}
