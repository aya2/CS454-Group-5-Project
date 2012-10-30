package com.example.sliding_tiles;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.support.v4.app.NavUtils;

public class PicModeMenu extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_mode_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pic_mode_menu, menu);
        return true;
    }

    public void PicModeStartGame(View view) {
    	//get checked radio button
    	RadioGroup sizes = (RadioGroup) findViewById(R.id.radioGroup1);
    	int selected = sizes.getCheckedRadioButtonId();
    	
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
    	else{
    		Intent intent = new Intent(this, PictureMode.class);
    		startActivity(intent);
    	}
    		
    }
}