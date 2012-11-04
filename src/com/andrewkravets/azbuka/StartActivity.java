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

package com.andrewkravets.azbuka;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.andrewkravets.azbuka.library.AboutProjectActivity;
import com.andrewkravets.azbuka.library.HowToHelpActivity;
import com.andrewkravets.azbuka.library.LetterActivity;


public class StartActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
        findViewById(R.id.start_layout_lib_button).setOnClickListener(listener);
        findViewById(R.id.start_layout_howtohelp_button).setOnClickListener(listener);
        findViewById(R.id.start_layout_about_button).setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            Intent intent;
            switch (id) {
                case R.id.start_layout_lib_button:
                    intent = new Intent(StartActivity.this, LetterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.start_layout_about_button:
                    intent = new Intent(StartActivity.this, AboutProjectActivity.class);
                    startActivity(intent);
                    break;
                case R.id.start_layout_howtohelp_button:
                    intent = new Intent(StartActivity.this, HowToHelpActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
