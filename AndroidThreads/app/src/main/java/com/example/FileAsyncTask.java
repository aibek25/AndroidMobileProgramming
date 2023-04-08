package com.example;

import android.os.AsyncTask;
import android.os.Environment;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileAsyncTask extends AsyncTask<String, String, Void> {

    TextView fileTextView;

    public FileAsyncTask(TextView textView) {
        fileTextView = textView;
    }

    @Override
    protected Void doInBackground(String... strings) {
        // read a line from the sdcard file strings[0]
        // open sd card file
        String sdCardPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filePath = sdCardPath + "/" + strings[0];
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
                publishProgress(line + "\n");
            }
        } catch (Exception ignored) {

        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        fileTextView.setText("+++++++++++++++++++++++++\n\n");
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        fileTextView.append("\n\n+++++++++++++++++++++++++");
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        // place values[0] to textview
        fileTextView.append(values[0]);
    }
}
