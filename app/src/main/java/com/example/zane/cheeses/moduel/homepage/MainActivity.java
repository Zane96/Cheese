package com.example.zane.cheeses.moduel.homepage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.zane.cheeses.R;
import com.example.zane.cheeses.app.App;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.navigationview)
    NavigationView navigationview;
    @Bind(R.id.drawerlayout)
    DrawerLayout drawerlayout;

    private ViewpagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();
        setupNavigationView();
        setupViewpager();
        setupFloatingButton();
        setupTablayout();

    }

    public void setupTablayout(){
        tablayout.setupWithViewPager(viewpager);
    }

    public void setupFloatingButton(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "点我做乜野啊！", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(App.getInstance(), "你仲点我！？", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }

    public void setupViewpager(){
        adapter = new ViewpagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CheesesListFragment(), "第一页");
        adapter.addFragment(new CheesesListFragment(), "第二页");
        adapter.addFragment(new CheesesListFragment(), "第三页");
        viewpager.setAdapter(adapter);
    }

    public void setupNavigationView(){
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                drawerlayout.closeDrawers();
                return true;
            }
        });
    }

    public void setupToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerlayout.openDrawer(Gravity.LEFT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
