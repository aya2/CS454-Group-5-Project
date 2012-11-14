	package com.example.sliding_tiles;

//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Instrumentation;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
//import android.widget.TextView;


public class NumberMode extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_mode);
        
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        final ImageAdapter i = new ImageAdapter(this);
        final AlertDialog.Builder b = new AlertDialog.Builder(this);
       // final TextView textView = new TextView(this);
        gridview.setAdapter(i);
       // i.shuffleArray();
        
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
            		        Intent myIntent = new Intent(((Dialog) dialog).getContext(), NumberMode.class);
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
        		   //Context context = getApplicationContext();
        		   //CharSequence text = "Game Over";
        		   //int duration = Toast.LENGTH_SHORT;

        		   //Toast toast = Toast.makeText(context, text, duration);
        		   //toast.show();
        		   /*try {
   					Thread.sleep(5000);
   					} 
        		   catch (InterruptedException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   					
   				}*/
        		   //finish();
        		   
        	   }
              
               i.notifyDataSetChanged();
               
         }

           
        });
        
        
        final GridView gridview1 = (GridView) findViewById(R.id.gridview1);
        final ImageAdapterAI i1 = new ImageAdapterAI(this);
        gridview1.setAdapter(i1);
        
       final TilesAI AI = new TilesAI();
       
       
       new Thread(new Runnable() {         
           public void run() {
               
        	   int done;
        	   done = AI.solveAI(i1.board, 1);
              if(done == 1){
        	   b.setIcon(android.R.drawable.ic_dialog_alert);
          	   b.setTitle("YOU LOSE!");
          	   b.setMessage("Do you want to play again?");
          	 b.setPositiveButton("Yes",new DialogInterface.OnClickListener() {  
       		    public void onClick(DialogInterface dialog, int which) { 
       		        Intent myIntent = new Intent(((Dialog) dialog).getContext(), PictureMode.class);
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
           }
       }).start(); 
        
       //send 100 key 0 presses, display if there is any change in the i1.board array updated 
       //by the AI
       new Thread(new Runnable() {         
            public void run() {
                try {
                
                Instrumentation inst = new Instrumentation();
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT);
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                for ( int j = 0; j < 100; j++ ) {
                    inst.sendKeyDownUpSync(KeyEvent.KEYCODE_0);
                    
        
                    
                    Thread.sleep(1000);
                }
                } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                finally{}
               // catch(InterruptedException e){
                //}
            }   
        }).start(); 
        
    
     
        gridview1.setOnKeyListener(new OnKeyListener() {
        	public boolean onKey(View v, int keyCode, KeyEvent event) {
        			
        		if(keyCode == 4){
        			
        		}
        		
        		else{
        				//i1.shuffleArray();
                		i1.notifyDataSetChanged();
        		}
                		
                		
        			
        				
        			
				return false;
        	
        	}
        	
        });
        
    }

 
   

}
