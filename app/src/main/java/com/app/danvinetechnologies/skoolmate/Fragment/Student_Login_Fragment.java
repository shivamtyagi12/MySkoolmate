package com.app.danvinetechnologies.skoolmate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.danvinetechnologies.skoolmate.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Student_Login_Fragment extends Fragment {


    public Student_Login_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student__login_, container, false);
    }

}
