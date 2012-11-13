package com.example.sliding_tiles;

import java.util.Arrays;


public class TilesAI {
		int delay;
	
	
	int solveAI(int tiles[], int mode){
	
		int winner[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,0};
		
		if (mode==1) delay=3500;
		if (mode==2) delay=2500;
		if (mode==3) delay=1500;		
		
		//Set number 1
		moveTile(tiles, 1);
		gameDelay();
		
		//Set number 2
		moveTile(tiles, 2);
		gameDelay();
		
		//Set number 3
		moveTile(tiles, 3);
		gameDelay();
		
		//Set number 4
		move4or9(tiles, 4);
		gameDelay();
		
		//Set number 5
		move5or10(tiles, 5);
		gameDelay();
		
		//Set number 6
		moveTile(tiles, 6);
		gameDelay();
		
		//Set number 11
		moveTile(tiles, 11);
		gameDelay();
		
		//Set number 16
		move16or17(tiles, 16);
		gameDelay();
		
		//Set number 21
		move21or22(tiles, 21);
		gameDelay();
		
		//Set number 7
		moveTile(tiles, 7);
		gameDelay();
		
		//Set number 8
		moveTile(tiles, 8);
		gameDelay();
		
		//Set number 9
		move4or9(tiles, 9);
		gameDelay();
		
		//Set number 10
		move5or10(tiles, 10);
		gameDelay();
		
		//Set number 12
		moveTile(tiles, 12);
		gameDelay();
		
		//Set number 17
		move16or17(tiles, 17);
		gameDelay();
		
		//Set number 22
		move21or22(tiles, 22);
		gameDelay();
		
		//Set number 13
		moveTile(tiles, 13);
		gameDelay();
		
		//Set number 14
		move4or9(tiles, 14);
		gameDelay();
		
		//Set number 15
		move5or10(tiles, 15);
		gameDelay();
		
		//Set number 18
		move16or17(tiles, 18);
		gameDelay();
		
		//Set number 23
		move21or22(tiles, 23);
		gameDelay();
		
		//Make the final moves to solve the puzzle
		finalMoves(tiles);
		
		// If tiles is now the same as the winning array
		// return a 1 to indicate done.
		if (Arrays.equals(tiles, winner)) return 1;
		
		return 0;
	}
	
	// Method to control the moving of a tile. Used for tiles not in the last
	// two spaces at the right edge or bottom on a column.
	void moveTile(int tiles[], int num)
	{
	    int location;
	    location = find(tiles, num);
	    
	    if (location == num - 1) return;
	    
	    if (location == 24 || tiles[location + 1] != 0){
    		setEmpty(tiles, num);
    		location = find(tiles, num);
    	}
	    
	    while (location != num-1)
	    {
			gameDelay();
	    	
	    	if (location == 24 || tiles[location + 1] != 0){
	    		setEmpty(tiles, num);
	    		location = find(tiles, num);
	    	}

	        if (location >= 20 )
	        {
	           upOne(tiles, location);
	        }
	        else if (location < num )
	        {
	           downOne(tiles, location);
	        }
	        else if (location > num+4 && location % 5 > (num-1) % 5)
	        {
	           upLeft(tiles, location);
	        }
	        else if (location < num+4 && location % 5 > (num-1) % 5 )
	        {
	           leftOne(tiles, location);
	        }
	        else if ((num-1) % 5 == location % 5 )
	        {
	           upOne(tiles, location);
	        }
	        else if ((num-1) % 5 > location % 5 )
	        {
	           rightOne(tiles, location);
	        }
	        location = find(tiles, num);
	    }	    	    
	}
	
