package com.example.dm2.actmenus2;

import android.content.ClipData;
import android.content.res.Resources;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources res = getResources();
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec=tabs.newTabSpec("1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Llamadas",
                res.getDrawable(R.drawable.ic_telefono));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Chats",
                res.getDrawable(R.drawable.ic_mensaje));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("3");
        spec.setIndicator("Contactos",
                res.getDrawable(R.drawable.ic_mas));
        spec.setContent(R.id.tab3);
        tabs.addTab(spec);
        tabs.setCurrentTab(0);
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                MenuItem it = menu.findItem(R.id.action_otro);
                switch (s){
                    case "1":
                        it.setIcon(R.drawable.ic_telefono);
                        break;
                    case "2":
                        it.setIcon(R.drawable.ic_mensaje);
                        break;
                    case "3":
                        it.setIcon(R.drawable.ic_mas);
                        break;
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_otro) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
