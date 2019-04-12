package com.example.prabhatd.basicfunctionality;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {

    private final LinkedList<String> mWordList;
    private LayoutInflater mLayoutInflater;
    public WordListAdapter(Context context,LinkedList<String> WordList){
        mLayoutInflater=LayoutInflater.from(context);
        this.mWordList=WordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView=mLayoutInflater.inflate(R.layout.wordlist_item,parent,false);

        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder wordViewHolder, int i) {
        String mCurrent= mWordList.get(i);
        wordViewHolder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }



    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        WordListAdapter mAdapter;
        public WordViewHolder(View itemView,WordListAdapter adapter) {
            super(itemView);

            wordItemView=itemView.findViewById(R.id.text);
            this.mAdapter=adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
    int mpostion=getLayoutPosition();
    String text =mWordList.get(mpostion);
    mWordList.set(mpostion,"Clicked"+text);
    mAdapter.notifyDataSetChanged();
        }
    }

}
