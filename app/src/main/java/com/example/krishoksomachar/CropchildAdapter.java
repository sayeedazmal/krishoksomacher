package com.example.krishoksomachar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishoksomachar.Pojoclass.CropchdetailsData;

import java.util.List;

public class CropchildAdapter extends RecyclerView.Adapter<CropchildAdapter.Childviewholder> {

         private Context context;
         private List<CropchdetailsData> chdetailsList;
         private setOnclickChild childlistener;


    public CropchildAdapter(Context context, List<CropchdetailsData> chdetailsList, Fragment fragment) {
        this.context = context;
        this.chdetailsList = chdetailsList;
        childlistener = (setOnclickChild) fragment;
    }

    @NonNull
    @Override
    public Childviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View chView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cropchild_rowitem, parent, false);

        return new Childviewholder(chView);
    }

    @Override
    public void onBindViewHolder(@NonNull Childviewholder holder, final int position) {

        holder.chImage.setImageResource(chdetailsList.get(position).getChildImage());
        holder.tvTextView.setText(chdetailsList.get(position).getName());
        holder.chImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item"+position, Toast.LENGTH_SHORT).show();
                childlistener.onauthchild(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chdetailsList.size();
    }

    public class Childviewholder extends RecyclerView.ViewHolder{
        private ImageView chImage;
        private TextView tvTextView;

        public Childviewholder(@NonNull View itemView) {
            super(itemView);
            chImage = itemView.findViewById(R.id.ivImage);
            tvTextView = itemView.findViewById(R.id.tvTitle);
        }
    }

    interface setOnclickChild{
        void onauthchild(int position);
    }
}
