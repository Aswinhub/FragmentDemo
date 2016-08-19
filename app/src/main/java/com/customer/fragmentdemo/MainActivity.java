package com.customer.fragmentdemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.customer.fragmentdemo.adapters.Adapter_navlist;
import com.customer.fragmentdemo.fragments.Fragment1;
import com.customer.fragmentdemo.fragments.Fragment_tab;
import com.customer.fragmentdemo.fragments.Indicator;

public class MainActivity extends AppCompatActivity {

    String[] menu = {"list 1", "list 2", "list 3",};
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    ListView listView;
    LinearLayout linearLayout;
    ArrayAdapter<String> adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        drawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);

        navigationView = (NavigationView)findViewById(R.id.nv);
        //View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header);

        setupDrawerContent(navigationView);

        recyclerView = (RecyclerView)findViewById(R.id.rv_nl);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(new Adapter_navlist(this, menu));

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectDrawerItem(item);
                return true;
            }


        });
    }

    private void selectDrawerItem(MenuItem item) {
        Fragment fragment = null;
        Class fragmentclass = null;
        switch (item.getItemId()){
            case R.id.nav_first_fragment:
                fragmentclass = Fragment1.class;
                break;
            case R.id.nav_second_fragment:
                Toast.makeText(MainActivity.this, "second", Toast.LENGTH_SHORT).show();
                fragmentclass = Fragment_tab.class;
                break;
            case R.id.nav_third_fragment:
                fragmentclass = Indicator.class;
                Toast.makeText(MainActivity.this, "third", Toast.LENGTH_SHORT).show();
                break;
            default:
                fragmentclass = Fragment1.class;
        }
        try{
            fragment = (Fragment)fragmentclass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).addToBackStack("home").commit();

        item.setChecked(true);
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
