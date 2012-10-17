package com.example.sliding_tiles;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Instructions extends Activity {
	
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        TextView textView = new TextView(this);
	        textView.setTextSize(10);
	        textView.setText("Instructions for the game\n\n\n\n1.Math Mode\n\nYou can define basic mathematical equations using digits 0-9 and the addition, subtraction, multiplication and division operators.\nYou can form equations by moving tiles around the board and generate atleast one equation on the board.\nEquations can be formed horizontally, either from left to right or from right to left.\nEquations can be formed vertically, either from top to bottom or from bottom to top.\nEach equation must include one binary operator (+, -, x) and an equal sign (Ò=Ó).\nThese are not accepted.\nNo binary operator, e.g. 8=8 and 54=54.\nNo negative number, Ò-Ó is a binary operator in this game, - 6 = - 6 is not valid\n\n\n\n2.Number Mode\n\n Use the mouse to arrange the numbered tiles on the board. Fixed tiles be moved!Make sure you complete the puzzle by arranging numbers sequentially in ascending order.\n\n\n\n3.Picture Mode\n\nA jumbled picture is presented to you. Rearrange the pictures to get the correct original picture by moving the tiles. Move the tiles around to see the final picture.\n\n\n\nGo Back and PLAY!!!");
	        // Set the text view as the activity layout
	        setContentView(textView);
	    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_instructions, menu);
        return true;
    }
}
