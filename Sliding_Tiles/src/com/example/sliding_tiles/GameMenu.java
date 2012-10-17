package com.example.sliding_tiles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class GameMenu extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game_menu, menu);
        return true;
    }
    
    /*Called when user clicks Number Button*/
    public void OpenNumberMode(View view) {
    	Intent intent = new Intent(this, NumberMode.class);
    	startActivity(intent);
    }
    
    //called when user clicks math mode
    public void OpenMathMode(View view)
    {
    	Intent intent = new Intent(this, MathMode.class);
    	startActivity(intent);
    }
    
    public void OpenPictureMode(View view)
    {
    	Intent intent = new Intent(this, PictureMode.class);
    	startActivity(intent);
    }
    
    public void OpenInstructions(View view)
    {
    	Intent intent = new Intent(this, Instructions.class);
    	startActivity(intent);
    }

    
}
