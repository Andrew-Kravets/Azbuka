package com.andrewkravets.azbuka.library;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.andrewkravets.azbuka.*;
import com.andrewkravets.azbuka.library.model.AuthorObject;
import com.andrewkravets.azbuka.library.model.BookObject;
import com.andrewkravets.azbuka.library.model.LetterObject;
import com.andrewkravets.azbuka.library.tools.LetterAdapter;
import com.andrewkravets.azbuka.tools.Connector;
import com.andrewkravets.azbuka.tools.SetupedDialog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LetterActivity extends BaseActivity {
    private ArrayList<LetterObject> letterObjects = new ArrayList<LetterObject>();
    private static final String LETTER_TITLE_KEY = "letter";
    private static final String AUTHORS_ARRAY_KEY = "Authors";
    private static final String AUTHOR_NAME_KEY = "author_name";
    private static final String BOOKS_ARRAY_KEY = "books";
    private static final String BOOK_TITE_KEY = "bname";
    private static final String BOOK_LINK_KEY = "blink";
    private static final String BOOK_TXT_LINK_KEY = "blinktxt";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters_layout);

        new getEntity().execute();

    }

    class getEntity extends AsyncTask<Void, Void, String> {
        SetupedDialog dialog = new SetupedDialog(LetterActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            return Connector.getEntities(null);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                try {
                    JSONArray lettersArray = new JSONArray(s);
                    for (int i = 0; i < lettersArray.length(); i++) {
                        JSONObject letter = (JSONObject) lettersArray.get(i);
                        String letterTitle = (String) letter.get(LETTER_TITLE_KEY);
                        JSONArray authorsArray = letter.getJSONArray(AUTHORS_ARRAY_KEY);
                        ArrayList<AuthorObject> authorObjects = new ArrayList<AuthorObject>();
                        for (int j = 0; j < authorsArray.length(); j++) {
                            JSONObject author = (JSONObject) authorsArray.get(j);
                            String authorName = (String) author.get(AUTHOR_NAME_KEY);
                            ArrayList<BookObject> bookObjects = new ArrayList<BookObject>();
                            JSONArray booksArray = author.getJSONArray(BOOKS_ARRAY_KEY);
                            for (int z = 0; z < booksArray.length(); z++) {
                                JSONObject book = (JSONObject) booksArray.get(z);
                                final String title = (String) book.get(BOOK_TITE_KEY);
                                String link = (String) book.get(BOOK_LINK_KEY);
                                final String txtLink = (String) book.get(BOOK_TXT_LINK_KEY);
                                bookObjects.add(new BookObject(title, link, txtLink));
                            }
                            authorObjects.add(new AuthorObject(authorName, bookObjects));
                        }
                        letterObjects.add(new LetterObject(letterTitle, authorObjects));
                    }
                    LetterAdapter adapter = new LetterAdapter(getBaseContext(), letterObjects, listener);
                    ((ListView) findViewById(R.id.letters_layout_listview)).setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            dialog.dismiss();
        }
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(LetterActivity.this, AuthorsActivity.class);
            intent.putExtra(BaseActivity.INTENT_LETTER, (LetterObject) view.getTag());
            startActivity(intent);
        }
    };
}
