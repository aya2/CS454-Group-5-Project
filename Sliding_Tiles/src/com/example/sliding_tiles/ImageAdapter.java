package com.example.sliding_tiles;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    
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

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
    	
    	ImageAdapter i1 = new ImageAdapter(mContext);
        return i1.mThumbIds[position];
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

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    public Integer[] mThumbIdsMain = {
            mThumbIds[0], mThumbIds[1],
            mThumbIds[2], mThumbIds[3],
            mThumbIds[4], mThumbIds[5],
            mThumbIds[6], mThumbIds[7],
            mThumbIds[8], mThumbIds[9],
            mThumbIds[10], mThumbIds[11],
            mThumbIds[12], mThumbIds[13],
            mThumbIds[14], mThumbIds[15],
            mThumbIds[16], mThumbIds[17],
            mThumbIds[18], mThumbIds[19],
            mThumbIds[20], mThumbIds[21],
            mThumbIds[22], mThumbIds[23],
            mThumbIds[24],0,
           
    };
}