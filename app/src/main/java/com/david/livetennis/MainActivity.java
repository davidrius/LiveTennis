package com.david.livetennis;

import static com.david.livetennis.R.id.bottomNavigationView;
import static com.david.livetennis.R.id.lvDatos;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;

import com.david.livetennis.ui.calendar.FragmentTorneos;
import com.david.livetennis.ui.directo.FragmentPartidos;
import com.david.livetennis.ui.ranks.FragmentRankings;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.david.livetennis.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //private ActivityMain2Binding binding;
    private BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Splash Screen

        try {
            Thread.sleep(2000);

            setTheme(R.style.Theme_LiveTennis);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        final Fragment FragmentTorneos = new FragmentTorneos();
        final Fragment FragmentPartidos = new FragmentPartidos();
        final Fragment FragmentRankings = new FragmentRankings();

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, FragmentTorneos).commit();
        }

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            FragmentManager fragmentManager = getSupportFragmentManager();

                if (item.getItemId() == R.id.resultadosItem) {

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, FragmentPartidos).commit();

                } else if (item.getItemId() == R.id.calendarioItem) {

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, FragmentTorneos).commit();

                } else if (item.getItemId() == R.id.rankingItem) {

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, FragmentRankings).commit();
                }

            return true;
        });

        //seleccionar el item calendario como el que se abra por defecto
        bottomNavigationView.setSelectedItemId(R.id.calendarioItem);


    }


}