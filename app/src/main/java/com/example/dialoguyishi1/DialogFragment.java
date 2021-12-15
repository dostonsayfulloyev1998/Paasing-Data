package com.example.dialoguyishi1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFragment extends AppCompatDialogFragment {
    DialogListener listener;
    EditText name,surname;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Addition");
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.custom_dialog1,null);
        name=view.findViewById(R.id.et1);
        surname=view.findViewById(R.id.et2);
        builder.setView(view);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.applyText(name.getText().toString(),surname.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.setCancelable(true);
            }
        });

        return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        try {
            listener=(DialogListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString()+"");
        }
        super.onAttach(context);
    }

    interface DialogListener{
        void applyText(String name1, String disc1);
    }
}
