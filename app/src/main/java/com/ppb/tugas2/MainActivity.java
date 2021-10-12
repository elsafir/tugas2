package com.ppb.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ppb.tugas2.ui.exit.ExitFragment;
import com.ppb.tugas2.ui.home.HomeFragment;
import com.ppb.tugas2.ui.videoview.VideoViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }

    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case  R.id.navigation_videoview:
                    selectedFragment= new VideoViewFragment();
                    break;
                case R.id.navigation_exit:h:
                    selectedFragment = new ExitFragment();
                    break;
                default: break;
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return true;
        }
    };
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent moveIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(moveIntent);
                return true;
            case R.id.web:
                WebView webView = findViewById(R.id.web);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("https://www.instagram.com");
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                return true;
            case R.id.exit:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        this);
                alertDialogBuilder.setTitle("Keluar dari aplikasi?");
                alertDialogBuilder
                        .setMessage("Klik Ya untuk keluar!")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("Ya", (dialog, id) -> MainActivity.this.finish())
                        .setNegativeButton("Tidak", (dialog, id) -> dialog.cancel());

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();
        }
        return true;
    }
}
