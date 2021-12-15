package com.example.dialoguyishi1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentBolim extends Fragment implements MyAdapter.Bosilish_Uchun_Interface {
    private ArrayList<ModelKlass> list;
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout,container,false);
        recyclerView=view.findViewById(R.id.res1);
        loaddata();
        adapter=new MyAdapter(list,inflater.getContext());
        adapter.setListener((MyAdapter.Bosilish_Uchun_Interface)this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(inflater.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public  void  loaddata(){
        list=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new ModelKlass("ism"+i, " disc"+i));
        }

    }

    @Override
    public void onItemClick_bosish_funksiya(int i, View v) {

        String name=list.get(i).getName().toString();
        Toast.makeText(getContext(), "name", Toast.LENGTH_SHORT).show();

    }
}