	// Method to move the tile second fom the left edge to the set up
	// position to be rotated into position.
	void move4or9(int tiles[], int num)
	{		
		int location;
	    
	    location = find(tiles, num);
	    
	    if (location == num){
	    	if(tiles[location-1]==0){
	    		tiles[location-1] = tiles[location+4];
			    tiles[location+4] = 0;
	    	}
	    	return;
	    }
	    
	    if (location == 24 || tiles[location + 1] != 0){
    		setEmpty(tiles, num);
    		location = find(tiles, num);
    	}
	    
	    while (location != num+4)
	    {
			gameDelay();
	    	
	    	if (location == 24 || tiles[location + 1] != 0){
	    		setEmpty(tiles, num);
	    		location = find(tiles, num);
	    	}
	        
        	if (location > num+4 && location % 5 > (num+4) % 5)
	        {
	           upLeft(tiles, location);
	        }
	        else if (location < num )
	        {
	           downOne(tiles, location);
	        }
	        else if (location < num+4 && location % 5 > (num+4) % 5 )
	        {
	           leftOne(tiles, location);
	        }
	        else if ((num+4) % 5 == location % 5 )
	        {
	           upOne(tiles, location);
	        }
	        else if ((num+4) % 5 > location % 5 )
	        {
	           rightOne(tiles, location);
	        }
	        location = find(tiles, num);
	    }
	    upRight(tiles, location);
	}
	
	// Move the tile at the left edge into position and finish the move of the 
	// previous tile as well.
	void move5or10(int tiles[], int num)
	{		
	    int location;
	    
	    location = find(tiles, num);
	    
	    if (location == 24 || tiles[location + 1] != 0){
    		setEmpty(tiles, num);
    		location = find(tiles, num);
    	}
	    
	    if(location != num-2){
		    while (location != num+3)
		    {
				gameDelay();
		    	
		    	if (location == 24 || tiles[location + 1] != 0){
		    		setEmpty(tiles, num);
		    		location = find(tiles, num);
		    	}
	
		        if (location >= 20 )
		        {
		           upOne(tiles, location);
		        }
		        else if (location > num+3 && location % 5 > (num+3) % 5)
		        {
		           upLeft(tiles, location);
		        }
		        else if (location < num+3 && location % 5 > (num+3) % 5 )
		        {
		           leftOne(tiles, location);
		        }
		        else if ((num+3) % 5 == location % 5 )
		        {
		           upOne(tiles, location);
		        }
		        else if ((num+3) % 5 > location % 5 )
		        {
		           rightOne(tiles, location);
		        }
		        location = find(tiles, num);
		    }
		    rightOne(tiles, location);
		    location = find(tiles, num);
		    topRightSet(tiles, location-5);
	    }
	    else
	    {
	    	tiles[location+1] = tiles[location+6];
		    tiles[location+6] = 0;
	    	topRightTrapped(tiles, location);
	    }
	}
	
	// Move the second from the bottom tile into its set-up position
	void move16or17(int tiles[], int num)
	{		
	    int location;
	    
	    location = find(tiles, num);
	    
	    if (location == 24 || tiles[location + 1] != 0){
    		setEmpty(tiles, num);
    		location = find(tiles, num);
    	}
	    
		while (location != num)
        {
			gameDelay();
			
			if (location == 24 || tiles[location + 1] != 0){
	    		setEmpty(tiles, num);
	    		location = find(tiles, num);
	    	}

			if ( location% 5 < num % 5 )
            {
               rightOne(tiles, location);
            }
            else if ( location% 5 == num % 5 && location < num  )
            {
               downOne(tiles, location);
            }
            else if ( location% 5 > num % 5 )
            {
               leftOne(tiles, location);
            }
            else if (location% 5 == num % 5 && location > num )
            {
               upOne(tiles, location);
            }
            
            location = find(tiles, num);
        }
        dnLeft (tiles, location);
	}
	
