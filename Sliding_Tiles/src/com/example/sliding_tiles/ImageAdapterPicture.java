package com.example.sliding_tiles;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterPicture extends BaseAdapter {
    private Context mContext;
    
    public Integer[] mThumbIds = {
            R.drawable.picture11, R.drawable.picture20,
            R.drawable.picture01, R.drawable.picture22,
            R.drawable.picture05, R.drawable.picture16,
            R.drawable.picture13, R.drawable.picture24,
            R.drawable.picture15, R.drawable.picture06,
            R.drawable.picture17, R.drawable.picture08,
            R.drawable.picture07, R.drawable.picture18,
            R.drawable.picture03, R.drawable.picture10,
            R.drawable.picture09, R.drawable.picture04,
            R.drawable.picture21, R.drawable.picture02,
            R.drawable.picture23, R.drawable.picture14,
            R.drawable.picture19, R.drawable.picture12,
            R.drawable.pictureempty,
    };

    public ImageAdapterPicture(Context c) {
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