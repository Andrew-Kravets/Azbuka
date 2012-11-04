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
public class HowToHelpActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.howtohelp_layout);
        ((TextView)findViewById(R.id.howtohelp_layout_text)).setText(R.string.how_to_help);
    }
}
