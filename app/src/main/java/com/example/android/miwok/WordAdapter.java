package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> wordList){
        super(context,0,wordList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;
        if(listView==null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.layout_list_item,parent,false);
        }

        Word currentWord = getItem(position);
        TextView defaultTranslation = listView.findViewById(R.id.textview_key);

        defaultTranslation.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslation = listView.findViewById(R.id.textview_value);

        miwokTranslation.setText(currentWord.getMiwokTranslation());

        return listView;




    }


}
