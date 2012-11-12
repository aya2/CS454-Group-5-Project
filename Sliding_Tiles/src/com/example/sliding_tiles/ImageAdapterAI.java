package com.example.sliding_tiles;

import java.util.Random;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterAI extends BaseAdapter {
    private Context mContext;

    public ImageAdapterAI(Context c) {
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
            imageView.setLayoutParams(new GridView.LayoutParams(35, 35));
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
        for (int i = 23; i >= 0; i--)
        {
          int index = rnd.nextInt(i+1);
          
         
          int a = board[index];
          board[index] = board[i];
          board[i] = a;
        }
       // board[15]=24;
    	
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
    
      
}