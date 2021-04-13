package com.example.firebase;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Random;

public class Ticket_Class extends Fragment {

    TextView rand;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Random r = new Random();
        int random_no = r.nextInt((9999999 - 10)+ 9999999);
        View view = inflater.inflate(R.layout.activity_ticket_class, container, false);
        rand = view.findViewById(R.id.random_ticket);
        rand.setText("#"+random_no);
        return view;
    }
}
