package com.example.sliding_tiles;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.support.v4.app.NavUtils;

public class PictureMode4x4 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_mode4x4);
        
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        final ImageAdapter4x4 i = new ImageAdapter4x4(this);
        final AlertDialog.Builder b = new AlertDialog.Builder(this);
        gridview.setAdapter(i);
        
        ImageView image = (ImageView) findViewById(R.id.test_image);
        image.setImageResource(R.drawable.carfinished1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_picture_mode4x4, menu);
        return true;
    }

    
}
