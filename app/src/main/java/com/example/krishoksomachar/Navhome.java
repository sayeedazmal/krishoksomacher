package com.example.krishoksomachar;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import android.view.Menu;
import android.widget.Button;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Navhome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        ,Cropdetails.Cropdetailsinterface
        ,Cropchild.onauthCropchild
        ,Cropdises.ondeasesinterface{

    private static final int REQUEST_IMAGE_CAPTURE =1 ;
    private static final int REQUEST_STORAGE_ACCESS =2 ;
    private Button cropbtn;
    private Context context;
    private FragmentManager manager;
    private Fragment fragment = null;


    private File imageFile = null;
    private String filePath;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navhome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        manager = getSupportFragmentManager();

        fragment = new Cropdetails();
        if(fragment!=null){
            manager.beginTransaction().replace(R.id.content_fragment,fragment).commit();
        }
        checkStoragePermission();
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(Navhome.this.getPackageManager())
                        != null){
                    try {
                        imageFile = createImageFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(imageFile != null){
                        Uri fileUri = FileProvider.getUriForFile(Navhome.this,
                                "com.example.krishoksomachar",
                                imageFile);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                    }

                }
            }


        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE &&
                resultCode == Activity.RESULT_OK){

            final StorageReference rootRef =
                    FirebaseStorage.getInstance().getReference();
            Uri fileUri = Uri.fromFile(imageFile);
            final StorageReference photoRef =
                    rootRef.child("images/"+fileUri.getLastPathSegment());

            UploadTask uploadTask = photoRef.putFile(fileUri);
            Task<Uri> uriTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful()){
                        throw task.getException();
                    }
                    return photoRef.getDownloadUrl();
                }
            });
            uriTask.addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    Uri downloadUri = task.getResult();
                    //stop progressbar
//                    Picasso.get().load(downloadUri).into(iv);
                }
            });
        }
    }


    private boolean checkStoragePermission(){
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_STORAGE_ACCESS);
            return false;
        }

        return true;
    }

    private File createImageFile()  throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
        String imageFileName = "JPEG_"+timeStamp;
        File dir = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = File.createTempFile(imageFileName, ".jpg", dir);
        filePath = file.getAbsolutePath();
        return file;
    }

//Navigation work
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.navhome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.power) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_info) {

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_use) {

        } else if (id == R.id.nav_careful) {

        }else if (id == R.id.nav_ask) {

        }
        else if (id == R.id.nav_communication) {

        }else if (id == R.id.nav_login) {

        }else if (id == R.id.nav_rating) {

        }else if (id == R.id.nav_share) {

        }else if (id == R.id.nav_out) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void oncropdetails() {
        manager.beginTransaction().replace(R.id.content_fragment,new Cropchild()).addToBackStack("Cropdetails").commit();
    }

    @Override
    public void oncropchild(int position) {
        manager.beginTransaction().replace(R.id.content_fragment,new Cropdises(position)).addToBackStack("Cropdetails").commit();
    }

    @Override
    public void onauthdeasesmethod(String deasname) {
        manager.beginTransaction().replace(R.id.content_fragment,new CropdeseasDetails(deasname)).addToBackStack("Cropdetails").commit();
    }
}
