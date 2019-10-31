package com.example.krishoksomachar.AllAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishoksomachar.Pojoclass.Cropdetailsdata;
import com.example.krishoksomachar.R;

import java.util.List;

public class CropdetailsAdapter extends RecyclerView.Adapter<CropdetailsAdapter.CropviewHolder> {

private Context context;
private List<Cropdetailsdata> listofCrop;
private onImageClicklistener onlistener;

    public CropdetailsAdapter(Context context, List<Cropdetailsdata> listofCrop,Fragment fragment) {
        this.context = context;
        this.listofCrop = listofCrop;
        onlistener = (onImageClicklistener) fragment;
    }

    @NonNull
    @Override
    public CropviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.croprecycler_rowitem, parent, false);
        return new CropviewHolder(mView);

    }

    @Override
    public void onBindViewHolder(@NonNull CropviewHolder holder, final int position) {

        final Cropdetailsdata data = listofCrop.get(position);
//        Picasso.get()
//                .load(listofCrop.get(position).getCropImage())
//                .placeholder(R.mipmap.ic_launcher)
//                .fit()
//                .centerCrop()
//                .into(holder.mImage);
        holder.mImage.setImageResource(listofCrop.get(position).getCropImage());
        holder.mTitle.setText(listofCrop.get(position).getName());

        holder.mImage.setOnClickListener(new View.OnClickListener() {
            String crop = listofCrop.get(position).getName();
            @Override
            public void onClick(View view) {
                onlistener.onAuthClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listofCrop.size();
    }

    class CropviewHolder extends RecyclerView.ViewHolder{

        ImageView mImage;
        TextView mTitle;
        public CropviewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.ivImage);
            mTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

    public interface onImageClicklistener{
        void onAuthClick(int position);
    }

}
