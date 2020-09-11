package com.example.mygadapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mygadapp.fragments.LearningLeadersFragment;
import com.example.mygadapp.fragments.SkillIQLeadersFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    private SectionPagerAdapter mSectionPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    private String[] tabTitles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);

        Button button = findViewById(R.id.submit);
        button.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

    }
    public class SectionPagerAdapter extends FragmentPagerAdapter {
        public SectionPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }
        @NotNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch(position){
                case 0 :
                    fragment = new LearningLeadersFragment();
                    break;
                case 1 :
                    fragment = new SkillIQLeadersFragment();
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }
            return fragment;
        }
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0 :
                    return "Learning Leaders";

                case 1 :
                    return "skill IQ leaders";
                default :
                    return null ;
            }

        }
    }
}
