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
    import android.widget.Toast;

    import java.io.File;
    import java.io.IOException;



    public class Navhome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
            ,Cropdetails.Cropdetailsinterface
            ,Cropchild.onauthCropchild
            ,Cropdises.ondeasesinterface{

        private static final int REQUEST_IMAGE_CAPTURE =1 ;
        private static final int REQUEST_STORAGE_ACCESS =2 ;
        private FragmentManager manager;
        private Fragment fragment = null;
        private File photoFile;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_navhome);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            manager = getSupportFragmentManager();
            fragment = new Cropdetails();
            if (fragment != null) {
                manager.beginTransaction().replace(R.id.content_fragment, fragment).commit();
            }
            checkStoragePermission();
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(Navhome.this.getPackageManager()) != null) {
                        photoFile = null;
                        try {
                            photoFile = createImageFile();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        if (photoFile != null) {

                            Uri fileUri = FileProvider.getUriForFile(Navhome.this, "com.example.krishoksomachar", photoFile);
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);


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

        // Camera  image upload to Firbase Storage.
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){

                galleryAddPic();

                final StorageReference rootRef = FirebaseStorage.getInstance().getReference();
                Uri fileUri = Uri.fromFile(photoFile);
                final StorageReference photoRef = rootRef.child("images/"+fileUri.getLastPathSegment());

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

                    }
                });
            }
        }

        // Camer take Permission Code.

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


    // Create Image file name and extension such : example_.jpg
        String mCurrentPhotoPath;
        private File createImageFile() throws IOException {
            File storageDir = Environment.getExternalStorageDirectory();
            File image = File.createTempFile(
                    "example",  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
            mCurrentPhotoPath = image.getAbsolutePath();
            return image;
        }

        //Gallery add picture
        private void galleryAddPic() {
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            File f = new File(mCurrentPhotoPath);
            Uri contentUri = Uri.fromFile(f);
            mediaScanIntent.setData(contentUri);
            this.sendBroadcast(mediaScanIntent);
        }


        //Navigation work optionsMenu and Navigation Item
        @Override
        public void onBackPressed() {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//
//            getMenuInflater().inflate(R.menu.search, menu);
//            return true;
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            int id = item.getItemId();
//
//            if (id == R.id.search) {
//                Toast.makeText(this,"search",Toast.LENGTH_LONG).show();
//                return true;
//            }
//            return super.onOptionsItemSelected(item);
//        }


        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            int id = item.getItemId();

            if (id == R.id.nav_home) {
               manager.beginTransaction().replace(R.id.content_fragment,new Cropdetails()).commit();
            } else if (id == R.id.nav_info) {
                manager.beginTransaction().replace(R.id.content_fragment,new Cropchild()).commit();
            } else if (id == R.id.nav_about) {
                Toast.makeText(this, "দয়া করে আপনার সম্পকর্ে কিছু বলুন", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_use) {
                Toast.makeText(this, "দয়া করে ব্যবহারবিধি সংযোগ করুন", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_careful) {
                Toast.makeText(this, "দয়া করে সতর্কবার্ত সংযোগ করুন", Toast.LENGTH_SHORT).show();
            }else if (id == R.id.nav_ask) {
                Toast.makeText(this, "দয়া করে জিজ্ঞাসা করুন", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.nav_communication) {
                Toast.makeText(this, "যোগাযোগ পৃষ্ঠা সংযোগ করুন", Toast.LENGTH_SHORT).show();
            }else if (id == R.id.nav_login) {

            }else if (id == R.id.nav_rating) {
                Toast.makeText(this, "দয়া করে রেটিং দিন", Toast.LENGTH_SHORT).show();
            }else if (id == R.id.nav_share) {
                Toast.makeText(this, "শেয়ার করুন", Toast.LENGTH_SHORT).show();
            }else if (id == R.id.nav_out) {
                Toast.makeText(this, "অ্যাপ থেকে চলে যাবেন?? পৃষ্ঠা ‍সংযোগ করুন", Toast.LENGTH_SHORT).show();
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
