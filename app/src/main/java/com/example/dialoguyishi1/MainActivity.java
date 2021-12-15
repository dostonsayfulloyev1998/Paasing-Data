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

public class MainActivity extends AppCompatActivity implements  DialogFragment.DialogListener, MyAdapter.Bosilish_Uchun_Interface  {
    private RecyclerView recyclerView;
   private ArrayList<ModelKlass>list;
   private MyAdapter adapter;
   private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.res);
        fab=findViewById(R.id.fab);
        loaddata();
        adapter=new MyAdapter(list,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment=new DialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"fragment");
            }
        });
        adapter.setListener((MyAdapter.Bosilish_Uchun_Interface)this);

    }
    public  void  loaddata(){
        list=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new ModelKlass("name"+ i, " discr"+i));
        }
    }

    @Override
    public void applyText(String name1, String disc1) {
        adapter.addplus(name1,disc1);
    }

    @Override
    public void onItemClick_bosish_funksiya(int i, View v) {
        TextView name2, surname2;
        name2=v.findViewById(R.id.tv1);
        surname2=v.findViewById(R.id.tv2);

        String n=name2.getText().toString();
        String s=surname2.getText().toString();

        Toast.makeText(this, n+"  "+s,Toast.LENGTH_LONG).show();

             FragmentBolim fragmentBolim=new FragmentBolim();
                FragmentManager fragmentManager= getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.ll,fragmentBolim,null)
                        .addToBackStack(null)
                        .commit();
        }

    }
