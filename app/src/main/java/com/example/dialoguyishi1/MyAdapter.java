package com.example.dialoguyishi1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<ModelKlass>list;
    private Context context;
   private PassingData passingData;


    public void setPassingData(PassingData passingData) {
        this.passingData = passingData;
    }

    public MyAdapter(ArrayList<ModelKlass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new MyViewHolder(view);
    }

    public  void addplus(String name0, String disc0 ){
        list.add(new ModelKlass(name0,disc0));
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int p=position;
        String name=list.get(p).getName();
        String disc=list.get(p).getDisc();
        holder.name.setText(name);
        holder.disc.setText(disc);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  passingData.passData(name);
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, disc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tv1);
            disc=itemView.findViewById(R.id.tv2);
        }
    }
}

interface PassingData{
    void passData(String name);
}
