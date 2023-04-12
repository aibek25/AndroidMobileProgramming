package com.clock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("ViewConstructor")
public class TimerSurfaceView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isRunning = false;

    private final float length;
    private final float secs;
    private final Context context;

    private final SurfaceHolder holder;

    public TimerSurfaceView(Context context, float length, float secs) {
        super(context);

        this.length = length;
        this.secs = secs;
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

                // check sec
                if (sec > secs) {
                    isRunning = false;
                    // perhaps something more to do ???
                }

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

                // draw the sector corresponding to sec
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);

                RectF rectF = new RectF(
                        getWidth() / 2 - length + 50, getHeight() / 2 - length + 50,
                        getWidth() / 2 + length - 50, getHeight() / 2 + length - 50);

                float startAngle = -90f, endAngle = (float) (360f * sec / secs);
                canvas.drawArc(rectF, startAngle, endAngle, true, paint);

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
