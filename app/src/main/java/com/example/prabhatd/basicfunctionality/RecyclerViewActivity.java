package com.example.prabhatd.basicfunctionality;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.LinkedList;

public class RecyclerViewActivity extends AppCompatActivity {

    private final LinkedList<String> mWord = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mWordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView =findViewById(R.id.recyclerView);
        mWordList =new WordListAdapter(this,mWord);
        mRecyclerView.setAdapter(mWordList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for(int i=0;i<20;i++){
            mWord.add("word"+i);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
