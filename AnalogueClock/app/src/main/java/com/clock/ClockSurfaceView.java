package com.clock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("ViewConstructor")
public class ClockSurfaceView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isRunning = false;

    private final float length;
    private final Context context;

    private final SurfaceHolder holder;

    public ClockSurfaceView(Context context, float length) {
        super(context);

        this.length = length;
        this.context = context;

        holder = getHolder();
    }

    public void onResumeClock() {
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public void onPauseClock() {
        isRunning = false;

        boolean reEntry = true;
        while (reEntry) {
            try {
                thread.join();
                reEntry = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        int sec = 0;
        while (isRunning) {
            if (holder.getSurface().isValid()) {
                // we are ready to draw
                Canvas canvas = holder.lockCanvas();

                // clear background
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);

                // draw second marks
                paint.setColor(Color.RED);
                paint.setStrokeWidth(5);

                RegPoly secMarks = new RegPoly(60, getWidth() / 2, getHeight() / 2, this.length, canvas, paint);
                secMarks.drawNodes();

                RegPoly hourMarks = new RegPoly(12, getWidth() / 2, getHeight() / 2, this.length - 20, canvas, paint);
                hourMarks.drawNodes();

                // draw the second hand
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);

                RegPoly secHand = new RegPoly(60, getWidth() / 2, getHeight() / 2, this.length - 20, canvas, paint);
                secHand.drawRadius(sec + 45);

                // sleep
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }

                ++sec;

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
