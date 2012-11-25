package com.example.sliding_tiles;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MathMode extends Activity implements OnGesturePerformedListener	
{

	//gesture library
	private GestureLibrary gestureLibrary;

	//gesture listeners
	private GestureDetector gestureDetector;

	//textView for score
	private TextView score;
	
	//textView for message
	private TextView validMessage;
	
	//pop up window
	private PopupWindow popWin;
	
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

		//setup the textView for the score
		//Resources res = getResources(); 
		//Drawable shape = res.getDrawable(R.drawable.blanktile);
		
		//TextView tv = (TextView)findViewById(R.id.textView3);
		score = (TextView) findViewById(R.id.textView3);
		//score.setBackgroundDrawable(shape);
		
		//set up the textView for the valid/invalid message
		validMessage = (TextView)findViewById(R.id.textView1);
		//set to invisible
		validMessage.setVisibility(validMessage.INVISIBLE);
		
		//set the on-click listener for the gridview
		gridview.setOnItemClickListener(new OnItemClickListener()
		{
			//when a tile is clicked
			public void onItemClick(AdapterView<?> parent, View v, int position, long id)
			{
				//Toast.makeText(v.getContext(),"position: " + position + " has been clicked", Toast.LENGTH_LONG).show();
				
				//hide the valid message
				validMessage.setVisibility(validMessage.INVISIBLE);
				
				//call the update board function to check and see if it is a legal move and move if so
				mathadapter.updateBoard(position);
				
				//updated the gui
				mathadapter.notifyDataSetChanged();
			}
		});

		gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
		if(!gestureLibrary.load())
			finish();

		//gesture overlay
		GestureOverlayView gestures = (GestureOverlayView)findViewById(R.id.gestures);
		gestures.addOnGesturePerformedListener(this);

	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.activity_math_mode, menu);
		return true;
	}

	//handle the gestures
	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture)
	{
		ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
		for (Prediction prediction : predictions)
		{
			if (prediction.score > 8)//(predictions.size() > 0 && predictions.get(0).score > 4.0) 
			{
				//String result = prediction.name;
				//Toast.makeText(this, result + "score =  " + prediction.score, Toast.LENGTH_LONG).show();
				
				//show the message
				//validMessage.setVisibility(validMessage.VISIBLE);
				
				//call pop up window
				initiatePopupWindow();
				//update the score
				score.setText("3");
			}
		}
	}//end of on gesture performed
	
	//pop up window stuff
	private void initiatePopupWindow() 
	{
	    try 
	    {
	       
	        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        //Inflate the view from a predefined XML layout
	        View layout = inflater.inflate(R.layout.popup,(ViewGroup) findViewById(R.id.popupEl));
	        // create a 300px width and 470px height PopupWindow
	        popWin = new PopupWindow(layout, 300, 470, true);
	        
	        popWin.setBackgroundDrawable(new BitmapDrawable());
	        popWin.setOutsideTouchable(true);
	        //popWin.showAsDropDown(btnSelectWeight);
	        // display the popup in the center
	        popWin.showAtLocation(layout, Gravity.CENTER, 0, 0);
	 
	       // mResultText = (TextView) layout.findViewById(R.id.server_status_text);
	        Button returnButton = (Button) layout.findViewById(R.id.returnButton);
	        //makeBlack(returnButton);
	        
	       
	        returnButton.setOnClickListener(returnListener);
	 
	    } catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	}
	 
	private OnClickListener returnListener = new OnClickListener()
	{
	    public void onClick(View v) 
	    {
	    	//Toast.makeText(v.getContext(), "click registerd", Toast.LENGTH_LONG).show();
	    	 // popWin.showAsDropDown(v);
	        popWin.dismiss();
	    }
	};

}
