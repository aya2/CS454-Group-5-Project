package com.example.sliding_tiles;

import java.util.Random;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter3x3 extends BaseAdapter {
    private Context mContext;

    public ImageAdapter3x3(Context c) {
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
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[board[position]]);
        return imageView;
    }
    
    
    public void moveBoard(int selected)
	{
		
		
		//double check selected is in bounds
		if(selected < 0 || selected > board.length)
			return;
		
		//check if selected is in one of the 4 legal positions in relation to the blank to allow the switch
		int blankLocation = findBlank();
		
		if((blankLocation == selected+1) || blankLocation == selected-1 || (blankLocation == selected+5) || blankLocation == selected-5) {
			swap(blankLocation,selected);
		}
		/*
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
			
		}*/
		//Multiple swaps
		
		if(blankLocation == selected-2){
			
			swap(blankLocation,selected-1);
			swap(selected-1,selected);
			
		}
		/*if(blankLocation == selected-3){
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
		}*/
		if(blankLocation == selected-10){
			swap(blankLocation,selected-5);
			swap(selected-5,selected);
		}
		
		if(blankLocation == selected+2){
			swap(blankLocation,selected+1);
			swap(selected+1,selected);
		}
		
		if(blankLocation == selected+10){
			swap(blankLocation,selected+5);
			swap(selected+5,selected);
		}
		
	}
    
    public void swap(int blank, int selected){
    	
    	int temp = board[selected];
		board[selected] = 18;
		board[blank] = temp;
    }
	
	public int findBlank()
	{
		for(int i = 0;i < board.length;i++)
		{
			if(board[i] == 18)
				return i;
		}
		
		return 0;
	}
 // references to our images
    public Integer[] mThumbIds = {
    		R.drawable.transparent, R.drawable.transparent,
            R.drawable.transparent, R.drawable.transparent,
            R.drawable.transparent, R.drawable.transparent, 
            R.drawable.teddybear1,
            R.drawable.teddybear2, R.drawable.teddybear3,
            R.drawable.transparent, R.drawable.transparent,
            R.drawable.teddybear4, R.drawable.teddybear5,
            R.drawable.teddybear6, R.drawable.transparent,
            R.drawable.transparent, R.drawable.teddybear7,
            R.drawable.teddybear8, R.drawable.pictureempty,
            R.drawable.transparent, R.drawable.transparent,
            R.drawable.transparent, R.drawable.transparent,
            R.drawable.transparent, R.drawable.transparent,
            
    };
    
    public Integer[] board = {
    		0,1,2,3,4,5,6,18,8,9,10,11,7,13,14,15,16,12,17,19,20,21,22,23,24
 
    };
    
    public Integer[] boardRef = {
    		0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24
 
    };
    
    public int checkGameOver(){
    	int i;
    	if(board[0]==0){
    		for(i=0;i<25;i++){
        		if(mThumbIds[board[i]]==mThumbIds[boardRef[i]]){
        			
        		}
        		else
        			return 1;
        		
        	}
        	
       
    	}
    	else
    		return 1;
    	
    	return 0;
    	
    }
    
    public void shuffleArray(){
    	Random rnd = new Random();
        for (int i = 23; i >= 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          moveBoard(index);
        }
      }
}