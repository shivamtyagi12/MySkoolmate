package com.app.danvinetechnologies.skoolmate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.app.danvinetechnologies.skoolmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_Login_Fragment extends Fragment {


    public Admin_Login_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return inflater.inflate(R.layout.fragment_admin__login_, container, false);
    }

}
