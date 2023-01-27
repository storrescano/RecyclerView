package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.databinding.ActivityMainBinding;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<String> mWorldList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mWorldList = new LinkedList<>();
        WordListAdapter mAdapter = new WordListAdapter(this, mWorldList);

        RecyclerView mRecyclerView = binding.recyclerview;
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.fab.setOnClickListener(v -> {
            String newElement = "Word " + (mWorldList.size()+1);
            mWorldList.add(newElement);
            mRecyclerView.getAdapter().notifyItemChanged(mWorldList.size());
            mRecyclerView.smoothScrollToPosition(mWorldList.size());
        });

    }
}