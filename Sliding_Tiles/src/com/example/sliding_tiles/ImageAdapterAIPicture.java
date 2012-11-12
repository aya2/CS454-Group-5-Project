package com.example.sliding_tiles;

import java.util.Random;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterAIPicture extends BaseAdapter {
    private Context mContext;

    public ImageAdapterAIPicture(Context c) {
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
			R.drawable.pictureempty,
			R.drawable.guineapig1, R.drawable.guineapig2,
            R.drawable.guineapig3, R.drawable.guineapig4,
            R.drawable.guineapig5, R.drawable.guineapig6,
            R.drawable.guineapig7, R.drawable.guineapig8,
            R.drawable.guineapig9, R.drawable.guineapig10,
            R.drawable.guineapig11, R.drawable.guineapig12,
            R.drawable.guineapig13, R.drawable.guineapig14,
            R.drawable.guineapig15, R.drawable.guineapig16,
            R.drawable.guineapig17, R.drawable.guineapig18,
            R.drawable.guineapig19, R.drawable.guineapig20,
            R.drawable.guineapig21, R.drawable.guineapig22,
            R.drawable.guineapig23, R.drawable.guineapig24
            
    };
    // references to our images
    public int[] board = {
    		1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,0,24
 
    };
    
    
    
}