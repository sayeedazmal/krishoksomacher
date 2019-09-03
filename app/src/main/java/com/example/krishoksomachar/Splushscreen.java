package com.example.krishoksomachar;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Splushscreen extends Fragment {
    private TextView hello;
    private TextView krishok;
    int _splashTime = 3000;
    private Context context;

    public Splushscreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View splashScreen = inflater.inflate(R.layout.fragment_splushscreen, container, false);
        hello  = splashScreen.findViewById(R.id.hellobtn);
        krishok = splashScreen.findViewById(R.id.krishokbtn);
        final Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.homeanimation);
        hello.startAnimation(animation);
        krishok.startAnimation(animation);
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getActivity(),Navhome.class);
                startActivity(intent);
            }
        },_splashTime);

        return splashScreen;
    }

}