	// Move the column bottom column tile into position and make the final positioning
	// for it and the prior tile.
	void move21or22(int tiles[], int num)
	{		
	    int location;
	    
	    location = find(tiles, num);
	    
	    if (location == 24 || tiles[location + 1] != 0){
    		setEmpty(tiles, num);
    		location = find(tiles, num);
    	}
	    
	    if(location != num-6){
			while (location != num-5)
	        {
				gameDelay();
				
				if (location == 24 || tiles[location + 1] != 0){
		    		setEmpty(tiles, num);
		    		location = find(tiles, num);
		    	}
	
				if ( location % 5 == (num-5)%5 && location < num-4 )
	            {
	               downOne(tiles, location);
	            }
	            else if ( location % 5 > (num-5)%5 )
	            {
	               leftOne(tiles, location);
	            }
	            else if (location % 5 == (num-5)%5 && location > num-4 )
	            {
	               upOne(tiles, location);
	            }
	            location = find(tiles, num);
	        }
	        downOne(tiles, location);
			location = find(tiles, num);
	        bottomLeftSet(tiles, location);
	    }
	    else
	    {
	    	setEmpty(tiles, num);
	    	botLeftTrapped(tiles, location);
	    }
	}
	
	
	// Move a selected tile up one position
	void upOne(int tiles[], int target)
	{		
			tiles[target+1] = tiles[target-4];
		    tiles[target-4] = 0;

		    tiles[target-4] = tiles[target-5];
		    tiles[target-5] = 0;

		    tiles[target-5] = tiles[target];
		    tiles[target] = 0;

		    tiles[target] = tiles[target+1];
		    tiles[target+1] = 0;

		    tiles[target+1] = tiles[target-4];
		    tiles[target-4] = 0;
		    
			gameDelay();		
	}
	
	// Move a selected tile down one position
	void downOne(int tiles[], int target)
	{		
	    tiles[target+1] = tiles[target+6];
	    tiles[target+6] = 0;

	    tiles[target+6] = tiles[target+5];
	    tiles[target+5] = 0;

	    tiles[target+5] = tiles[target];
	    tiles[target] = 0;

	    tiles[target] = tiles[target+1];
	    tiles[target+1] = 0;

	    tiles[target+1] = tiles[target+6];
	    tiles[target+6] = 0;
	    
		gameDelay();
	}
	
	void leftOne(int tiles[], int target)
	{		
	    if(target < 20)
	    {		
			tiles[target+1] = tiles[target+6];
		    tiles[target+6] = 0;
	
		    tiles[target+6] = tiles[target+5];
		    tiles[target+5] = 0;
	
		    tiles[target+5] = tiles[target+4];
		    tiles[target+4] = 0;
	
		    tiles[target+4] = tiles[target-1];
		    tiles[target-1] = 0;
	
		    tiles[target-1] = tiles[target];
		    tiles[target] = 0;
		    
			gameDelay();
	    }
	    else
	    {
	    	tiles[target+1] = tiles[target-4];
		    tiles[target-4] = 0;
	
		    tiles[target-4] = tiles[target-5];
		    tiles[target-5] = 0;
	
		    tiles[target-5] = tiles[target-6];
		    tiles[target-6] = 0;
	
		    tiles[target-6] = tiles[target-1];
		    tiles[target-1] = 0;
	
		    tiles[target-1] = tiles[target];
		    tiles[target] = 0;
		    
			gameDelay();
	    }	    
	}
	
	// Move the target tile right by one spot
	void rightOne(int tiles[], int target)
	{		
		if((target%5==3))
	    {	
		    tiles[target+1] = tiles[target];
		    tiles[target] = 0;
	
		    tiles[target] = tiles[target+5];
		    tiles[target+5] = 0;
	
		    tiles[target+5] = tiles[target+6];
		    tiles[target+6] = 0;
	    }
		else if(target < 20)
	    {	
		    tiles[target+1] = tiles[target];
		    tiles[target] = 0;
	
		    tiles[target] = tiles[target+5];
		    tiles[target+5] = 0;
	
		    tiles[target+5] = tiles[target+6];
		    tiles[target+6] = 0;
	
		    tiles[target+6] = tiles[target+7];
		    tiles[target+7] = 0;
	
		    tiles[target+7] = tiles[target+2];
		    tiles[target+2] = 0;
	    }
	    else
	    {
	    	tiles[target+1] = tiles[target];
		    tiles[target] = 0;
	
		    tiles[target] = tiles[target-5];
		    tiles[target-5] = 0;
	
		    tiles[target-5] = tiles[target-4];
		    tiles[target-4] = 0;
	
		    tiles[target-4] = tiles[target-3];
		    tiles[target-3] = 0;
	
		    tiles[target-3] = tiles[target+2];
		    tiles[target+2] = 0;
	    }	    
		gameDelay();
	}
	
