package com.thenew;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TestPlay extends Activity implements View.OnClickListener {
	Button chkcmd;
	ToggleButton pastog;
	EditText input;
	TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		baconandeggs();
    pastog.setOnClickListener(this);
	chkcmd.setOnClickListener(this);
}
	private void baconandeggs() {
		// TODO Auto-generated method stub
		chkcmd=(Button) findViewById(R.id.bResults);
		pastog=(ToggleButton) findViewById(R.id.tbPassword);
	    input=(EditText) findViewById(R.id.etcommands);
		display=(TextView) findViewById(R.id.tvRseults);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bResults:
			String check=input.getText().toString();
			String fuck=input.getText().toString();
			display.setText(check);
			if(check.contentEquals("left")){
		display.setGravity(Gravity.LEFT);			
		}else if(check.contentEquals("right")){
			display.setGravity(Gravity.RIGHT);
		}else if(check.contentEquals("center")){
			display.setGravity(Gravity.CENTER);
		}else if(check.contentEquals("blue")){
			display.setTextColor(Color.BLUE);
		}else if(check.contentEquals(fuck)){
			Random crazy=new Random();
			display.setText(fuck);
			display.setTextSize(crazy.nextInt(150));
			display.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(75)));
			switch(crazy.nextInt(3)){
			case 0:
				display.setGravity(Gravity.RIGHT);break;
			case 1:
				display.setGravity(Gravity.LEFT);break;
			case 2:
				display.setGravity(Gravity.CENTER);break;
				}
		}else{
			display.setText("invalid");
			display.setGravity(Gravity.CENTER);
			display.setTextColor(Color.WHITE );
		}
		break;
		case R.id.tbPassword:
			if(pastog.isChecked()){
				input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                 }else{
			input.setInputType(InputType.TYPE_CLASS_TEXT);
		}			
			break;
			
			
		}
		
	}
}
