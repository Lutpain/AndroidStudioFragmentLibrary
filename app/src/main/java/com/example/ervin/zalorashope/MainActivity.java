package com.example.ervin.zalorashope;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ervin.zalorashope.Fragment.ProfilkuFragment;
import com.example.ervin.zalorashope.Model.AlerterActivity;
import com.example.ervin.zalorashope.Model.TechToSpeechActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;

    private Toolbar mToolbar;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.buka, R.string.tutup);

        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    //memberikan perintah jika diklik akan pergi ke menu home
                    case R.id.nav_home:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new Home());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Halaman Utama");
                        item.setChecked(false);
                        mDrawerLayout.closeDrawers();
                        break;

                    //menggunakan intent untuk berpindah ke activity Calender
                    case R.id.nav_calender:
                        startActivity(new Intent(MainActivity.this, CalendarActivity.class));
                        item.setChecked(true);
                        break;

                    //menggunakan intent untuk berpindah ke activity Alerter
                    case R.id.nav_alerter:
                        startActivity(new Intent(MainActivity.this, AlerterActivity.class));
                        item.setChecked(true);
                        break;

                    //menggunakan intent untuk berpindah ke activity Text to speech
                    case R.id.nav_speech:
                        startActivity(new Intent(MainActivity.this, TechToSpeechActivity.class));
                        item.setChecked(true);
                        break;

                    //memberikan perintah jika diklik akan pergi ke menu tanggal
                    case R.id.nav_profilku:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.add(R.id.main_container, new ProfilkuFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Profil");
                        item.setChecked(false);
                        mDrawerLayout.closeDrawers();
                        break;

                    //menggunakan intent untuk berpindah ke activity profil
                    case R.id.nav_profil:
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        item.setChecked(true);
                        break;

                    //menggunakan intent untuk berpindah ke activity logout
                    case R.id.nav_logout:
                        startActivity(new Intent(MainActivity.this, LogoutActivity.class));
                        item.setChecked(true);
                        break;
                }

                return false;
            }
        });

    }

    //Membuat alertDialog jika mau keluar dari aplikasi
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder .setMessage("Apakah anda yakin untuk keluar ?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        moveTaskToBack(true);
                        System.exit(0);
                    }
                })
                .setNegativeButton("Tidak", null).setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
