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
