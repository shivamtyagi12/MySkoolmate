package com.app.danvinetechnologies.skoolmate.Fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.app.danvinetechnologies.skoolmate.Adapter.ViewPagerAdapterrr;
import com.app.danvinetechnologies.skoolmate.R;
import com.app.danvinetechnologies.skoolmate.SimpleAdapter;
import com.app.danvinetechnologies.skoolmate.Teacher_Home_Activity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class Teacher_Profile_edit_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {


    String[] subject = {"Physics","Chemistry","Math","Hindi","Social Science","Sanskrit","German"};
    String[] clas = {"Ist","2nd","3rd","4th","5th","6th","7th"};
    String[] exp ={"0-1 year","1-2 year","2-3 year","3-4 year","4-5 year","more than 5"};

    Toolbar toolbar;
    AppCompatSpinner compatSpinnername;
    AppCompatSpinner compatSpinnerclass;
    AppCompatSpinner compatSpinnerexperience;
    EditText editText;
    public Teacher_Profile_edit_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_teacher__profile_edit_, container, false);
        toolbar = view.findViewById(R.id.toolbarid);
        editText = view.findViewById(R.id.edit_shortdescription_id);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Edit Profile");
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);



        compatSpinnername = view.findViewById(R.id.name_spinner_id);
        compatSpinnername.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdaptername = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_dropdown_item,subject);
        arrayAdaptername.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        compatSpinnername.setAdapter(arrayAdaptername);




        compatSpinnerclass = view.findViewById(R.id.class_spinnr_id);
        compatSpinnerclass.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapterclass = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_dropdown_item,clas);
        arrayAdapterclass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        compatSpinnerclass.setAdapter(arrayAdapterclass);




        compatSpinnerexperience = view.findViewById(R.id.experience_spinnr_id);
        compatSpinnerexperience.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapterexperience = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_dropdown_item,exp);
        arrayAdapterexperience.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        compatSpinnerexperience.setAdapter(arrayAdapterexperience);

        return view;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