	// Move selected tile up one and to the left one.
	void upLeft(int tiles[], int target)
	{
	    tiles[target+1] = tiles[target-4];
	    tiles[target-4] = 0;
	    
	    tiles[target-4] = tiles[target-5];
	    tiles[target-5] = 0;
	    
	    tiles[target-5] = tiles[target];
	    tiles[target] = 0;
	    
	    tiles[target] = tiles[target-1];
	    tiles[target-1] = 0;
	    
	    tiles[target-1] = tiles[target-6];
	    tiles[target-6] = 0;
	    
	    tiles[target-6] = tiles[target-5];
	    tiles[target-5] = 0;
	    	    
		gameDelay();
	}
	
	// Move selected tile down one and to the left one
	void dnLeft(int tiles[], int target)
	{		
	    tiles[target+1] = tiles[target+6];
	    tiles[target+6] = 0;

	    tiles[target+6] = tiles[target+5];
	    tiles[target+5] = 0;

	    tiles[target+5] = tiles[target];
	    tiles[target] = 0;

	    tiles[target] = tiles[target-1];
	    tiles[target-1] = 0;

	    tiles[target-1] = tiles[target+4];
	    tiles[target+4] = 0;

	    tiles[target+4] = tiles[target+5];
	    tiles[target+5] = 0;
	    
		gameDelay();
	}
	
	// Move selected tile up one and to the right one
	void upRight(int tiles[], int target)
	{		
	    tiles[target+1] = tiles[target];
	    tiles[target] = 0;

	    tiles[target] = tiles[target-5];
	    tiles[target-5] = 0;

	    tiles[target-5] = tiles[target-4];
	    tiles[target-4] = 0;

	    tiles[target-4] = tiles[target+1];
	    tiles[target+1] = 0;
	    
		gameDelay();
	}
	
	// Make the final set move for the top right two tiles
	void topRightSet(int tiles[], int target)
	{		
	    tiles[target+10] = tiles[target+9];
	    tiles[target+9] = 0;

	    tiles[target+9] = tiles[target+4];
	    tiles[target+4] = 0;

	    tiles[target+4] = tiles[target-1];
	    tiles[target-1] = 0;

	    tiles[target-1] = tiles[target];
	    tiles[target] = 0;

	    tiles[target] = tiles[target+5];
	    tiles[target+5] = 0;
	    
		gameDelay();
	}
	
	//Make the final set move for the right column bottom two tiles
	void bottomLeftSet(int tiles[], int target)
	{
	    tiles[target+1] = tiles[target-4];
	    tiles[target-4] = 0;

	    tiles[target-4] = tiles[target-5];
	    tiles[target-5] = 0;
	    
	    tiles[target-5] = tiles[target-6];
	    tiles[target-6] = 0;

	    tiles[target-6] = tiles[target-1];
	    tiles[target-1] = 0;

	    tiles[target-1] = tiles[target];
	    tiles[target] = 0;
	    
		gameDelay();
	}
	
