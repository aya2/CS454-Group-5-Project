package com.example.sliding_tiles;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class NumberMode2x2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_mode2x2);
         
            final GridView gridview = (GridView) findViewById(R.id.gridview);
            final ImageAdapterNumber2x2 i = new ImageAdapterNumber2x2(this);
            final AlertDialog.Builder b = new AlertDialog.Builder(this);
            gridview.setAdapter(i);
            i.shuffleArray();
            
            //i.shuffleArray();
            gridview.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                   
                	i.moveBoard(position);
                    int result = i.checkGameOver();
                    if (result==0){
             		   //display game over
                    
                    	 b.setIcon(android.R.drawable.ic_dialog_alert);
                  	   b.setTitle("YOU WIN!");
                  	   b.setMessage("Do you want to play again?");
                  	   b.setPositiveButton("Yes",new DialogInterface.OnClickListener() {  
                  		    public void onClick(DialogInterface dialog, int which) { 
                  		        Intent myIntent = new Intent(((Dialog) dialog).getContext(), NumberMode2x2.class);
                  		        startActivity(myIntent);    
                  		        return;  
                  		        }        
                  		    });      
                  	   b.setNegativeButton("No", new DialogInterface.OnClickListener() {  
                  		    public void onClick(DialogInterface dialog, int which) { 
                  		        Intent myIntent = new Intent(((Dialog) dialog).getContext(), GameMenu.class);
                  		        startActivity(myIntent);    
                  		        return;  
                  		        }        
                  		    });      
                  	   b.show();
             	   }
                   
                   i.notifyDataSetChanged();   
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_number_mode2x2, menu);
        return true;
    }

    
}
