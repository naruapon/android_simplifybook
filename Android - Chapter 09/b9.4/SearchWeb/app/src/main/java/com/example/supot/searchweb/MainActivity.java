package com.example.supot.searchweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private EditText urlSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlSearch = (EditText) findViewById(R.id.urlField);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebViewClient());


        ImageButton openUrl = (ImageButton)findViewById(R.id.searchButton);
        openUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = urlSearch.getText().toString();
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url); // load a web page in a web view
               // webView.loadUrl("http://www.google.com");
            }


        });
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}