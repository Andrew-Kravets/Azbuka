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
