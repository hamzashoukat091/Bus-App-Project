package com.example.firebase;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Register_Class extends Fragment {

    EditText t1,t2,t3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        String name = getArguments().getString("name");
        String email = getArguments().getString("email");
        String phone = getArguments().getString("phone");

        View view = inflater.inflate(R.layout.activity_register_class, container,false);

        t1 = view.findViewById(R.id.editname);
        t2 = view.findViewById(R.id.editemail);
        t3 = view.findViewById(R.id.editphone);

        t1.setText(name);
        t2.setText(email);
        t3.setText(phone);
        return view;
    }
}
