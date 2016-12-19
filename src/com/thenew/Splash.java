package com.thenew;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {
	MediaPlayer oursong;

	@Override
	protected void onCreate(Bundle ali) {
		// TODO Auto-generated method stub
		super.onCreate(ali);
		setContentView(R.layout.splash);
		oursong=MediaPlayer.create(Splash.this,R.raw.splash);
		SharedPreferences getprefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getprefs.getBoolean("checkbox",true);
		if(music==true)
		oursong.start();
		
		Thread timer=new Thread(){
			
			public void run(){
				try{
					sleep(2000);
					
			}catch(InterruptedException e){
				e.printStackTrace();
					
				}finally{
					Intent openstartingpoint=new Intent("com.thenew.MENU");
					startActivity(openstartingpoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		oursong.release();
		finish();
	}
	

}
