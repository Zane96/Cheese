package com.example.zane.cheeses.moduel.homepage;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zane.cheeses.R;
import com.example.zane.cheeses.app.App;
import com.example.zane.cheeses.config.Cheeses;
import com.example.zane.cheeses.moduel.homepage.detail.CheesesDetailActivity;


/**
 * Created by Zane on 15/12/2.
 */
public class CheesesListFragment extends Fragment {
    
    private RecycleviewAdapter adapter;

    public static final String POSITION = "POSITION";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new RecycleviewAdapter(Cheeses.sCheeseStrings);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //View view = inflater.inflate(R.layout.fragment_list, container, false);
      RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_list, container ,false);

        setupRecycleview(recyclerView);

        return recyclerView;
    }

    public void setupRecycleview(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(App.getInstance()));
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new RecycleviewAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int position) {
                Intent intent = new Intent(getActivity(), CheesesDetailActivity.class);
                intent.putExtra(POSITION, position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