	// Move the empty tile to the right of the selected tile
	void setEmpty(int tiles[], int target)
	{
		int emptyLoc;
		int targetLoc;
		int i = 0;
		
		emptyLoc = find(tiles, 0);
		targetLoc = find(tiles, target);
		
		while (targetLoc != emptyLoc - 1)
		{
		    gameDelay();
		    
			i++;
			if (i == 20) return;
			
			if((targetLoc % 5 == 4))
			{				
				 if(emptyLoc % 5 == 4){
					tiles[emptyLoc] = tiles[emptyLoc - 1];
					tiles[emptyLoc - 1] = 0;
					
				} 
				else if(emptyLoc % 5 == 3 && emptyLoc < targetLoc-5)
				{
					tiles[emptyLoc] = tiles[emptyLoc + 5];
					tiles[emptyLoc + 5] = 0;
					//printTiles(tiles, target);
				}
				else if(emptyLoc % 5 == 3 && emptyLoc > targetLoc)
				{
					tiles[emptyLoc] = tiles[emptyLoc - 5];
					tiles[emptyLoc - 5] = 0;
				}
				else if(emptyLoc % 5 < 3)
				{
					tiles[emptyLoc] = tiles[emptyLoc + 1];
					tiles[emptyLoc + 1] = 0;
				}
				else if(emptyLoc % 5 == 3 && emptyLoc == targetLoc - 1)
				{
					tiles[emptyLoc] = tiles[emptyLoc + 1];
					tiles[emptyLoc + 1] = 0;
				}
			}
			else
			{				
				if((emptyLoc % 5 > (targetLoc %5 + 1)) && emptyLoc < targetLoc)
				{
					tiles[emptyLoc] = tiles[emptyLoc + 5];
					tiles[emptyLoc + 5] = 0;
				} 
				else if(emptyLoc % 5 < (targetLoc %5 + 1))
				{
					tiles[emptyLoc] = tiles[emptyLoc + 1];
					tiles[emptyLoc + 1] = 0;
				} 
				else if(emptyLoc % 5 > (targetLoc %5 + 1))
				{
					tiles[emptyLoc] = tiles[emptyLoc - 1];
					tiles[emptyLoc - 1] = 0;
				}
				else if(emptyLoc % 5 == (targetLoc %5 + 1) && emptyLoc < targetLoc)
				{
					tiles[emptyLoc] = tiles[emptyLoc + 5];
					tiles[emptyLoc + 5] = 0;
				}
				else 
				{
					tiles[emptyLoc] = tiles[emptyLoc - 5];
					tiles[emptyLoc - 5] = 0;
				}
			}
			emptyLoc = find(tiles, 0);
			targetLoc = find(tiles, target);	
		}		
	}
	
