package com.example.zane.cheeses.moduel.homepage.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zane.cheeses.R;
import com.example.zane.cheeses.config.Cheeses;
import com.example.zane.cheeses.moduel.homepage.CheesesListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zane on 15/12/2.
 */
public class CheesesDetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.text1)
    TextView text1;
    @Bind(R.id.text2)
    TextView text2;
    @Bind(R.id.text3)
    TextView text3;
    @Bind(R.id.image)
    ImageView imageView;

    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);
        ButterKnife.bind(this);

        position = getIntent().getIntExtra(CheesesListFragment.POSITION, 0);

        setupToolbar();
        setText();

    }

    public void setupToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbar.setTitle(Cheeses.sCheeseStrings[position]);
        Glide.with(this)
                .load(Cheeses.getRandomCheeseDrawable())
                .centerCrop()
                .into(imageView);
    }
    public void setText(){
        text1.setText(Cheeses.sCheeseInfo[position]);
        text2.setText(Cheeses.sCheeseInfo[position]);
        text3.setText(Cheeses.sCheeseInfo[position]);
    }


}
