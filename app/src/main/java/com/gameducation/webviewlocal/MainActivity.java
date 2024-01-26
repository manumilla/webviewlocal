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
        SimpleDateFormat dateFormat_day = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat dateFormat_month = new SimpleDateFormat("MM", Locale.getDefault());
        String currentDate_day = dateFormat_day.format(new Date());
        int number_day = Integer.parseInt(currentDate_day);
        String dia = Integer.toString(number_day);
        String currentDate_month = dateFormat_month.format(new Date());
        int number_month = Integer.parseInt(currentDate_month);
        String mes = Integer.toString(number_month);

        // Construir la URL con el ancla
        // String url = "file:///android_asset/mais_semelhante_a_jesus.html#" + currentDate;
        String url = "https://sites.google.com/site/maissemelhanteajesus/languagespanish/month" + mes + "/day" + dia;
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