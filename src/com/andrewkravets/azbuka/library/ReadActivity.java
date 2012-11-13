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
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import com.andrewkravets.azbuka.BaseActivity;
import com.andrewkravets.azbuka.R;
import com.andrewkravets.azbuka.library.model.BookObject;
import com.andrewkravets.azbuka.tools.Connector;
import com.andrewkravets.azbuka.tools.SetupedDialog;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 08.10.12
 * Time: 10:36
 */
public class ReadActivity extends BaseActivity {

    WebView webView;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_layout);

        Intent intent = getIntent();
        BookObject bookObject = (BookObject) intent.getSerializableExtra(BaseActivity.INTENT_BOOK);

        webView = (WebView) findViewById(R.id.read_layout_webwiew);
        webView.getSettings().setJavaScriptEnabled(true);
        new load().execute(bookObject.getTxtUrl());
    }

    private class load extends AsyncTask<String, Void, String> {
        SetupedDialog dialog = new SetupedDialog(ReadActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();    //To change body of overridden methods use File | Settings | File Templates.
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            return Connector.getEntities(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            if(s!=null) {
                data=s;
                webView.loadData(data, "text/html; charset=UTF-8", null);
                webView.invalidate();
            }
            dialog.dismiss();
        }
    }
}

