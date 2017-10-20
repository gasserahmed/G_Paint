package com.example.gpaint;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Toast.makeText(this, "Saving..", Toast.LENGTH_LONG).show();
//		MyCanvas studObject = intent.getSerializableExtra("draw");
		saveAsJpg(intent.getStringExtra("imageName"));
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	}

	public void saveAsJpg(String s) {
		// File f = new File(s);
		// Bitmap b = Bitmap.createBitmap(geti.getWidth(),
		// drawView.getHeight(), Bitmap.Config.ARGB_8888);
		// Canvas canvas = new Canvas(b);
		// drawView.draw(canvas);
		// String filePath = getFilesDir().getPath().toString() +
		// "/fileName.jpg";
		// f = new File(filePath);
		// try {
		// b.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(
		// new File("/storage/extSdCard/G/" + s + ".jpg")));
		Toast.makeText(getApplicationContext(),
				"Saved in /storage/extSdCard/G/" + s + ".jpg",
				Toast.LENGTH_LONG).show();
		stopSelf();
		// } catch (Throwable ex) {
		// Toast.makeText(getApplicationContext(),
		// "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
		// ex.printStackTrace();
		// }
	}
}