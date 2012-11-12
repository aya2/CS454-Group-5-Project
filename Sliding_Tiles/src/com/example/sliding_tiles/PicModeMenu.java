package com.example.sliding_tiles;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class PicModeMenu extends Activity {
	private SharedPreferences prefer;
	private SharedPreferences.Editor editor;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_mode_menu);
        prefer = getSharedPreferences("preference", MODE_PRIVATE);
        editor = prefer.edit();
    	editor.putInt("PicModeSize", 3); //default the picture mode size to 5x5
    	editor.putInt("NumModeSize", 7); //default the number mode size to 5x5
    	editor.putInt("picAI", 0); //default the picture mode AI to off
    	editor.putInt("numAI", 0); //default the number mode AI to off
    	editor.commit(); //save changes
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pic_mode_menu, menu);
        return true;
    }

    public void PicModeStartGame(View view) {
    	//get checked radio button
    	//RadioGroup sizes = (RadioGroup) findViewById(R.id.radioGroup1);
    	//int selected = sizes.getCheckedRadioButtonId();
    	prefer = getSharedPreferences("preference", MODE_PRIVATE);
    	int selected = prefer.getInt("PicModeSize", 0);
    	
    	//Open different size games depending on radio button selected
    	if (R.id.radio0 == selected){
    		Intent intent = new Intent(this, PictureMode2x2.class);
    		startActivity(intent);
    	}
    	else if (R.id.radio1 == selected){
    		Intent intent = new Intent(this, PictureMode3x3.class);
    		startActivity(intent);
    	}
    	else if (R.id.radio2 == selected){
    		Intent intent = new Intent(this, PictureMode4x4.class);
    		startActivity(intent);
    	}
    	else if (R.id.radio3 == selected){
    		Intent intent = new Intent(this, PictureMode.class);
    		startActivity(intent);
    	}
    		
    }
}
