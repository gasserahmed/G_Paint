package com.example.gpaint;

import java.io.Serializable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyCanvas extends View implements OnTouchListener, Serializable {
	private static final long serialVersionUID = 1L;
	Paint paint;
	Bitmap myBitmap;
	private Path path;
	private PointF previousPoint;
	private PointF startPoint;
	private PointF currentPoint;
	MyCanvas drawingView;

	public Paint getP() {
		return paint;
	}

	public void setP(Paint paint) {
		this.paint = paint;
	}

	public Bitmap getB() {
		return myBitmap;
	}

	public void setB(Bitmap myBitmap) {
		this.myBitmap = myBitmap;
	}

	public MyCanvas getC() {
		return drawingView;
	}

	public void setC(MyCanvas drawingView) {
		this.drawingView = drawingView;
	}

	public MyCanvas(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setBackgroundColor(Color.WHITE);
		this.setOnTouchListener(this);
		path = new Path();
		paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
		paint.setStrokeWidth(10);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStyle(Paint.Style.STROKE);
	}

	@Override
	public void onDraw(Canvas canvas) {
		if (myBitmap == null) {
			myBitmap = Bitmap.createBitmap(getWidth(), getHeight(),
					Config.ARGB_8888);
		}
		canvas.drawBitmap(myBitmap, 0, 0, paint);
	}

	float prevX = -1, prevY = -1, line_flag = 1, rect_flag = 0,
			circle_flag = 0, oval_flag = 0, arc_flag = 0, shapeX = -1,
			shapeY = -1;

	@Override
	public boolean onTouch(View v,MotionEvent event) {
		Canvas c = new Canvas(myBitmap);
		if (line_flag == 1) {
			if (event.getAction() == MotionEvent.ACTION_DOWN){
				currentPoint = new PointF(event.getX(), event.getY());
		        previousPoint = currentPoint;
		        startPoint = previousPoint;
		        path.reset();
			}
			if (prevX > -1)				
				c.drawLine(prevX, prevY, event.getX(), event.getY(), paint);
			else
				c.drawPoint(event.getX(), event.getY(), paint);
		} else if (rect_flag == 1) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				shapeX = event.getX();
				shapeY = event.getY();
			}
			c.drawRect(shapeX, shapeY, event.getX(), event.getY(), paint);
		} else if (circle_flag == 1) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				shapeX = event.getX();
				shapeY = event.getY();
			}
			c.drawCircle(shapeX, shapeY, event.getX() - 300, paint);
		}
		prevX = event.getX();
		prevY = event.getY();
		if (event.getAction() == MotionEvent.ACTION_UP) {
//			startPoint = previousPoint;
//	        previousPoint = currentPoint;
//	        currentPoint = new PointF(event.getX(), event.getY());
//	        drawLine(drawingView, path, paint, previousPoint, currentPoint);
			prevX = -1;
			shapeX = -1;
			shapeY = -1;
		}
		invalidate();
		return true;
	}

//	private void drawLine(MyCanvas drawingView2, Path path2, Paint paint2,
//			PointF previousPoint2, PointF currentPoint2) {
//		// TODO Auto-generated method stub
//		
//	}

}
