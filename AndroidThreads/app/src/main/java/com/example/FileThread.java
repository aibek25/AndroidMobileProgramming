package com.example;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileThread extends Thread {

    TextView fileTextView;

    public FileThread(String name, TextView textView) {
        super(name);

        fileTextView = textView;
    }

    @Override
    public void run() {
        /* open input stream to raw file
        InputStream inputStream = getResources().openRawResource(R.raw.poezie);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        */

        // open sd card file
        String sdCardPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filePath = sdCardPath + "/poezie.txt";
        File file = new File(filePath);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // read from the file and build a string
        try {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                Thread.sleep(1000);
                Message msg = handler.obtainMessage(1, line);
                handler.sendMessage(msg);
            }
        } catch (Exception e) {

        }
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String line = msg.obj.toString();
            fileTextView.append(line + "\n");
        }
    };
}