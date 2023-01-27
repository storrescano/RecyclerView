package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LayoutInflater mInfalter;
    private LinkedList<String> mWordList;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInfalter = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInfalter.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            wordItemView.setText("Clicked! " + wordItemView.getText());
        }
    }
}