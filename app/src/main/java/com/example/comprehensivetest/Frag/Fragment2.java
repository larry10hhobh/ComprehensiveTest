package com.example.comprehensivetest.Frag;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comprehensivetest.R;

public class Fragment2 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.two_dimension_code_frag, null);
        return view;
    }
}