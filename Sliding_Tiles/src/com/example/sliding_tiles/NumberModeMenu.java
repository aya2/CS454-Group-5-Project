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

public class NumberModeMenu extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_mode_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_number_mode_menu, menu);
        return true;
    }

    public void PicModeStartGame(View view) {
    	//get checked radio button
    	RadioGroup sizes = (RadioGroup) findViewById(R.id.radioGroup2);
    	int selected = sizes.getCheckedRadioButtonId();
    	
    	//Open different size games depending on radio button selected
    	if (R.id.radio4 == selected){
    		Intent intent = new Intent(this, NumberMode2x2.class);
    		startActivity(intent);
    	}
    	else if (R.id.radio5 == selected){
    		Intent intent = new Intent(this, NumberMode3x3.class);
    		startActivity(intent);
    	}
    	else if (R.id.radio6 == selected){
    		Intent intent = new Intent(this, NumberMode4x4.class);
    		startActivity(intent);
    	}
    	else if (R.id.radio7 == selected) {
    		Intent intent = new Intent(this, NumberMode.class);
    		startActivity(intent);
    	}
    		
    }
}
