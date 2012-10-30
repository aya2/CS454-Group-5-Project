package com.example.sliding_tiles;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.support.v4.app.NavUtils;

public class PictureMode3x3 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_mode3x3);
        
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        final ImageAdapter3x3 i = new ImageAdapter3x3(this);
        final AlertDialog.Builder b = new AlertDialog.Builder(this);
        gridview.setAdapter(i);
        
        ImageView image = (ImageView) findViewById(R.id.test_image);
        image.setImageResource(R.drawable.teddybearfinished1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_picture_mode3x3, menu);
        return true;
    }

    
}
