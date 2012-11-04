package com.andrewkravets.azbuka.library.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.andrewkravets.azbuka.R;
import com.andrewkravets.azbuka.library.model.LetterObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:40
 */
public class LetterAdapter extends ArrayAdapter<LetterObject> {
    private Context mContext;
    private List<LetterObject> mList;
    private View.OnClickListener mListener;

    public LetterAdapter(Context context, List<LetterObject> objects, View.OnClickListener listener) {
        super(context, R.layout.row_letters, objects);
        mContext = context;
        mList = objects;
        mListener = listener;
    }

    private static class ViewHolder {
        public static TextView mTextViewLetter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_letters, null);
            viewHolder = new ViewHolder();
            viewHolder.mTextViewLetter =((TextView) convertView.findViewById(R.id.row_letters_title));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LetterObject object = mList.get(position);
        viewHolder.mTextViewLetter.setText(object.getTitle()+" ("+object.getAmount()+")");
        viewHolder.mTextViewLetter.setTag(object);
        viewHolder.mTextViewLetter.setOnClickListener(mListener);
        return convertView;
    }
}
