package com.example.smc_cuuzy.test.activities;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.fragments.CallsFragment;
import com.example.smc_cuuzy.test.fragments.ChatsFragment;
import com.example.smc_cuuzy.test.fragments.SelectStatusFragment;
import com.example.smc_cuuzy.test.helpers.Main;


public class MainActivity extends AppCompatActivity{
    public TabLayout tabLayout;
    Toolbar toolbar;
    int toolbarMargin;
    FloatingActionButton fab;
    Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Re-enter transition is executed when returning to this activity
            Slide slideTransition = new Slide();
            slideTransition.setSlideEdge(Gravity.START);
            slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            getWindow().setReenterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
        }
    }

    /**
     * method to initialize our views
     */
    public void initUI() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  FAB margin needed for animation
        toolbarMargin = getResources().getDimensionPixelSize(R.dimen.fab_margin);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setCurrentItem(0);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.getTabAt(1).setCustomView(R.layout.custom_tab_chats);
        //tabLayout.getTabAt(2).setCustomView(R.layout.custom_tab_status);
        tabLayout.getTabAt(2).setCustomView(R.layout.custom_tab_calls);
        tabLayout.getChildAt(0).getLayoutParams().width = 10;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            findViewById(R.id.callCounter).setBackground(Main.getDrawable(MainActivity.this, R.drawable.bg_circle_tab_counter_unselected));
        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            findViewById(R.id.statusDot).setBackground(Main.getDrawable(MainActivity.this, R.drawable.ic_dot_unselected));
//        }
        ((TextView) findViewById(R.id.titleCalls)).setTextColor(Main.getColor(this, R.color.colorUnSelected));
//        ((TextView) findViewById(R.id.titleStatus)).setTextColor(Main.getColor(this, R.color.colorUnSelected));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        toolbar.setVisibility(View.GONE);
                        tabLayout.setVisibility(View.GONE);
                        fab.setVisibility(View.GONE);
                        break;
                    case 1:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            findViewById(R.id.chatCounter).setBackground(Main.getDrawable(MainActivity.this, R.drawable.bg_circle_tab_counter));
                        }
                        ((TextView) findViewById(R.id.titleChats)).setTextColor(Main.getColor(MainActivity.this, R.color.white));
                        fab.setVisibility(View.VISIBLE);
                        fab.setImageResource(R.drawable.ic_action_chat);
                        fab.setOnClickListener(v -> {
                            mIntent = new Intent(MainActivity.this, SelectContactActivity.class);
                            startActivity(mIntent);
                        });
                        break;
//                    case 2:
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                            findViewById(R.id.statusDot).setBackground(Main.getDrawable(MainActivity.this, R.drawable.ic_dot_white));
//                        }
//                        ((TextView) findViewById(R.id.titleStatus)).setTextColor(Main.getColor(MainActivity.this, R.color.white));
//                        fab.setVisibility(View.VISIBLE);
//                        fab.setImageResource(R.drawable.shape_circle_plus);
//                        fab.setOnClickListener(v -> {
//                        });
//                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        toolbar.setVisibility(View.VISIBLE);
                        tabLayout.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            findViewById(R.id.chatCounter).setBackground(Main.getDrawable(MainActivity.this, R.drawable.bg_circle_tab_counter_unselected));
                        }
                        ((TextView) findViewById(R.id.titleChats)).setTextColor(Main.getColor(MainActivity.this, R.color.colorUnSelected));
                        fab.setVisibility(View.VISIBLE);
                        fab.setImageResource(R.drawable.ic_action_chat);
                        break;
//                    case 2:
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                            findViewById(R.id.statusDot).setBackground(Main.getDrawable(MainActivity.this, R.drawable.ic_dot_unselected));
//                        }
//                        ((TextView) findViewById(R.id.titleStatus)).setTextColor(Main.getColor(MainActivity.this, R.color.colorUnSelected));
//                        fab.setVisibility(View.VISIBLE);
//                        fab.setImageResource(R.drawable.shape_circle_plus);
//                        break;
                    case 2:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            findViewById(R.id.callCounter).setBackground(Main.getDrawable(MainActivity.this, R.drawable.bg_circle_tab_counter_unselected));
                        }
                        ((TextView) findViewById(R.id.titleCalls)).setTextColor(Main.getColor(MainActivity.this, R.color.colorUnSelected));
                        fab.setVisibility(View.VISIBLE);
                        fab.setImageResource(R.drawable.phone_plus);
                        break;
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        toolbar.setVisibility(View.GONE);
                        tabLayout.setVisibility(View.GONE);
                        break;
                    case 1:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            findViewById(R.id.chatCounter).setBackground(Main.getDrawable(MainActivity.this, R.drawable.bg_circle_tab_counter));
                        }
                        ((TextView) findViewById(R.id.titleChats)).setTextColor(Main.getColor(MainActivity.this, R.color.white));
                        fab.setVisibility(View.VISIBLE);
                        fab.setImageResource(R.drawable.ic_action_chat);
                        break;
//                    case 2:
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                            findViewById(R.id.statusDot).setBackground(Main.getDrawable(MainActivity.this, R.drawable.ic_dot_white));
//                        }
//                        ((TextView) findViewById(R.id.titleStatus)).setTextColor(Main.getColor(MainActivity.this, R.color.white));
//                        fab.setVisibility(View.VISIBLE);
//                        fab.setImageResource(R.drawable.shape_circle_plus);
//                        break;
                    case 2:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            findViewById(R.id.callCounter).setBackground(Main.getDrawable(MainActivity.this, R.drawable.bg_circle_tab_counter));
                        }
                        ((TextView) findViewById(R.id.titleCalls)).setTextColor(Main.getColor(MainActivity.this, R.color.white));
                        fab.setVisibility(View.VISIBLE);
                        fab.setImageResource(R.drawable.phone_plus);
                        break;
                }

            }
        });
        viewPager.setCurrentItem(1, false);
        setupTabIcons();
    }

    void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {

        ImageView camera = (ImageView) LayoutInflater.from(this).inflate(R.layout.custom_tab_icon, null);
        camera.setImageResource(R.drawable.ic_camera);
        tabLayout.getTabAt(0).setCustomView(camera);
        camera.setMaxWidth(R.dimen.statusbar_size);
    }

    /**
     * ViewPagerAdapter for our tab layout
     */
    private static class TabsPagerAdapter extends FragmentPagerAdapter {

        TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int num) {

            Fragment frag=null;
            switch (num) {
                case 0:
                    frag = new SelectStatusFragment();
                    break;

                case 1:
                    frag = new ChatsFragment();
                    break;

                case 2:
                    frag = new CallsFragment();
                    break;
            }
            return frag;
        }

        @Override
        public int getCount() {
            return 3;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                default: return null;
            }
        }
    }

}