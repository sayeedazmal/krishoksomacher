package com.example.krishoksomachar;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishoksomachar.AllAdapter.DeasesAdapter;
import com.example.krishoksomachar.Pojoclass.DeasesData;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cropdises extends Fragment implements DeasesAdapter.ondeasesClick{

private List<DeasesData> listofdeases;
private RecyclerView d_recyclerview;
private Context context;
private ondeasesinterface ondeslistener;

    private int position;
    public Cropdises() {
        // Required empty public constructor
    }

    public Cropdises(int position){
        this.position = position;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        ondeslistener = (ondeasesinterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cropdises, container, false);

        listofdeases = new ArrayList<>();
//        ArrayList<String> arrayList = new ArrayList<>();
        String[] ricedeases  = {"ধানের পাতা মোড়ানো পোকা","ব্যাকটেরিয়াজনিত পাতা পোড়া রোগ"
                                ,"ব্যাটেরিয়াজনিত পাতা পোড়া রোগ","ধানের পাতা মোড়ানো পোকা"
                                ,"ব্যাটেরিয়াজনিত পাতা পোড়া রোগ","ধানের পাতা মোড়ানো পোকা"
                                ,"ধানের পাতা মোড়ানো পোকা"};
        String[] ricedeases1  = {"ব্যাটেরিয়াজনিত পাতা পোড়া রোগ","ব্যাকটেরিয়াজনিত পাতা পোড়া রোগ"
                ,"ব্যাটেরিয়াজনিত পাতা পোড়া রোগ","ধানের পাতা মোড়ানো পোকা"
                ,"ব্যাটেরিয়াজনিত পাতা পোড়া রোগ","ধানের পাতা মোড়ানো পোকা"
                ,"ধানের পাতা মোড়ানো পোকা"};
//        arrayList.add(ricedeases[0]);
//        arrayList.add(ricedeases[1]);
//        arrayList.add(ricedeases[2]);
//        arrayList.add(ricedeases[3]);
//        arrayList.add(ricedeases[4]);
//        arrayList.add(ricedeases[5]);
//        arrayList.add(ricedeases[6]);
//        arrayList.add(ricedeases[7]);

//        Bundle bundle = new Bundle();
//        bundle.putStringArrayList("key", arrayList);

        switch (position){

            case 0:
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[0]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[1]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases[2]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[3]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases[4]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[5]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[6]));
                break;
            case 1:
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[0]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[1]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases1[2]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases1[3]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases1[4]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases1[5]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[6]));
                break;
            case 2:
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[0]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[1]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases[2]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[3]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases[4]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[5]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[6]));
                break;
            case 3:
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[0]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[1]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases1[2]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases1[3]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases1[4]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases1[5]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[6]));
                break;
            case 4:
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[0]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[1]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases[2]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[3]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases[4]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[5]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[6]));
                break;
            case 5:
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[0]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[1]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases1[2]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases1[3]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases1[4]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases1[5]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases1[6]));
                break;
            case 6:
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[0]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[1]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases[2]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[3]));
                listofdeases.add(new DeasesData(R.drawable.lico,ricedeases[4]));
                listofdeases.add(new DeasesData(R.drawable.fruite,ricedeases[5]));
                listofdeases.add(new DeasesData(R.drawable.fruite2,ricedeases[6]));
                break;
        }

        d_recyclerview = view.findViewById(R.id.disesRecylerView);
        DeasesAdapter myAdapter = new DeasesAdapter(getActivity(), listofdeases,Cropdises.this);
        d_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        d_recyclerview.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onauthdeases(int position,String deasname) {
        switch (position){
            case 0:
               ondeslistener.onauthdeasesmethod(deasname);
                break;
            case 1:
                break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7: break;
            case 8: break;
            case 9: break;
            case 10: break;
            case 11: break;

        }
    }
    interface ondeasesinterface{
        void onauthdeasesmethod(String deasname);

    }

//    interface ondatapass{
//        void onauthdata(String[] ricedeases);
//    }
}
