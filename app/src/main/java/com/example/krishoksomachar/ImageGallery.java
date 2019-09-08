package com.example.krishoksomachar;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.krishoksomachar.Pojoclass.ImgeSourceData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class ImageGallery extends Fragment {


    private static final int RESULT_OK = 1;

    public ImageGallery() {

    }

    private Context context;


    private static final int REQUEST_CODE = 1;
    private boolean mStoragePermissions;
    private List<ImgeSourceData> imageLists;
    private GalleryimgAdapter adapter;
    private RecyclerView rec;
    private File[] imageList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image_gallery, container, false);
        rec = view.findViewById(R.id.imgRecycler);
        rec.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter = new GalleryimgAdapter(getActivity(), getData());
        rec.setAdapter(adapter);

        return view;
    }

    public List<ImgeSourceData> getData(){

        imageLists = new ArrayList<>();

        File downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        ImgeSourceData imgsData;
        try {
            if (downloadFolder.exists()) {
                File[] files = downloadFolder.listFiles();

                for (int i = 0; i <files.length; i++) {
                    File file = files[i];
                    imgsData = new ImgeSourceData();
                    imgsData.setUri(Uri.fromFile(file));
                    imageLists.add(imgsData);
                }
            }
        }catch(Exception e){

                Toast.makeText(getActivity(), "error " + e, Toast.LENGTH_SHORT).show();
            }



        return imageLists;
    }

}
