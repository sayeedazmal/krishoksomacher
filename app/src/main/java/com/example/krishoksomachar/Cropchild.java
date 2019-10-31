package com.example.krishoksomachar;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;


import com.example.krishoksomachar.AllAdapter.CropchildAdapter;
import com.example.krishoksomachar.Pojoclass.CropchdetailsData;

import java.util.ArrayList;
import java.util.List;


public class Cropchild extends Fragment implements CropchildAdapter.setOnclickChild {

    private Context context;
    private onauthCropchild cropchildlistener;
    private RecyclerView chRecycler;
    private List<CropchdetailsData> listofChild;
    private CropchdetailsData chData;
    private CropchildAdapter myAdapter;

    public Cropchild() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle(R.string.disescrop);
        getActivity().supportInvalidateOptionsMenu();

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
      chRecycler.setHasFixedSize(true);
      myAdapter = new CropchildAdapter(getActivity(),listofChild,Cropchild.this);
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

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.search,menu);
//        MenuItem searchItem = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//           @Override
//           public boolean onQueryTextSubmit(String s) {
//               return false;
//           }
//
//           @Override
//           public boolean onQueryTextChange(String s) {
//               myAdapter.getFilter().filter(s);
//               return false;
//           }
//       });
//    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem searchItem = menu.findItem(R.id.searchitem);
        SearchView searchView  = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    public  interface onauthCropchild{
        void oncropchild(int position);
    }
}
