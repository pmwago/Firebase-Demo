package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
private EditText reg,fname,lname,course,year;
private Button submit,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg=findViewById(R.id.reg);
        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        course=findViewById(R.id.course);
        year=findViewById(R.id.year);
        submit=findViewById(R.id.sub);
        view=findViewById(R.id.view);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference().child("Students");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regNo=reg.getText().toString().trim();
                String firstName=fname.getText().toString().trim();
                String lastName=lname.getText().toString().trim();
                String courseName=course.getText().toString();
                String studyYear=year.getText().toString();
               if (regNo.isEmpty()){
                   reg.setError("Registration number is required");
                   reg.requestFocus();
                   return;
               }
               if (firstName.isEmpty()){
                   fname.setError("Enter first name");
                   fname.requestFocus();
                   return;
               }
                if (lastName.isEmpty()){
                    lname.setError("Enter last name");
                    lname.requestFocus();
                    return;
                }
                if (studyYear.isEmpty()){
                    year.setError("Enter year");
                    year.requestFocus();
                    return;
                }
                if (courseName.isEmpty()){
                   course.setError("Registration number is required");
                    course.requestFocus();
                    return;
                }

               else{
                   String id=ref.push().getKey();
                   Student student=new Student(id,reg.getText().toString().trim(),fname.getText().toString().trim(),lname.getText().toString().trim(),
                           course.getText().toString().trim(),year.getText().toString().trim());
                   ref.child(id).setValue(student);
                   Toast.makeText(getApplicationContext(), "Insertion successful", Toast.LENGTH_SHORT).show();
                   reg.setText("");
                   course.setText("");
                   year.setText("");
                   fname.setText("");
                   lname.setText("");
               }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home =new Intent(getApplicationContext(),Home.class);
                startActivity(home);
            }
        });
    }
}