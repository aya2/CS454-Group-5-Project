package com.example.sliding_tiles;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Preferences extends Activity {
	private SharedPreferences prefer;
	private SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_preferences, menu);
        return true;
    }
    
    public void SavePref(View view) {
    	prefer = getSharedPreferences("preference", MODE_PRIVATE);
        editor = prefer.edit();
        
        //get checked radio button
    	RadioGroup sizesPic = (RadioGroup) findViewById(R.id.radioGroup1);
    	RadioGroup picAI = (RadioGroup) findViewById(R.id.RadioGroup02);
    	RadioGroup sizesNum = (RadioGroup) findViewById(R.id.RadioGroup01);
    	RadioGroup numAI = (RadioGroup) findViewById(R.id.RadioGroup02);
    	
    	int selectedPicSize = sizesPic.getCheckedRadioButtonId();
    	int selectedPicAI = picAI.getCheckedRadioButtonId();
    	int selectedNumSize = sizesNum.getCheckedRadioButtonId();
    	int selectedNumAI = numAI.getCheckedRadioButtonId();
    	
    	
    	//Save different values depending on radio button selected
        
    	//Picture Mode Sizes
        if (R.id.radio0 == selectedPicSize){
        	editor.putInt("PicModeSize", 0); //0 for picture mode 2x2
        	
    		//Intent intent = new Intent(this, PictureMode2x2.class);
    		//startActivity(intent);
    	}
    	else if (R.id.radio1 == selectedPicSize){
    		editor.putInt("PicModeSize", 1);
    		//Intent intent = new Intent(this, PictureMode3x3.class);
    		//startActivity(intent);
    	}
    	else if (R.id.radio2 == selectedPicSize){
    		editor.putInt("PicModeSize", 2);
    		//Intent intent = new Intent(this, PictureMode4x4.class);
    		//startActivity(intent);
    	}
    	else if (R.id.radio3 == selectedPicSize){
    		editor.putInt("PicModeSize", 3);
    		//Intent intent = new Intent(this, PictureMode.class);
    		//startActivity(intent);
    	}
        
        //Picture Mode AI
        if (R.id.radioOn == selectedPicAI){
        	editor.putInt("PicAI",  1); //1 for AI mode on
        }
        else {
        	editor.putInt("PicAI",  0); //0 for Ai mode off
        }
        
        //Number Mode Sizes
        if (R.id.radio4 == selectedNumSize){
        	editor.putInt("NumModeSize", 4); //0 for picture mode 2x2
        	
    	}
    	else if (R.id.radio5 == selectedNumSize){
    		editor.putInt("NumModeSize", 5);

    	}
    	else if (R.id.radio6 == selectedNumSize){
    		editor.putInt("NumModeSize", 6);

    	}
    	else if (R.id.radio7 == selectedNumSize){
    		editor.putInt("NumModeSize", 7);

    	}
        
      //Number Mode AI
        if (R.id.radioOn == selectedNumAI){
        	editor.putInt("numAI",  1); //1 for AI mode on
        }
        else {
        	editor.putInt("numAI",  0); //0 for Ai mode off
        }
        
        editor.commit();
    	
    }

    
}
