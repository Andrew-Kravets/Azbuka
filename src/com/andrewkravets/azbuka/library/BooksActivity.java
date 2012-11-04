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
import android.view.View;
import android.widget.ListView;
import com.andrewkravets.azbuka.BaseActivity;
import com.andrewkravets.azbuka.R;
import com.andrewkravets.azbuka.library.model.AuthorObject;
import com.andrewkravets.azbuka.library.model.BookObject;
import com.andrewkravets.azbuka.library.tools.BookAdapter;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:36
 */
public class BooksActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_layout);

        Intent intent = getIntent();
        AuthorObject authorObject = (AuthorObject) intent.getSerializableExtra(BaseActivity.INTENT_AUTHOR);
        ArrayList<BookObject> booksObjects = authorObject.getBooks();
        ListView listView = (ListView) findViewById(R.id.books_layout_listview);
        BookAdapter adapter = new BookAdapter(this, booksObjects, listener);
        listView.setAdapter(adapter);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(BooksActivity.this, ReadActivity.class);
            intent.putExtra(BaseActivity.INTENT_BOOK, (BookObject)view.getTag());
            startActivity(intent);
        }
    };
}
