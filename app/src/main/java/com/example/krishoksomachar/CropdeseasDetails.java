package com.example.krishoksomachar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class CropdeseasDetails extends Fragment {

    private String desname;
    public CropdeseasDetails() {

    }


    public CropdeseasDetails(String desname){
        this.desname = desname;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_cropdeseas_details, container, false);

        TextView textView = view.findViewById(R.id.deases_detailsTv);
        textView.setText(desname);

//        Bundle bundle = getArguments();
//        ArrayList<String> arrayList = bundle.getStringArrayList("key");
//        for(String s:arrayList){
//            textView.setText(s);
//        }

        return view;
    }


}
