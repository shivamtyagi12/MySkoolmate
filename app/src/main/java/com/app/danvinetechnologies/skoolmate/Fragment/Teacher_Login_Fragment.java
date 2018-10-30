package com.app.danvinetechnologies.skoolmate.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.danvinetechnologies.skoolmate.Teacher_Home_Activity;
import com.app.danvinetechnologies.skoolmate.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Teacher_Login_Fragment extends Fragment {

    Button btnteacherlogin;
    EditText editTextid,editTextname;

    TextInputLayout textInputLayoutteacherid,textInputLayoutteachername;
    public Teacher_Login_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teacher__login_, container, false);
      //  getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        btnteacherlogin = view.findViewById(R.id.btn_teacher_loginid);
        editTextid = view.findViewById(R.id.teacherid);
        editTextname = view.findViewById(R.id.teachernameid);


        btnteacherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Teacher_Home_Activity.class));
            }
        });
        return view;
    }

}
