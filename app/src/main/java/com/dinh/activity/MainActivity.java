package com.dinh.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.dinh.fragment.HomeFragment;
import com.dinh.fragment.MusicFragment;
import com.dinh.fragment.ProfileFragment;
import com.dinh.fragment.YoutubeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navBottom;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //call xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defauFragment(new HomeFragment());
        addControls();
    }

    private void addControls() {
        navBottom = findViewById(R.id.navBottom);
        navBottom.setOnNavigationItemSelectedListener(this);
        navBottom.getMenu().getItem(1).setChecked(true);
    }

    private boolean defauFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivity, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.item_home:
                fragment = new HomeFragment();
                break;
            case R.id.item_music:
                fragment = new MusicFragment();
                break;
            case R.id.item_youtube:
                fragment = new YoutubeFragment();
                break;
            default:
                fragment = new HomeFragment();
                break;
        }
        return defauFragment(fragment);
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Nhấn lần nữa để thoát", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
