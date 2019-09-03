package com.example.krishoksomachar;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.krishoksomachar.Pojoclass.CropchdetailsData;

import java.util.ArrayList;
import java.util.List;


public class Cropchild extends Fragment implements CropchildAdapter.setOnclickChild {

    private Context context;
    private onauthCropchild cropchildlistener;
    private RecyclerView chRecycler;
    private List<CropchdetailsData> listofChild;
    private CropchdetailsData chData;

    public Cropchild() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
       cropchildlistener = (onauthCropchild) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_cropchild, container, false);

      listofChild = new ArrayList<>();
      String[] crpname  ={"ধান","পাট","গম","ভুট্টা","আখ","সুগারবিট","মিষ্ট আলু","তুলা","ছোলা","সরিষা","চিনাবাদাম","সয়াবিন","মসুর"};

      listofChild.add(new CropchdetailsData(crpname[0],R.drawable.ricefield1));
      listofChild.add(new CropchdetailsData(crpname[1],R.drawable.ricefield1));
      listofChild.add(new CropchdetailsData(crpname[2],R.drawable.ricefield1));
      listofChild.add(new CropchdetailsData(crpname[3],R.drawable.ricefield1));
      listofChild.add(new CropchdetailsData(crpname[4],R.drawable.ricefield1));
      listofChild.add(new CropchdetailsData(crpname[5],R.drawable.flower));
      listofChild.add(new CropchdetailsData(crpname[6],R.drawable.flower));
      listofChild.add(new CropchdetailsData(crpname[7],R.drawable.flower));
      listofChild.add(new CropchdetailsData(crpname[8],R.drawable.flower));
      listofChild.add(new CropchdetailsData(crpname[9],R.drawable.flower));
      listofChild.add(new CropchdetailsData(crpname[10],R.drawable.flower));
      listofChild.add(new CropchdetailsData(crpname[11],R.drawable.flower));
      listofChild.add(new CropchdetailsData(crpname[12],R.drawable.flower));

      chRecycler = view.findViewById(R.id.recyclerviewChild);
      CropchildAdapter myAdapter = new CropchildAdapter(getActivity(),listofChild,Cropchild.this);
      chRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
      chRecycler.setAdapter(myAdapter);

      return view;
    }

    @Override
    public void onauthchild(int position) {
        switch (position){
            case 0: cropchildlistener.oncropchild(position); break;
            case 1: cropchildlistener.oncropchild(position); break;
            case 2: cropchildlistener.oncropchild(position); break;
            case 3: cropchildlistener.oncropchild(position); break;
            case 4: cropchildlistener.oncropchild(position); break;
            case 5: cropchildlistener.oncropchild(position); break;
            case 6: cropchildlistener.oncropchild(position); break;
            case 7: cropchildlistener.oncropchild(position); break;
            case 8: cropchildlistener.oncropchild(position); break;
        }
    }

    public  interface onauthCropchild{
        void oncropchild(int position);
    }
}
