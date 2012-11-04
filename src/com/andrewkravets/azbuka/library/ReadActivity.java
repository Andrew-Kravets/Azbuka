package com.andrewkravets.azbuka.library;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.andrewkravets.azbuka.BaseActivity;
import com.andrewkravets.azbuka.R;
import com.andrewkravets.azbuka.library.model.BookObject;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 08.10.12
 * Time: 10:36
 */
public class ReadActivity extends BaseActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_layout);

        Intent intent = getIntent();
        BookObject bookObject = (BookObject) intent.getSerializableExtra(BaseActivity.INTENT_BOOK);
        String link = bookObject.getTxtUrl();

        webView = (WebView) findViewById(R.id.read_layout_webwiew);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(link);
    }
}

