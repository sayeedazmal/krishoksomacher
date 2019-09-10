package com.example.krishoksomachar;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.krishoksomachar.Pojoclass.ImgeSourceData;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

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




    public ImageGallery() {

    }



    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_STORAGE_ACCESS = 2;

    private static final int REQUEST_CODE = 1;
    private boolean mStoragePermissions;
    private List<ImgeSourceData> imageLists;
    private GalleryimgAdapter adapter;
    private RecyclerView rec;
    private File[] imageList;
    private Context context;

    private ImageView iv;
    private File imageFile = null;
    private String filePath;
    private int requestCode,resultCode;
    private Intent data;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    public ImageGallery(int requestCode, int resultCode, Intent data){
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.data = data;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_image_gallery, container, false);
         iv = view.findViewById(R.id.iv);
         try {
            Picasso.get().load(String.valueOf(data)).placeholder(R.drawable.flower).into(iv);
             Toast.makeText(getActivity(),"error"+data,Toast.LENGTH_LONG).show();
         }catch (Exception e){
             Toast.makeText(getActivity(),"error"+e,Toast.LENGTH_LONG).show();
         }


        return view;
    }


//            @Override
//            public void onActivityResult(int requestCode, int resultCode, Intent data) {
//                super.onActivityResult(requestCode, resultCode, data);
//                if(requestCode == REQUEST_IMAGE_CAPTURE &&
//                        resultCode == Activity.RESULT_OK){
//                    //start progressbar
//
//
////            final StorageReference rootRef =
////                    FirebaseStorage.getInstance().getReference();
////            Uri fileUri = Uri.fromFile(imageFile);
////            final StorageReference photoRef =
////                    rootRef.child("images/"+fileUri.getLastPathSegment());
////
////            UploadTask uploadTask = photoRef.putFile(fileUri);
////
////            Task<Uri> uriTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
////                @Override
////                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
////                    if(!task.isSuccessful()){
////                        throw task.getException();
////                    }
////                    return photoRef.getDownloadUrl();
////                }
////            });
////            uriTask.addOnCompleteListener(new OnCompleteListener<Uri>() {
////                @Override
////                public void onComplete(@NonNull Task<Uri> task) {
////                    Uri downloadUri = task.getResult();
////                    Picasso.get().load(downloadUri).into(iv);
////                }
////            });
//
//        }
//    }


//
//    public void setPic() {
//        // Get the dimensions of the View
//        int targetW = iv.getWidth();
//        int targetH = iv.getHeight();
//
//        // Get the dimensions of the bitmap
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//        bmOptions.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(filePath, bmOptions);
//        int photoW = bmOptions.outWidth;
//        int photoH = bmOptions.outHeight;
//
//        // Determine how much to scale down the image
//        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);
//
//        // Decode the image file into a Bitmap sized to fill the View
//        bmOptions.inJustDecodeBounds = false;
//        bmOptions.inSampleSize = scaleFactor;
//        //bmOptions.inPurgeable = true;
//
//        Bitmap bitmap = BitmapFactory.decodeFile(filePath, bmOptions);
//        iv.setImageBitmap(bitmap);
//    }


//
//    public List<ImgeSourceData> getData(){
//
//        imageLists = new ArrayList<>();
//
//        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        ImgeSourceData imgsData;
//        try {
//            if (folder.exists()) {
//                File[] files = folder.listFiles();
//                for (int i = 0; i <files.length; i++) {
//                    File file = files[i];
//                    imgsData = new ImgeSourceData();
//                    imgsData.setUri(Uri.fromFile(file));
//                    imageLists.add(imgsData);
//                }
//            }
//        }catch(Exception e){
//
//                Toast.makeText(getActivity(), "error " + e, Toast.LENGTH_SHORT).show();
//            }
//        return imageLists;
//    }

}
