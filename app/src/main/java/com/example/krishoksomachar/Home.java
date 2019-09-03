package com.example.krishoksomachar;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Home extends Fragment implements View.OnClickListener {
    private Button cropbtn;
    private ImageButton camerabtn;
    private Context context;
    private onAuthhome onhomelistener;


    public Home() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        onhomelistener = (onAuthhome) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        cropbtn = view.findViewById(R.id.cropbtn);
        camerabtn = view.findViewById(R.id.btncamera);
        cropbtn.setOnClickListener(this);
        camerabtn.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cropbtn:
                onhomelistener.onhome();
                Toast.makeText(getActivity(), "this home fragment successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btncamera:
                break;


        }
    }

    interface onAuthhome{
        void onhome();
    }
}
