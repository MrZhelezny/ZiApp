package com.zhelezny.ziapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.zhelezny.ziapp.R;

public class MainActivity extends AppCompatActivity {
    String animal_1 = "dog";
    String animal_2 = "cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(animal_1));
        tabLayout.addTab(tabLayout.newTab().setText(animal_2));

        AnimalFragment defaultAnimal = new AnimalFragment();
        defaultAnimal.setKindOfAnimal(this, animal_1);
        replaceFragment(defaultAnimal);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                AnimalFragment fragmentAnimal = new AnimalFragment();
                if (tab.getPosition() == 0) {
                    fragmentAnimal.setKindOfAnimal(MainActivity.this, animal_1);
                } else if (tab.getPosition() == 1) {
                    fragmentAnimal.setKindOfAnimal(MainActivity.this, animal_2);
                }
                replaceFragment(fragmentAnimal);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}