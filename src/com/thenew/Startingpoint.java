package com.thenew;

import android.os.Bundle;
import android.widget.*;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class Startingpoint extends Activity {

    int counter;
    Button add,sub;
    TextView display;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startingpoint);
        counter=0;
        add=(Button) findViewById(R.id.bAdd);
        sub=(Button) findViewById(R.id.bSub);
        display = (TextView) findViewById(R.id.tvdisplay);
        add.setOnClickListener(new View.OnClickListener(  ) {	
			@Override
			public void onClick(View arg0) {
				counter++;
				display.setText("Your total is"+counter);
				  
				
			}
		});
     sub.setOnClickListener(new View.OnClickListener(  ) {
			
			@Override
			public void onClick(View arg0) {
				counter--;
				display.setText("Your total is"+counter);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.startingpoint, menu);
        return true;
    }
    
}
