package com.oreilly.android.intro;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.oreilly.android.intro.model.Dots;
import com.oreilly.android.intro.view.DotView;


public class TouchMe extends Activity {

	public static final int DOT_DIAMETER = 6;
	
	private final Random rand = new Random();
	
	final Dots dotModel = new Dots();
	
	DotView dotView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		dotView = new DotView(this, dotModel);
		
		setContentView(R.layout.activity_touch_me);
		((LinearLayout) findViewById(R.id.root)).addView(dotView, 0);
		
		((Button) findViewById(R.id.button1)).setOnClickListener(
				new Button.OnClickListener() {
				@Override 
				public void onClick(View v) {
				makeDot(dots, dotView, Color.RED);
				} });
				((Button) findViewById(R.id.button2)).setOnClickListener(
				new Button.OnClickListener() {
				@Override 
				public void onClick(View v) {
				makeDot(dots, dotView, Color.GREEN);
				} });
				final EditText tb1 = (EditText) findViewById(R.id.text1);
				final EditText tb2 = (EditText) findViewById(R.id.text2);

	}
	
	void makeDot(Dots dots, DotView view, int color) {
		int pad = (DOT_DIAMETER + 2) * 2;
		dots.addDot(
		DOT_DIAMETER + (rand.nextFloat() * (view.getWidth() - pad)),
		DOT_DIAMETER + (rand.nextFloat() * (view.getHeight() - pad)),
		color,
		DOT_DIAMETER);
	}
}
