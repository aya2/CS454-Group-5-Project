package com.example.sliding_tiles;



import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MathImageAdapter extends BaseAdapter
{

	private Context mContext;

    public MathImageAdapter(Context c) 
    {
        mContext = c;
    }
    

	public int getCount() 
	{
		return boardArray.length;
	}


	public Object getItem(int position) 
	{
		return null;
	}


	public long getItemId(int position) 
	{
		return 0;
	}


	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0,0,0,0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[boardArray[position]]);//[position]);//[boardArray[position]]);
        return imageView;
	}
	
	public void updateBoard(int selected)
	{
		boolean swap = false;
		
		//double check selected is in bounds
		if(selected < 0 || selected > boardArray.length)
			return;
		
		//check if selected is in one of the 4 legal positions in relation to the blank to allow the switch
		int blankLocation = findBlank();
		
		//check if selected is special boundary case and deal with accordingly
		if(selected == 5 || selected == 10 || selected == 15 || selected == 20)//selected along left edge
		{
			if(blankLocation == selected + 5 || blankLocation == selected - 5 || blankLocation == selected + 1)
				swap = true;
		}
		else if(selected == 4 || selected == 9 || selected == 14 || selected == 19)//selected along right edge
		{
			if(blankLocation == selected + 5 || blankLocation == selected - 5 || blankLocation == selected - 1)
				swap = true;
		}
		else//selected in normal position
		{
			
			if(blankLocation == selected + 5 || blankLocation == selected - 5 || blankLocation == selected -1 || 
																						blankLocation == selected + 1)
				swap = true;
			
		}
		
		//swap if legal move
		if(swap == true)
		{
			//swap positions of the selected tile and the blank tile
			int temp = boardArray[selected];
			boardArray[selected] = 28;
			boardArray[blankLocation] = temp;
		}
		
		
	}
	
	public int findBlank()
	{
		for(int i = 0;i < boardArray.length;i++)
		{
			if(boardArray[i] == 28)
				return i;
		}
		
		return 0;
	}
	
	private Integer[] mThumbIds =
	{
		R.drawable.tile1,
		R.drawable.tile2,
		R.drawable.tile3,
		R.drawable.tile4,
		R.drawable.tile5,
		R.drawable.tile6,
		R.drawable.tile7,
		R.drawable.tile8,
		R.drawable.tile9,
		R.drawable.tile10,
		R.drawable.tile11,
		R.drawable.tile12,
		R.drawable.tile13,
		R.drawable.tile14,
		R.drawable.tile15,
		R.drawable.tile16,
		R.drawable.tile17,
		R.drawable.tile18,
		R.drawable.tile19,
		R.drawable.tile20,
		R.drawable.tile21,
		R.drawable.tile22,
		R.drawable.tile23,
		R.drawable.tile24,
		R.drawable.tile_equal,
		R.drawable.tile_plus,
		R.drawable.tile_minus,
		R.drawable.tile_multiply,
		R.drawable.tileempty1
	};
	
	private Integer[] boardArray =
	{
			11,25,0,24,12,1,24,20,21,15,2,3,28,6,22,7,23,27,19,26,8 ,10 ,11 ,14 ,22
	};
}