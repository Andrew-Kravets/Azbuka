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

package com.andrewkravets.azbuka.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class SetupedDialog {
    private ProgressDialog progressDialog;
    private String message = "Загрузка, пожалуйста подождите...";
    private String title = "";
    private View view;
    private TextView mTextView;
    private boolean isCanselable;

    public SetupedDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
    }

    public void setTitle(String title) {
        this.title = title;
        progressDialog.setTitle(title);
    }

    public void setMessage(String message) {
        this.message = message;
        progressDialog.setMessage(message);
    }

    public void show() {
        progressDialog.show();
    }

    public void dismiss() {
        progressDialog.dismiss();
    }

}
