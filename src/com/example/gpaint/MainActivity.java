package com.example.gpaint;

import java.io.File;
import java.io.FileOutputStream;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.gpaint.DFragment.EditNameDialogListener;

public class MainActivity extends ActionBarActivity implements
		EditNameDialogListener {

	MyCanvas drawView;
	PopupWindow pw;
	EditText et;
	Button but;
	LinearLayout mainLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
		if (drawView == null)
			drawView = new MyCanvas(this);
		setContentView(drawView);
		drawView.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.item_clrScreen) {
			Bitmap b = null;
			drawView.myBitmap = b;
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_white) {
			drawView.paint.setColor(Color.WHITE);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_blk) {
			drawView.paint.setColor(Color.BLACK);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_blue) {
			drawView.paint.setColor(Color.BLUE);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_red) {
			drawView.paint.setColor(Color.RED);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_yellow) {
			drawView.paint.setColor(Color.YELLOW);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_green) {
			drawView.paint.setColor(Color.GREEN);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_purple) {
			drawView.paint.setColor(Color.parseColor("#761E76"));
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_wh_bg) {
			drawView.setBackgroundColor(Color.WHITE);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_black_bg) {
			drawView.setBackgroundColor(Color.BLACK);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_blue_bg) {
			drawView.setBackgroundColor(Color.BLUE);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_red_bg) {
			drawView.setBackgroundColor(Color.RED);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_yellow_bg) {
			drawView.setBackgroundColor(Color.YELLOW);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_green_bg) {
			drawView.setBackgroundColor(Color.GREEN);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_purple_bg) {
			drawView.setBackgroundColor(Color.parseColor("#761E76"));
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_thickness_1) {
			drawView.paint.setStrokeWidth(1);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_thickness_5) {
			drawView.paint.setStrokeWidth(5);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_thickness_10) {
			drawView.paint.setStrokeWidth(10);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_thickness_15) {
			drawView.paint.setStrokeWidth(15);
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_thickness_20) {
			drawView.paint.setStrokeWidth(20);
			setContentView(drawView);
			return true;
		}

		if (id == R.id.item_free) {
			drawView.line_flag = 1;
			drawView.rect_flag = 0;
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_rect) {
			drawView.rect_flag = 1;
			drawView.line_flag = 0;
			drawView.circle_flag = 0;
			drawView.oval_flag = 0;
			drawView.arc_flag = 0;
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_circle) {
			drawView.circle_flag = 1;
			drawView.rect_flag = 0;
			drawView.line_flag = 0;
			drawView.oval_flag = 0;
			drawView.arc_flag = 0;
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_oval) {
			drawView.circle_flag = 0;
			drawView.rect_flag = 0;
			drawView.line_flag = 0;
			drawView.oval_flag = 1;
			drawView.arc_flag = 0;
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_arc) {
			drawView.circle_flag = 0;
			drawView.rect_flag = 0;
			drawView.line_flag = 0;
			drawView.oval_flag = 0;
			drawView.arc_flag = 1;
			setContentView(drawView);
			return true;
		}
		if (id == R.id.item_saveImage) {
			// Intent intent = new Intent(this, SaveActivity.class);
			// startActivityForResult(intent, 1);
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			alert.setTitle(R.string.save_image);
			alert.setIcon(R.drawable.save_icon);
			alert.setMessage(R.string.enter_image_name);
			final EditText et = new EditText(this);
			alert.setView(et);
			alert.setPositiveButton(R.string.save,
					new DialogInterface.OnClickListener() {

						// @Override
						public void onClick(DialogInterface dialog, int which) {

							String s = et.getText().toString();
//							Intent serviceIntent = new Intent(
//									getApplicationContext(), MyService.class);
//							serviceIntent.putExtra("imageName", s);
//							serviceIntent.putExtra("draw", drawView);
//							startService(serviceIntent);
							 saveAsJpg(s);
						}
					});
			alert.setNegativeButton(R.string.cancel,
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			alert.show();
			return true;
		}
		if (id == R.id.item_loadImage) {
			// Intent intent2 = new Intent(this, LoadActivity.class);
			// startActivityForResult(intent2, 2);
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			final EditText et = new EditText(this);
			alert.setTitle(R.string.load_image);
			alert.setMessage(R.string.enter_image_name);
			alert.setIcon(R.drawable.load);
			alert.setView(et);
			alert.setPositiveButton(R.string.load,
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							String s = et.getText().toString();
							Bitmap b = loadFromFile("/storage/extSdCard/G/" + s
									+ ".jpg");
							Bitmap drawableBitmap = b.copy(
									Bitmap.Config.ARGB_8888, true);
							Canvas canvas = new Canvas(drawableBitmap);
							drawView.myBitmap = drawableBitmap;
							setContentView(drawView);

						}
					});
			alert.setNegativeButton(R.string.cancel,
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			alert.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void saveAsJpg(String s) {
		File f = new File(s);
		Bitmap b = Bitmap.createBitmap(drawView.getWidth(),
				drawView.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(b);
		drawView.draw(canvas);
		String filePath = getFilesDir().getPath().toString() + "/fileName.jpg";
		f = new File(filePath);
		try {
			b.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(
					new File("/storage/extSdCard/G/" + s + ".jpg")));
			Toast.makeText(getApplicationContext(),
					"Saved in /storage/extSdCard/G/" + s + ".jpg",
					Toast.LENGTH_LONG).show();
		} catch (Throwable ex) {
			Toast.makeText(getApplicationContext(),
					"Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
			ex.printStackTrace();
		}
	}

	public Bitmap loadFromFile(String filename) {
		try {
			File f = new File(filename);
			if (!f.exists()) {
				Toast.makeText(getApplicationContext(),
						"Error: File not exist ", Toast.LENGTH_LONG).show();
				return null;
			}
			Bitmap tmp = BitmapFactory.decodeFile(filename);
			Toast.makeText(getApplicationContext(), "Image Loaded!",
					Toast.LENGTH_LONG).show();
			return tmp;
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(),
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		try {
			String message = data.getStringExtra("MESSAGE");
			if (resultCode == 1)
				saveAsJpg(message);
			// if (resultCode == 2) {
			// Bitmap b = loadFromFile("/storage/extSdCard/G/" + message
			// + ".jpg");
			// Bitmap drawableBitmap = b.copy(Bitmap.Config.ARGB_8888, true);
			// Canvas canvas = new Canvas(drawableBitmap);
			// drawView.myBitmap = drawableBitmap;
			// setContentView(drawView);
			// }
		} catch (Exception e) {
		}
	}

	@Override
	public void onFinishEditDialog(String message) {
		try {
			saveAsJpg(message);
		} catch (Exception e) {
		}
	}

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle("G' Paint")
				.setMessage("Are you sure to exit?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								finish();
							}

						}).setNegativeButton("No", null).show();
	}
}
