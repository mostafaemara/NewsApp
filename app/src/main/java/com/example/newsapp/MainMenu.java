package com.example.newsapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.newsapp.Data.Article;
import com.example.newsapp.Data.Articles;
import com.example.newsapp.Data.ConstantVariables;
import com.example.newsapp.Data.NewsApi;
import com.example.newsapp.Data.NewsApiInterFace;
import com.example.newsapp.Fragments.NewsFragment;
import com.hbb20.CountryCodePicker;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private TabLayout mTabLayout;


    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView mNavigationView;

    private  CountryCodePicker  countryCodePicker;

    String country = "us";
    String category = "general";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main_menu);
        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mTabLayout = findViewById(R.id.category_layout);
        countryCodePicker=findViewById(R.id.ccp);



        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        setSupportActionBar(mToolbar);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
        mToolbar.setTitle("MAIN MENU");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.tabtextcolors));


countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
    @Override
    public void onCountrySelected() {

        country=countryCodePicker.getSelectedCountryNameCode().toLowerCase();
       openNewsFragment();

    }
});


        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

category=ConstantVariables.CATEGORY[tab.getPosition()];
            openNewsFragment();


            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        if (savedInstanceState == null) {

      openNewsFragment();


        }


    }


    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {


            mDrawerLayout.closeDrawer(GravityCompat.START);

        } else {

            super.onBackPressed();

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()) {

            case (R.id.business):


                break;

            case (R.id.general):


                break;

            case (R.id.science):

                break;

            case (R.id.sports):


                break;

            case (R.id.technology):

                break;


        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openNewsFragment(){
        Fragment fragment;


        fragment = new NewsFragment();

        ((NewsFragment) fragment).setmCategory(category);
        ((NewsFragment) fragment).setmCountery(country);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();



    }
}
