package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {

    private EditText urlEditText;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        // wire
        urlEditText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        // get url from activity details
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("urlPerson");

        // populate view from url
        urlEditText.setText(url);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}