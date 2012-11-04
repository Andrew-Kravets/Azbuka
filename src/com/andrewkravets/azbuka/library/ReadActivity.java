/*
 * Copyright (c) 2012. Andrew Kravets
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

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

