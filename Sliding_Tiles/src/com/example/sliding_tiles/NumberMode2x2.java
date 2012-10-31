package com.example.sliding_tiles;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.support.v4.app.NavUtils;

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
            
            //ImageView image = (ImageView) findViewById(R.id.test_image);
            //image.setImageResource(R.drawable.soccerballfinished1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_number_mode2x2, menu);
        return true;
    }

    
}
