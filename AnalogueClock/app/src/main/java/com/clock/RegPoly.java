package com.clock;

import android.graphics.Canvas;
import android.graphics.Paint;

public class RegPoly {
    private final int n;
    private final float x0;
    private final float y0;
    private final float[] x;
    private final float[] y;

    private final Canvas canvas;
    private final Paint paint;

    public RegPoly(int n, float x0, float y0, float r, Canvas canvas, Paint paint) {
        this.n = n;
        this.x0 = x0;
        this.y0 = y0;
        this.canvas = canvas;
        this.paint = paint;

        this.x = new float[n];
        this.y = new float[n];
        for (int i = 0; i < n; ++i) {
            this.x[i] = (float) (this.x0 + r * Math.cos(2 * Math.PI * i / n));
            this.y[i] = (float) (this.y0 + r * Math.sin(2 * Math.PI * i / n));
        }

    }

    public float getX(int i) {
        return this.x[i % this.n];
    }

    public float getY(int i) {
        return this.y[i % this.n];
    }

    public void drawRadius(int i) {
        this.canvas.drawLine(this.x0, this.y0, this.x[i % this.n], this.y[i % this.n], this.paint);
    }

    public void drawNodes() {
        for (int i = 0; i < n; ++i) {
            this.canvas.drawCircle(getX(i), getY(i), 5, this.paint);
        }
    }
}
