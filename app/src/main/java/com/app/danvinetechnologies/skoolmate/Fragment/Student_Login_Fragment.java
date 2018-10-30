package com.app.danvinetechnologies.skoolmate.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.danvinetechnologies.skoolmate.R;
import com.app.danvinetechnologies.skoolmate.Student_Home_Activity;


/**
 * A simple {@link Fragment} subclass.
 */
public class Student_Login_Fragment extends Fragment  {

    TextView textViewStudentlogin;
    Button btnstudentlogin;


    public Student_Login_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view= inflater.inflate(R.layout.fragment_student__login_, container, false);

       // getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        btnstudentlogin = view.findViewById(R.id.btn_student_loginid);

        btnstudentlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Student_Home_Activity.class));
            }
        });

        return view;
    }




}
