package com.example.dialoguyishi1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PassingData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentA)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void passData(String name) {
          FragmentBolim fragmentBolim = new FragmentBolim();
          Bundle bundle = new Bundle();
          bundle.putString("name",name);
          fragmentBolim.setArguments(bundle);

          FragmentManager manager = getSupportFragmentManager();

          manager.beginTransaction()
                  .replace(R.id.container,fragmentBolim)
                  .addToBackStack(null)
                  .commit();
    }
}