package com.example.luigi.secondfragmentexercise;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThirdFragment extends Fragment{
    OnButtonClickInterface mCallback;
    String FORWARD="forward";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.third_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button button = (Button) view.findViewById(R.id.back_button3);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mCallback.onButtonClicked(0,3);

            }
        });

        Button doubleButton = (Button) view.findViewById(R.id.double_back_button3);

        doubleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mCallback.onButtonClicked(2,3);
            }
        });
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnButtonClickInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnButtonClickInterface");
        }
    }
}
