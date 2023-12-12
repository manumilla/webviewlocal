package com.gameducation.webviewlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import android.annotation.SuppressLint;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // calendario
        // Obtener la fecha actual
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMdd", Locale.getDefault());
        String currentDate = dateFormat.format(new Date());

        // Construir la URL con el ancla
        String url = "file:///android_asset/mais_semelhante_a_jesus.html#" + currentDate;

        webView = findViewById(R.id.myWebView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webView.setWebViewClient(new Callback());
        // Habilitar el acceso a los recursos locales, pero no se si hace falta
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        //
        //webView.loadUrl("file:///android_asset/mais_semelhante_a_jesus.html#"+mes+dia);
        webView.loadUrl(url);


    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}