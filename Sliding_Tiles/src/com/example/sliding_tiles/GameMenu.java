// Sliding Tiles Game

package com.example.sliding_tiles;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class GameMenu extends Activity {
	private SharedPreferences.Editor editor;
	private SharedPreferences prefer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        
        
        //set default sizes
        prefer = getSharedPreferences("preference", MODE_PRIVATE);
        editor = prefer.edit();
        
        editor.putInt("NumModeSize", 7);
        editor.putInt("PicModeSize", 3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game_menu, menu);
        return true;
    }
    
    /*Called when user clicks Math Mode Button*/
    public void OpenMathMode(View view) {
    	Intent intent = new Intent(this, MathMode.class);
    	startActivity(intent);
    }
    
    //called when user clicks Number mode
    public void OpenNumberMode(View view)
    {
    	//Intent intent = new Intent(this, MathMode.class);
    	//startActivity(intent);
    	
    	 prefer = getSharedPreferences("preference", MODE_PRIVATE);
         int selectedNum = prefer.getInt("NumModeSize", 0);
         	
         //Open different size games depending on radio button selected
         if (4 == selectedNum){
         	Intent intent = new Intent(this, NumberMode2x2.class);
         	startActivity(intent);
         }
         else if (5 == selectedNum){
         	Intent intent = new Intent(this, NumberMode3x3.class);
         	startActivity(intent);
         }
         else if (6 == selectedNum){
         	Intent intent = new Intent(this, NumberMode4x4.class);
         	startActivity(intent);
         }
         else if (7 == selectedNum){
         	Intent intent = new Intent(this, NumberMode.class);
         	startActivity(intent);        		
         }
    	
    }
    
    public void OpenPictureMode(View view)
    {
    	//Intent intent = new Intent(this, PicModeMenu.class);
    	//startActivity(intent);
    	
        //get checked radio button
        //RadioGroup sizes = (RadioGroup) findViewById(R.id.radioGroup1);
        //int selected = sizes.getCheckedRadioButtonId();
        prefer = getSharedPreferences("preference", MODE_PRIVATE);
        int selected = prefer.getInt("PicModeSize", 0);
        	
        //Open different size games depending on radio button selected
        if (0 == selected){
        	Intent intent = new Intent(this, PictureMode2x2.class);
        	startActivity(intent);
        }
        else if (1 == selected){
        	Intent intent = new Intent(this, PictureMode3x3.class);
        	startActivity(intent);
        }
        else if (2 == selected){
        	Intent intent = new Intent(this, PictureMode4x4.class);
        	startActivity(intent);
        }
        else if (3 == selected){
        	Intent intent = new Intent(this, PictureMode.class);
        	startActivity(intent);        		
        }
    }
    
    public void OpenInstructions(View view)
    {
    	Intent intent = new Intent(this, Instructions.class);
    	startActivity(intent);
    }
    
    public void OpenPref(View view)
    {
    	Intent intent = new Intent(this, Preferences.class);
    	startActivity(intent);
    }

    
}
