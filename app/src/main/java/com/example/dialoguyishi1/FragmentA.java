package com.example.dialoguyishi1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentA extends Fragment implements DialogFragment.DialogListener,MyAdapter.Bosilish_Uchun_Interface{

    private RecyclerView recyclerView;
    private ArrayList<ModelKlass> list;
    private MyAdapter adapter;
    private FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_a,container,false);

        recyclerView=view.findViewById(R.id.res);
        fab=view.findViewById(R.id.fab);
        loaddata();
        adapter=new MyAdapter(list,getActivity());
        recyclerView.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment=new DialogFragment();
                dialogFragment.show(getChildFragmentManager(),"fragment");
            }
        });
        adapter.setListener((MyAdapter.Bosilish_Uchun_Interface)this);

        return view;
    }

    public  void  loaddata(){
        list=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new ModelKlass("name"+ i, " discr"+i));
        }
    }

    @Override
    public void applyText(String name1, String disc1) {

    }

    @Override
    public void onItemClick_bosish_funksiya(int i, View v) {

    }
}
