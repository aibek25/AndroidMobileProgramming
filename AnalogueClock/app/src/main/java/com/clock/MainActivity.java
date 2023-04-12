package com.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TimerSurfaceView clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // clock = new ClockSurfaceView(this, 300);
        clock = new TimerSurfaceView(this, 400, 30);
        setContentView(clock);
    }

    @Override
    protected void onPause() {
        super.onPause();

        clock.onPauseClock();
    }

    @Override
    protected void onResume() {
        super.onResume();

        clock.onResumeClock();
    }
}