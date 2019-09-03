package com.example.krishoksomachar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.krishoksomachar.Pojoclass.Cropdetailsdata;

import java.util.ArrayList;
import java.util.List;


public class Cropdetails extends Fragment implements CropdetailsAdapter.onImageClicklistener {

    private  RecyclerView mRecyclerView;
    private  List<Cropdetailsdata> listCropdata;
    private  Cropdetailsdata mCropdetaildata;
    private Context context;
    private Cropdetailsinterface crpdListener;

    public Cropdetails() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        crpdListener = (Cropdetailsinterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cropdetails, container, false);

        String[] cpdetails= {"মাঠ ফসল","ফল","ফুল","শাক-সবজি","মসলা","অন্যান্য ফসল"};

        listCropdata = new ArrayList<>();

        listCropdata.add(new Cropdetailsdata(cpdetails[0],R.drawable.flower));
        listCropdata.add(new Cropdetailsdata(cpdetails[1],R.drawable.flower));
        listCropdata.add(new Cropdetailsdata(cpdetails[2],R.drawable.flower));
        listCropdata.add(new Cropdetailsdata(cpdetails[3],R.drawable.flower));
        listCropdata.add(new Cropdetailsdata(cpdetails[4],R.drawable.ricefield1));
        listCropdata.add(new Cropdetailsdata(cpdetails[5],R.drawable.ricefield1));

        mRecyclerView = view.findViewById(R.id.recyclerview);
        CropdetailsAdapter myAdapter = new CropdetailsAdapter(getActivity(), listCropdata,Cropdetails.this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerView.setAdapter(myAdapter);

        return view;
    }

    @Override
    public void onAuthClick(int position) {
        switch (position){
            case 0:
                Toast.makeText(getActivity(), "Array ["+position+"]", Toast.LENGTH_SHORT).show();
                crpdListener.oncropdetails();
                break;
            case 1:  break;
            case 2:  break;
            case 3:  break;
            case 4:  break;
            case 5:  break;
            case 6:  break;
            case 7:  break;
            case 8:  break;

        }
    }
    interface Cropdetailsinterface{
        void oncropdetails();
    }
}
