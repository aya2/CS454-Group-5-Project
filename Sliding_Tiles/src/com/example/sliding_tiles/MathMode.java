package com.example.sliding_tiles;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MathMode extends Activity 
{

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_math_mode);

		//create gridview and match it to gridView created in xml
		GridView gridview = (GridView) findViewById(R.id.gridView1);

		//create adapter from adapter extended class
		final MathImageAdapter mathadapter = new MathImageAdapter(this);

		//set the adapter for the gridview
		gridview.setAdapter(mathadapter);

		//set the on-click listener for the gridview
		gridview.setOnItemClickListener(new OnItemClickListener()
		{
			//when a tile is clicked
			public void onItemClick(AdapterView<?> parent, View v, int position, long id)
			{
				//call the update board function to check and see if it is a legal move and move if so
				mathadapter.updateBoard(position);
				
				//updated the gui
				mathadapter.notifyDataSetChanged();
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.activity_math_mode, menu);
		return true;
	}


}
