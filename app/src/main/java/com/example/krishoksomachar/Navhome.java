package com.example.krishoksomachar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Navhome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        ,Cropdetails.Cropdetailsinterface
        ,Cropchild.onauthCropchild
        ,Cropdises.ondeasesinterface{

    private Button cropbtn;
    private ImageButton camerabtn;
    private Context context;
    private FragmentManager manager;
    private Fragment fragment = null;


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

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action",
//                        Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                manager.beginTransaction().replace(R.id.content_fragment,new ImageGallery()).addToBackStack("nav").commit();
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
