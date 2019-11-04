package com.example.krishoksomachar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.example.krishoksomachar.Pojoclass.CheckDeases;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.security.PrivateKey;

public class Justifydeases extends AppCompatActivity {

    private TextView titleTv,descriptDeases;
    private ImageView justifyIv;
    private CheckDeases checkDeases;
    private String checkdesTitle;
    private Button upld,cncl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_justifydeases);

        titleTv = findViewById(R.id.tvTitle);
        descriptDeases = findViewById(R.id.deases_descripTv);
        justifyIv = findViewById(R.id.imgJustify);
        upld = findViewById(R.id.uploadBtn);
        cncl = findViewById(R.id.cancelBtn);
        upld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Justifydeases.this, "Upload successfully", Toast.LENGTH_SHORT).show();
            }
        });
        cncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        String imagepathname = bundle.getString("imagecapture");
        String photopath = bundle.getString("pohotopath");
        int requstCode = bundle.getInt("request_code");

        checkDeases = new CheckDeases();
//      titleTv.setText(photopath);


        Resources res = getResources();
        String[] desArray = res.getStringArray(R.array.deasesDscript);
        String[] desTitleArray = res.getStringArray(R.array.listoftitle);

        if(requstCode==1){
            Picasso.get().load(new File(photopath)).placeholder(R.drawable.fruite).fit().centerCrop().into(justifyIv);
            checkdesTitle = checkDeases.findLabel(photopath);
            titleTv.setText(checkdesTitle);

            for(int i =0; i<desArray.length; i++){
                if(desTitleArray[i].equals(checkdesTitle)){
                    descriptDeases.setText(desArray[i]);
                    break;
                }
            }
        }else{
            Picasso.get().load(new File(imagepathname)).placeholder(R.drawable.fruite).fit().centerCrop().into(justifyIv);
            checkdesTitle = checkDeases.findLabel(imagepathname);
            titleTv.setText(checkdesTitle);

            for(int i =0; i<desArray.length; i++){
                if(desTitleArray[i].equals(checkdesTitle)){
                    descriptDeases.setText(desArray[i]);
                    break;
                }
            }
        }



        }


}
