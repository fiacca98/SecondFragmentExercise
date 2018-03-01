package com.example.luigi.secondfragmentexercise;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class MainActivity extends AppCompatActivity implements OnButtonClickInterface{

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transaction.add(R.id.fragmentContainer, firstFragment);
        transaction.addToBackStack("first");
        this.id = transaction.commit();


    }

    @Override
    public void onButtonClicked(int action, int currentFragment) {

        if(action == 0) {
            Log.d("back", "back");
            fragmentManager.popBackStack();
        }

        if (action == 2) {
            fragmentManager.popBackStack("first" ,0);
        }
        if(action == 1) {
            switch (currentFragment) {
                case 1:
                    transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragmentContainer, secondFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    break;
                case 2:
                    transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragmentContainer, thirdFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    break;
                }
        }
    }
}
