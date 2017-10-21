package com.example.gpaint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class LoadActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
		setContentView(R.layout.activity_load);
	}
	public void loadName(View V)
    {
        // get the Entered  message
		EditText editText = (EditText) findViewById(R.id.editText1);
        String name=editText.getText().toString();
        Intent intentName=new Intent();
        // put the message in Intent
        intentName.putExtra("MESSAGE",name);
        // Set The Result in Intent
        setResult(2,intentName);
        // finish The activity 
        finish();
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.load, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_load) {
			loadName(findViewById(R.layout.activity_load));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
