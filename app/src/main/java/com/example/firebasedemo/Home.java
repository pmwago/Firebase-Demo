package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {
    private TextView reg,fname,lname,course,year;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        reg=findViewById(R.id.reg);
        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        course=findViewById(R.id.course);
        year=findViewById(R.id.year);
        back=findViewById(R.id.back);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference().child("Student").child("student1");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                reg.setText(snapshot.child("regNo").getValue().toString());
                fname.setText(snapshot.child("firstName").getValue().toString());
                lname.setText(snapshot.child("lastName").getValue().toString());
                course.setText(snapshot.child("course").getValue().toString());
                year.setText(snapshot.child("year").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(back);
            }
        });
    }
}