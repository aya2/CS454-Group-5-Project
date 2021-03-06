package com.example.sliding_tiles;

import java.util.Random;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return board.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
    	
    	return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }
        
        //shuffleArray();

        imageView.setImageResource(mThumbIds[board[position]]);
        return imageView;
    }
    
    public void shuffleArray(){
    	Random rnd = new Random();
        for (int i = 50; i >= 0; i--)
        {
          int index = rnd.nextInt(4);
          int blank = findBlank();
          moveBoard(blank-index);
          moveBoard(blank+index);
          moveBoard(blank+index);
          moveBoard(blank+5);
          moveBoard(blank-5);
          //moveBoard(index);
          //moveBoard(blank+5);
     
          //moveBoard(blank+1);
          // Simple swap
          //int a = board[index];
          //board[index] = board[i];
          //board[i] = a;
        }
      }
    
    public void moveBoard(int selected)
	{
		
		
		//double check selected is in bounds
		if(selected < 0 || selected > board.length)
			return;
		
		//check if selected is in one of the 4 legal positions in relation to the blank to allow the switch
		int blankLocation = findBlank();
		
		//check if selected is special boundary case and deal with accordingly
		if(selected == 5 || selected == 10 || selected == 15 || selected == 20)//selected along left edge
		{
			if(blankLocation == selected + 5 || blankLocation == selected - 5 || blankLocation == selected + 1)
				
				swap(blankLocation,selected);
		}
		else if(selected == 4 || selected == 9 || selected == 14 || selected == 19)//selected along right edge
		{
			if(blankLocation == selected + 5 || blankLocation == selected - 5 || blankLocation == selected - 1)
			
				swap(blankLocation,selected);
		}
		else//selected in normal position
		{
			
			if(blankLocation == selected + 5 || blankLocation == selected - 5 || blankLocation == selected -1 || 
																						blankLocation == selected + 1)
				
				swap(blankLocation,selected);
			
		}
		//Multiple swaps
		
		if(blankLocation == selected-2){
			if( selected != 0 && selected != 5 && selected != 10 && selected != 15 && selected != 20 && selected-1 != 0 && selected-1 != 5 && selected-1 != 10 && selected-1 != 15 && selected-1 != 20){
			swap(blankLocation,selected-1);
			swap(selected-1,selected);
			}
		}
		if(blankLocation == selected-3){
			if( selected != 0 && selected != 5 && selected != 10 && selected != 15 && selected != 20 && selected-1 != 0 && selected-1 != 5 && selected-1 != 10 && selected-1 != 15 && selected-1 != 20 && selected-2 != 0 && selected-2 != 5 && selected-2 != 10 && selected-2 != 15 && selected-2 != 20){
			swap(blankLocation,selected-2);
			swap(selected-2,selected-1);
			swap(selected-1,selected);
			}
		}
		if(blankLocation == selected-4){
			if( selected != 0 && selected != 5 && selected != 10 && selected != 15 && selected != 20 && selected-1 != 0 && selected-1 != 5 && selected-1 != 10 && selected-1 != 15 && selected-1 != 20 && selected-2 != 0 && selected-2 != 5 && selected-2 != 10 && selected-2 != 15 && selected-2 != 20 && selected-3 != 0 && selected-3 != 5 && selected-3 != 10 && selected-3 != 15 && selected-3 != 20){
			swap(blankLocation,selected-3);
			swap(selected-3,selected-2);
			swap(selected-2,selected-1);
			swap(selected-1,selected);
			}
		}
		if(blankLocation == selected-10){
			swap(blankLocation,selected-5);
			swap(selected-5,selected);
		}
		if(blankLocation == selected-15){
			swap(blankLocation,selected-10);
			swap(selected-10,selected-5);
			swap(selected-5,selected);
		}
		if(blankLocation == selected-20){
			swap(blankLocation,selected-15);
			swap(selected-15,selected-10);
			swap(selected-10,selected-5);
			swap(selected-5,selected);
		}
		if(blankLocation == selected+2){
			if( selected != 4 && selected != 9 && selected != 14 && selected != 19 && selected != 24 && selected+1 != 4 && selected+1 != 9 && selected+1 != 14 && selected+1 != 19 && selected+1 != 24){
			swap(blankLocation,selected+1);
			swap(selected+1,selected);
			}
		}
		if(blankLocation == selected+3){
			if( selected != 4 && selected != 9 && selected != 14 && selected != 19 && selected != 24 && selected+1 != 4 && selected+1 != 9 && selected+1 != 14 && selected+1 != 19 && selected+1 != 24 && selected+2 != 4 && selected+2 != 9 && selected+2 != 14 && selected+2 != 19 && selected+2 != 24){
			swap(blankLocation,selected+2);
			swap(selected+2,selected+1);
			swap(selected+1,selected);
			}
		}
		if(blankLocation == selected+4){
			if( selected != 4 && selected != 9 && selected != 14 && selected != 19 && selected != 24 && selected+1 != 4 && selected+1 != 9 && selected+1 != 14 && selected+1 != 19 && selected+1 != 24 && selected+2 != 4 && selected+2 != 9 && selected+2 != 14 && selected+2 != 19 && selected+2 != 24 && selected+3 != 4 && selected+3 != 9 && selected+3 != 14 && selected+3 != 19 && selected+3 != 24){
			swap(blankLocation,selected+3);
			swap(selected+3,selected+2);
			swap(selected+2,selected+1);
			swap(selected+1,selected);
			}
		}
		if(blankLocation == selected+10){
			swap(blankLocation,selected+5);
			swap(selected+5,selected);
		}
		if(blankLocation == selected+15){
			swap(blankLocation,selected+10);
			swap(selected+10,selected+5);
			swap(selected+5,selected);
		}
		if(blankLocation == selected+20){
			swap(blankLocation,selected+15);
			swap(selected+15,selected+10);
			swap(selected+10,selected+5);
			swap(selected+5,selected);
		}
	}
    
    public void swap(int blank, int selected){
    	
    	int temp = board[selected];
		board[selected] = 24;
		board[blank] = temp;
    }
	
	public int findBlank()
	{
		for(int i = 0;i < board.length;i++)
		{
			if(board[i] == 24)
				return i;
		}
		
		return 0;
	}

	public Integer[] mThumbIds = {
            R.drawable.tile1, R.drawable.tile2,
            R.drawable.tile3, R.drawable.tile4,
            R.drawable.tile5, R.drawable.tile6,
            R.drawable.tile7, R.drawable.tile8,
            R.drawable.tile9, R.drawable.tile10,
            R.drawable.tile11, R.drawable.tile12,
            R.drawable.tile13, R.drawable.tile14,
            R.drawable.tile15, R.drawable.tile16,
            R.drawable.tile17, R.drawable.tile18,
            R.drawable.tile19, R.drawable.tile20,
            R.drawable.tile21, R.drawable.tile22,
            R.drawable.tile23, R.drawable.tile24,
            R.drawable.tileempty1,
    };
    // references to our images
    public Integer[] board = {
    		0,1,2,3,4,5,6,7,8,9,10,11,24,12,13,14,15,16,17,18,19,20,21,22,23
 
    };
    
    public Integer[] boardRefOne = {
    		0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24
 
    };
    
    public Integer[] boardRefTwo = {
    		24,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23
 
    };
    public int checkGameOver(){
    	int i;
    	if(board[0]==0){
    		for(i=0;i<25;i++){
        		if(mThumbIds[board[i]]==mThumbIds[boardRefOne[i]] || mThumbIds[board[i]]==mThumbIds[boardRefTwo[i]] ){
        			
        		}
        		else
        			return 1;
        		
        	}
        	
       
    	}
    	else
    		return 1;

    	return 0;
    	
    }
}