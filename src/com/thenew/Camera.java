package com.thenew;

import java.io.IOException;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.*;
import java.net.MalformedURLException;

public class Camera extends Activity implements View.OnClickListener {
     Intent i;
	 ImageButton  ib;
	Button b;
	ImageView iv;
	final static int cameraData=0;
	Bitmap bmp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		InputStream is=getResources().openRawResource(R.drawable.ic_launcher);
		bmp=BitmapFactory.decodeStream(is);
	}
	private void initialize(){
		iv=(ImageView) findViewById(R.id.ivReturnedpic);
		ib=(ImageButton) findViewById(R.id.ibTakepic);
		b=(Button) findViewById(R.id.bSetWall);
		b.setOnClickListener(this);
	   ib.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	switch(v.getId())
	{
	case R.id.bSetWall:
		try {
			getApplicationContext().setWallpaper(bmp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		break;
		
case R.id.ibTakepic:
		i =new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(i,cameraData);break;
		
		}
	}
		
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extras=data.getExtras();
			bmp=(Bitmap) extras.get("data");
			iv.setImageBitmap(bmp);
			
		}
	}
	
	
	
}
