package com.example.krishoksomachar;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishoksomachar.Pojoclass.ImgeSourceData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GalleryimgAdapter extends RecyclerView.Adapter<GalleryimgAdapter.ImageViewHolder>{
    private LayoutInflater inflater;
    private Context context;
    private List<ImgeSourceData> imgeList;

    public GalleryimgAdapter(Context context, List<ImgeSourceData> imgeList) {
        this.context = context;
        this.imgeList = imgeList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.galleryimg,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        ImgeSourceData imgData = imgeList.get(position);
        Picasso.get()
                .load(imgData.getUri())
                .placeholder(R.mipmap.ic_launcher_round)
                .fit()
                .centerCrop()
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return imgeList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgView;

        public ImageViewHolder(View itemView){
            super(itemView);
            imgView = itemView.findViewById(R.id.galleryImg);
        }
    }
}



