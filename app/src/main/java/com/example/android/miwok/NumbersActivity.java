package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer.OnCompletionListener  mOnCompletionListener= (mp -> mp.release());
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> wordList = new ArrayList<>();
        wordList.add(new Word("One","lutti"));
        wordList.add(new Word("two","otiiko"));
        wordList.add(new Word("three","tolookosu"));
        wordList.add(new Word("four","oyyisa"));
        wordList.add(new Word("five","massokka"));
        wordList.add(new Word("six","temmokka"));
        wordList.add(new Word("seven","kenekaku"));
        wordList.add(new Word("eight","kawinta"));
        wordList.add(new Word("nine","wo'e"));
        wordList.add(new Word("ten","na'accha"));


        WordAdapter wordAdapter = new WordAdapter(this,wordList);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(wordAdapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {

            if(mediaPlayer!=null)
                mediaPlayer.release();
            mediaPlayer= MediaPlayer.create(NumbersActivity.this,R.raw.test);

            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mOnCompletionListener);
        });



    }


    //To release the resources acquired by media player object,  before leaving this activity
    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
    }
}

