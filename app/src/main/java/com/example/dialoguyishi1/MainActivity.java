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

public class MainActivity extends AppCompatActivity implements MyAdapter.Bosilish_Uchun_Interface  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onItemClick_bosish_funksiya(int i, View v) {

             FragmentBolim fragmentBolim=new FragmentBolim();
                FragmentManager fragmentManager= getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.ll,fragmentBolim,null)
                        .addToBackStack(null)
                        .commit();
        }

    }
