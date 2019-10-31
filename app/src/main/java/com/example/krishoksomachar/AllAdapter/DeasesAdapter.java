package com.example.krishoksomachar.AllAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishoksomachar.Pojoclass.DeasesData;
import com.example.krishoksomachar.R;

import java.util.List;

public class DeasesAdapter extends RecyclerView.Adapter<DeasesAdapter.deasesViewholder> {

    private Context context;
    private List<DeasesData> listdeases;
    private ondeasesClick deaseslistener;
    private Fragment fragment;


    public DeasesAdapter(Context context, List<DeasesData> listdeases,Fragment fragment) {
        this.context = context;
        this.listdeases = listdeases;
        deaseslistener = (ondeasesClick) fragment;
    }

    @NonNull
    @Override
    public deasesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View dview = LayoutInflater.from(parent.getContext()).inflate(R.layout.cropdises_rowitem, parent, false);
        return new deasesViewholder(dview);
    }

    @Override
    public void onBindViewHolder(@NonNull deasesViewholder holder, final int position) {
            holder.imagebtn.setImageResource(listdeases.get(position).getImagename());

            holder.imagebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String deasname = listdeases.get(position).getDeasesname();
                    deaseslistener.onauthdeases(position,deasname);

                }
            });
    }

    @Override
    public int getItemCount() {
        return listdeases.size();
    }

    public class deasesViewholder extends RecyclerView.ViewHolder {
        private ImageView imagebtn;

        public deasesViewholder(@NonNull View itemView) {
            super(itemView);
            imagebtn = itemView.findViewById(R.id.btnImage);
        }
    }

   public interface ondeasesClick{
        void onauthdeases(int position,String deasesname);
    }
}