	// Top right two tile set move for when the far right tile is trapped next to 
	// the previously placed tile	
	void topRightTrapped (int tiles[], int target)
	{
		tiles[ target+6 ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;

	    tiles[ target+1 ] =  tiles[ target ];
	    tiles[ target ] =  0;

	    tiles[ target ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;

	    tiles[ target+5 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+11 ];
	    tiles[ target+11 ] =  0;

	    tiles[ target+11 ] =  tiles[ target+10 ];
	    tiles[ target+10 ] =  0;

	    tiles[ target+10 ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;

	    tiles[ target+5 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;

	    tiles[ target+1 ] =  tiles[ target ];
	    tiles[ target ] =  0;

	    tiles[ target ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;

	    tiles[ target+5 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;

	    tiles[ target+1 ] =  tiles[ target ];
	    tiles[ target ] =  0;

	    tiles[ target ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;

	    tiles[ target+5 ] =  tiles[ target+10 ];
	    tiles[ target+10 ] =  0;

	    tiles[ target+10 ] =  tiles[ target+11 ];
	    tiles[ target+11 ] =  0;

	    tiles[ target+11 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;

	    tiles[ target+1 ] =  tiles[ target ];
	    tiles[ target ] =  0;

	    tiles[ target ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;
	    
		gameDelay();
	}

	// Bottom left set move for when to bottom tile is trapped next to the previously
	// placed tile
	void botLeftTrapped (int tiles[], int target)
	{
	    tiles[ target+1 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;

	    tiles[ target+5 ] =  tiles[ target ];
	    tiles[ target ] =  0;

	    tiles[ target ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;

	    tiles[ target+1 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+7 ];
	    tiles[ target+7 ] =  0;

	    tiles[ target+7 ] =  tiles[ target+2 ];
	    tiles[ target+2 ] =  0;

	    tiles[ target+2 ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;

	    tiles[ target+1 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;

	    tiles[ target+5 ] =  tiles[ target ];
	    tiles[ target ] =  0;

	    tiles[ target ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;

	    tiles[ target+1 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;

	    tiles[ target+5 ] =  tiles[ target ];
	    tiles[ target ] =  0;

	    tiles[ target ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;

	    tiles[ target+1 ] =  tiles[ target+2 ];
	    tiles[ target+2 ] =  0;

	    tiles[ target+2 ] =  tiles[ target+7 ];
	    tiles[ target+7 ] =  0;

	    tiles[ target+7 ] =  tiles[ target+6 ];
	    tiles[ target+6 ] =  0;

	    tiles[ target+6 ] =  tiles[ target+5 ];
	    tiles[ target+5 ] =  0;

	    tiles[ target+5 ] =  tiles[ target ];
	    tiles[ target ] =  0;

	    tiles[ target ] =  tiles[ target+1 ];
	    tiles[ target+1 ] =  0;
	    
		gameDelay();
	}
	
	// Final brute force moves for the last three tiles.
	void finalMoves(int tiles[])
	{
		if(tiles[18] == 24 && tiles[19] == 19 && tiles[23] == 0 && tiles[24] == 20 )
		{
			tiles[ 23 ] =  tiles[ 18 ];
		    tiles[ 18 ] =  0;
			tiles[ 18 ] =  tiles[ 19 ];
		    tiles[ 19 ] =  0;
			tiles[ 19 ] =  tiles[ 24 ];
		    tiles[ 24 ] =  0;
						
		}
		else if(tiles[18] == 20 && tiles[19] == 24 && tiles[23] == 0 && tiles[24] == 19 )
		{
			tiles[ 23 ] =  tiles[ 24 ];
		    tiles[ 24 ] =  0;
			tiles[ 24 ] =  tiles[ 19 ];
		    tiles[ 19 ] =  0;
			tiles[ 19 ] =  tiles[ 18 ];
		    tiles[ 18 ] =  0;
			tiles[ 18 ] =  tiles[ 23 ];
		    tiles[ 23 ] =  0;	
			tiles[ 23 ] =  tiles[ 24 ];
		    tiles[ 24 ] =  0;		
			
		}
		else if(tiles[18] == 0 && tiles[19] == 20 && tiles[23] == 19 && tiles[24] == 24 )
		{
			tiles[18  ] =  tiles[ 23 ];
		    tiles[ 23 ] =  0;	
			tiles[ 23 ] =  tiles[ 24 ];
		    tiles[ 24 ] =  0;						
			
		}
		else if(tiles[18] == 19 && tiles[19] == 20 && tiles[23] == 0 && tiles[24] == 24 )
		{
			tiles[ 23 ] =  tiles[ 24 ];
		    tiles[ 24 ] =  0;
		    
		}
		else if(tiles[18] == 0 && tiles[19] == 24 && tiles[23] == 20 && tiles[24] == 19 )
		{
			tiles[ 18 ] =  tiles[ 23 ];
		    tiles[ 23 ] =  0;
			tiles[ 23 ] =  tiles[ 24 ];
		    tiles[ 24 ] =  0;
			tiles[ 24 ] =  tiles[ 19 ];
		    tiles[ 19 ] =  0;
			tiles[ 19 ] =  tiles[ 18 ];
		    tiles[ 18 ] =  0;
			tiles[ 18 ] =  tiles[ 23 ];
		    tiles[ 23 ] =  0;
			tiles[ 23 ] =  tiles[ 24 ];
		    tiles[ 24 ] =  0;
		}		
		gameDelay();
	}
	
	// Method to locate the selected tile in the array. 
	int find(int tiles[], int target)
	{
	    int i;
	    for(i=0;i<25;i++)
	    {
	        if (tiles[i] == target) return i;
	    }
	    return -1;
	}
	
	// Method to provide the desired delay for variable game play
	void gameDelay()
	{
		try
		{
			Thread.sleep(delay);
		}
        catch(InterruptedException ie){
        }
	}	
	
}




