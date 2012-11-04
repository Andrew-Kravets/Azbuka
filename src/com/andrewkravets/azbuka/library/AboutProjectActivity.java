package com.andrewkravets.azbuka.library;

import android.os.Bundle;
import android.widget.TextView;
import com.andrewkravets.azbuka.BaseActivity;
import com.andrewkravets.azbuka.R;

/**
 * Created with IntelliJ IDEA.
 * User: andrew
 * Date: 31.10.12
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class AboutProjectActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.about_project_layout);
        ((TextView)findViewById(R.id.about_project_layout_text)).setText(R.string.about_project);
    }
}
