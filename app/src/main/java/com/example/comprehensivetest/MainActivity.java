package com.example.comprehensivetest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.comprehensivetest.Frag.Fragment1;
import com.example.comprehensivetest.Frag.Fragment2;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;


public class MainActivity extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        if (bottomNavigationView != null) {
            bottomNavigationView.isWithText(true);
            bottomNavigationView.isColoredBackground(true);
            bottomNavigationView.disableShadow();
            bottomNavigationView.setItemActiveColorWithoutColoredBackground(getResources().getColor(R.color.secondColor));
        }

        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                ("水果", getResources().getColor(R.color.secondColor), R.drawable.ic_mic_black_24dp);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                ("收藏", getResources().getColor(R.color.secondColor), R.drawable.ic_favorite_black_24dp);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                ("上大", getResources().getColor(R.color.secondColor), R.drawable.ic_shu_24dp);
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem
                ("Github", getResources().getColor(R.color.secondColor), R.drawable.github_circle);

        bottomNavigationView.addTab(bottomNavigationItem);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);
        bottomNavigationView.addTab(bottomNavigationItem3);


        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                Toast.makeText(MainActivity.this, "Item " + index + " clicked", Toast.LENGTH_SHORT).show();
                switch (index) {
                    case 0:
                        chickFragment1();
                        break;
                    case 1:
                        chickFragment2();
                        break;
                    case 2:
//                                chickFragment1();
                        break;
                    case 3:
//                                chickFragment1();
                        break;
                }
            }
        });

    }

    private void chickFragment1() {
        fragment1 = new Fragment1();
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag_content, fragment1);
        fragmentTransaction.commit();
    }

    private void chickFragment2() {
        fragment2 = new Fragment2();
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag_content, fragment2);
        fragmentTransaction.commit();
    }
}