package com.example.firebasedemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentList extends ArrayAdapter<Student> {
    private Activity context;
    private List<Student> studentList;
//constructor
    public StudentList(Activity context,List<Student>studentList){
        super(context,R.layout.list_appearance,studentList);
        this.context=context;
        this.studentList=studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.list_appearance,null,true);

        TextView reg=(TextView)listViewItem.findViewById(R.id.reg);
        TextView fname=(TextView)listViewItem.findViewById(R.id.fname);
        TextView lname=(TextView)listViewItem.findViewById(R.id.lname);
        TextView course=(TextView)listViewItem.findViewById(R.id.course);
        TextView year=(TextView)listViewItem.findViewById(R.id.year);

        Student student=studentList.get(position);
        reg.setText(student.getRegNo());
        fname.setText(student.getFirstName());
        lname.setText(student.getLastName());
        course.setText(student.getCourse());
        year.setText(student.getYear());

        return listViewItem;
     }
}
