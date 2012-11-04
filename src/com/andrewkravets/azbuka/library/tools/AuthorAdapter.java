package com.andrewkravets.azbuka.library.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.andrewkravets.azbuka.R;
import com.andrewkravets.azbuka.library.model.AuthorObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:41
 */
public class AuthorAdapter extends ArrayAdapter<AuthorObject> {
    private Context mContext;
    private List<AuthorObject> mList;
    private View.OnClickListener mListener;

    public AuthorAdapter(Context context, List<AuthorObject> objects, View.OnClickListener listener) {
        super(context, R.id.row_authors_name, objects);
        mContext = context;
        mList = objects;
        mListener = listener;
    }

    private static class ViewHolder {
        public static TextView mTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_authors, null);
            viewHolder = new AuthorAdapter.ViewHolder();
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.row_authors_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AuthorObject authorObject = mList.get(position);
        String text = authorObject.getName() + " (" + authorObject.getBooks().size() + ")";
        viewHolder.mTextView.setText(text);
        viewHolder.mTextView.setTag(authorObject);
        viewHolder.mTextView.setOnClickListener(mListener);
        return convertView;
    }
}
