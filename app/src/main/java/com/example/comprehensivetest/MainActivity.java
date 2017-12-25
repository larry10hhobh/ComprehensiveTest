package com.example.comprehensivetest;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;


public class MainActivity extends AppCompatActivity implements OnBottomNavigationItemClickListener {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private FragmentTransaction mFragmentTransaction;
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
            bottomNavigationView.setItemActiveColorWithoutColoredBackground(getResources().getColor(R.color.fourthColor));
        }
        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                ("水果", getResources().getColor(R.color.fourthColor), R.drawable.ic_mic_black_24dp);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                ("二维码", getResources().getColor(R.color.fourthColor), R.drawable.ic_favorite_black_24dp);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                ("上大", getResources().getColor(R.color.fourthColor), R.drawable.ic_shu_24dp);
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem
                ("Github", getResources().getColor(R.color.fourthColor), R.drawable.github_circle);

        bottomNavigationView.addTab(bottomNavigationItem);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);
        bottomNavigationView.addTab(bottomNavigationItem3);
        bottomNavigationView.setOnBottomNavigationItemClickListener(this);

    }

    @Override
    public void onNavigationItemClick(int index) {
//        Toast.makeText(MainActivity.this, "Item " + index + " clicked", Toast.LENGTH_SHORT).show();
        //每次点击事件都会重新获取FragmentTransaction
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (index) {
            case 0:
                chickFragment1(mFragmentTransaction);
                break;
            case 1:
                chickFragment2(mFragmentTransaction);
                break;
        }
    }


    private void chickFragment1(FragmentTransaction fragmentTransaction) {
        if (fragment1 == null) {
            fragment1 = new Fragment1();
            fragmentTransaction.add(R.id.frag_content, fragment1);
//            fragmentTransaction.replace(R.id.frag_content, fragment1);
        }
        hideAllFragment(fragmentTransaction);
        fragmentTransaction.show(fragment1);
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    private void chickFragment2(FragmentTransaction fragmentTransaction) {
        if (fragment1 == null) {
            fragment2 = new Fragment2();
            fragmentTransaction.add(R.id.frag_content, fragment2);
//            fragmentTransaction.replace(R.id.frag_content,fragment2);
        }
        hideAllFragment(fragmentTransaction);
        fragmentTransaction.show(fragment2);
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    /**
     * 隐藏所有fragment
     *
     * @param fragmentTransaction
     */
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fragment1 != null) {
            fragmentTransaction.hide(fragment1);
        }
        if (fragment2 != null) {
            fragmentTransaction.hide(fragment2);
        }
    }
}