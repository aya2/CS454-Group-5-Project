package com.example.sliding_tiles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class NumberMode extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_mode);
        
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        final ImageAdapter i = new ImageAdapter(this);
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
               
               if(0 < position-5 || position-5 == 0) {
            	   if(i.mThumbIds[position-5]==i.mThumbIdsMain[24]) {
            		   i.mThumbIdsMain[25]=i.mThumbIds[position-5];
            		   i.mThumbIds[position-5]=i.mThumbIds[position];
            		   i.mThumbIds[position]=i.mThumbIdsMain[25];
            		   
            	   	}
               }
               
               if(position+5 < 24 || position+5 == 24) {
            	   if(i.mThumbIds[position+5]==i.mThumbIdsMain[24]) {
            		   i.mThumbIdsMain[25]=i.mThumbIds[position+5];
            		   i.mThumbIds[position+5]=i.mThumbIds[position];
            		   i.mThumbIds[position]=i.mThumbIdsMain[25];
            		   
            	   }
               }
            	 
               if( (position != 4) && (position != 9) && (position != 14) && (position != 19) && (position != 24)) {
	               if( position+1 < 24 || position+1 == 24) {
	            	   if(i.mThumbIds[position+1]==i.mThumbIdsMain[24]) {
	            		   i.mThumbIdsMain[25]=i.mThumbIds[position+1];
	            		   i.mThumbIds[position+1]=i.mThumbIds[position];
	            		   i.mThumbIds[position]=i.mThumbIdsMain[25];
	            		   
	            	   }
	               }
               }
               
               if( position != 0 && position != 5 && position != 10 && position != 15 && position != 20) {
	               if(0 < position-1 || position-1 == 0) {
	            	   if(i.mThumbIds[position-1]==i.mThumbIdsMain[24]) {
	            		   i.mThumbIdsMain[25]=i.mThumbIds[position-1];
	            		   i.mThumbIds[position-1]=i.mThumbIds[position];
	            		   i.mThumbIds[position]=i.mThumbIdsMain[25];
	            		  
            	   }
	            }
            }
               
               i.notifyDataSetChanged();
               gridview.setAdapter(i);
               gridview.invalidateViews();   
            }
        });
        
    }

 
   

}
