package com.andrewkravets.azbuka.library.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.andrewkravets.azbuka.R;
import com.andrewkravets.azbuka.library.model.BookObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:41
 */
public class BookAdapter extends ArrayAdapter<BookObject> {
    private Context mContext;
    private List<BookObject> mList;
    private  View.OnClickListener mListener;

    public BookAdapter(Context context,List<BookObject> objects, View.OnClickListener listener) {
        super(context, R.layout.row_books, objects);
        mContext=context;
        mList = objects;
        mListener = listener;
    }

    private static class ViewHolder {
        public static TextView mTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_books, null);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.row_books_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BookObject bookObject = mList.get(position);
        viewHolder.mTextView.setTag(bookObject);
        viewHolder.mTextView.setText(bookObject.getTitle());
        viewHolder.mTextView.setOnClickListener(mListener);
        return convertView;
    }
}
