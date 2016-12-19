package com.thenew;

import android.app.Activity;
import android.os.Bundle;

public class SetActivity extends Activity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  // TODO Auto-generated method stub
  super.onCreate(savedInstanceState);
  
  getFragmentManager().beginTransaction().replace(android.R.id.content,
                new Prefs()).commit();
 }

}