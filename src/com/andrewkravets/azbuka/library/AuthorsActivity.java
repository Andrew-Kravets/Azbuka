package com.andrewkravets.azbuka.library;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.andrewkravets.azbuka.BaseActivity;
import com.andrewkravets.azbuka.R;
import com.andrewkravets.azbuka.library.model.AuthorObject;
import com.andrewkravets.azbuka.library.model.LetterObject;
import com.andrewkravets.azbuka.library.tools.AuthorAdapter;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:36
 */
public class AuthorsActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authors_layout);

        Intent intent = getIntent();
        LetterObject letterObject = (LetterObject) intent.getSerializableExtra(BaseActivity.INTENT_LETTER);
        ArrayList<AuthorObject> authorObjects = letterObject.getAuthors();
        AuthorAdapter authorAdapter = new AuthorAdapter(this, authorObjects, listener);
        ListView listView = (ListView) findViewById(R.id.authors_layout_listview);
        listView.setAdapter(authorAdapter);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(AuthorsActivity.this, BooksActivity.class);
            intent.putExtra(BaseActivity.INTENT_AUTHOR, (AuthorObject)view.getTag());
            startActivity(intent);
        }
    };
}
