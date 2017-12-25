package com.example.comprehensivetest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.comprehensivetest.MainActivity;
import com.example.comprehensivetest.QRcodeActivity;
import com.example.comprehensivetest.R;
import com.example.comprehensivetest.zxing.activity.CaptureActivity;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;

public class Fragment2 extends Fragment implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qrcode_frag, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.qrcode_button1);
        Button button2 = (Button) getActivity().findViewById(R.id.qrcode_button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qrcode_button1:
                Toast.makeText(getActivity(), "扫描二维码1", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), QRcodeActivity.class);
                startActivity(intent);
                break;
            case R.id.qrcode_button2:
                Toast.makeText(getActivity(), "扫描二维码2", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(getActivity(), CaptureActivity.class);
                startActivity(intent2);
                break;
        }

    }
}
