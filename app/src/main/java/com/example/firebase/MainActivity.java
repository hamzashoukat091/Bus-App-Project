package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getFragmentManager();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String name;
    String email;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button2);
        FragmentManager fm = getFragmentManager();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("User");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        name = snapshot.child("Fullname").getValue().toString();
                        email = snapshot.child("user").getValue().toString();
                        phone = snapshot.child("phone").getValue().toString();
                        Register_Class obj = new Register_Class();
                        Bundle bundle = new Bundle();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.add(R.id.frame_layout, obj, "frag");
                        bundle.putString("name", name);
                        bundle.putString("email", email);
                        bundle.putString("phone", phone);
                        obj.setArguments(bundle);
                        ft.commit();
                        button.setVisibility(View.INVISIBLE);
                        button1.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//                Intent intent = new Intent(MainActivity.this, Register_Class.class);
//                intent.putExtra("name", name);
//                intent.putExtra("email", email);
//                intent.putExtra("phone", phone);
//                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ticket_Class tc = new Ticket_Class();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.frame_layout, tc, "fragb");
                ft.commit();
                button.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
            }
        });


    }


//    public void addForm(View view) {
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//                System.out.println(value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//            }
//        });
//
//
//
//    }
}