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

public class FragmentBolim extends Fragment  {
    private ArrayList<ModelKlass> list;
    private MyAdapter adapter;
    private RecyclerView recyclerView;

    String name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name = getArguments().getString("name");

        Toast.makeText(getContext(),name,Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout,container,false);


        return view;
    }
    public  void  loaddata(){
        list=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new ModelKlass("ism"+i, " disc"+i));
        }

    }

}
