package com.thenew; 

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class Menu extends ListActivity {
	
	String classes[]={"Startingpoint","TestPlay","Email","Camera","Data","GFX","example6"};
	CheckBox prefCheckBox;
	TextView prefEditText;
	List lis;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese=classes[position];
		try{
		Class ourclass=Class.forName("com.thenew."+cheese);
		Intent ourintent=new Intent(Menu.this,ourclass);
		startActivity(ourintent);
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}


}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
	    super.onCreateOptionsMenu(menu);
		MenuInflater blowUp= getMenuInflater();
		blowUp.inflate(R.menu.cool_menu,menu);
		return true;
	
	}

	
	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId()){
		case R.id.aboutUs:
			Intent i=new Intent("com.thenew.ABOUT");
			startActivity(i);break;
				
		case R.id.preferences:	
		Intent intent = new Intent();
        intent.setClass(Menu.this, SetActivity.class);
        startActivityForResult(intent, 0); break; 
	
		case R.id.exit:
			finish();
			break;
			
		}
		
        return true;
	}


	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		//super.onActivityResult(requestCode, resultCode, data);
		
		/*
		 * To make it simple, always re-load Preference setting.
		 */
	
		loadPref();
	}

	private void loadPref() {
		// TODO Auto-generated method stub
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		boolean my_checkbox_preference = mySharedPreferences.getBoolean("checkbox_preference", false);
	    prefCheckBox.setChecked(my_checkbox_preference);
	    String my_edittext_preference = mySharedPreferences.getString("edittext_preference", "");
    	prefEditText.setText(my_edittext_preference);
		
	}


}