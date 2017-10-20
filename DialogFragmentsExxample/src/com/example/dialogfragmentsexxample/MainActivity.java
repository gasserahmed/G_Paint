package com.example.dialogfragmentsexxample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

import com.example.dialogfragmentsexxample.MyDialogFragment.EditNameDialogListener;

public class MainActivity extends FragmentActivity implements
		EditNameDialogListener {

	TextView txt = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		txt = new TextView(this);
		txt.setText("Nothing received from Dialog Fragment");
		txt.setTextSize(30);
		setContentView(txt);
		showEditDialog();
	}

	private void showEditDialog() {
		FragmentManager fm = getSupportFragmentManager();
		MyDialogFragment editNameDialog = new MyDialogFragment();
		editNameDialog.show(fm, "fragment_edit_name");
	}

	@Override
	public void onFinishEditDialog(String inputText) {
		txt.setText("Input value from DialogFragment " + inputText);
	}
}