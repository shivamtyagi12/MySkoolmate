package com.app.danvinetechnologies.skoolmate.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.app.danvinetechnologies.skoolmate.Teacher_Home_Activity;
import com.app.danvinetechnologies.skoolmate.R;
import com.app.danvinetechnologies.skoolmate.VollySinglton.MySingelton;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Teacher_Login_Fragment extends Fragment {

    Button btnteacherlogin;
    EditText editTextmobile, editTextEmployeeId;
    CheckBox checkBox_remember;
    public static final String TEACHER_LOGIN = "http://aryaschooljjk.com/admin/webservices/teacher_login.php";

    TextInputLayout textInputLayoutteacherid, textInputLayoutteachername;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher__login_, container, false);

        btnteacherlogin = view.findViewById(R.id.btn_teacher_loginid);
        editTextmobile = view.findViewById(R.id.teachermobile);
        editTextEmployeeId = view.findViewById(R.id.teacherempid);
        checkBox_remember = view.findViewById(R.id.remember_teacher);



        btnteacherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();


            }


        });
        return view;
    }



    void validation() {
        String mobile = editTextmobile.getText().toString();
        String empid = editTextEmployeeId.getText().toString();

        if(mobile.isEmpty()){
            editTextmobile.setError("Please enter your mobile");
        }else if(mobile.length()<10 || mobile.length()>10)
        {
            editTextmobile.setError("Please enter valid mobile number");
        }else if(empid.isEmpty()){
            editTextEmployeeId.setError("Please enter your employee Id.");
        }else {
            get_User();

        }


    }

    void get_User() {


        final String teachermobile = editTextmobile.getText().toString();
        final String teacherEmpId = editTextEmployeeId.getText().toString();

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, TEACHER_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Boolean b = checkBox_remember.isChecked();
                Intent intent = new Intent(getContext(),Teacher_Home_Activity.class);
              //  intent.putExtra("remember",b);

                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String json = null;
                NetworkResponse response = error.networkResponse;
                if (response != null && response.data != null) {

                    json = new String(response.data);

                    json = trimMessage(json, "result");


                    if (json.equals("user not registered.")) {
                        Toast.makeText(getContext(), json, Toast.LENGTH_SHORT).show();
                    } else if (json.equals("invalid employee id")) {
                        Toast.makeText(getContext(), json, Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }

            }

            String trimMessage(String json, String message) {

                String trimmedString = null;
                String output;
                try {
                    output = Html.fromHtml(json).toString();
                    output = output.substring(output.indexOf("{"), output.lastIndexOf("}") + 1);
                    JSONObject obj = new JSONObject(output);
                    trimmedString = obj.getString(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }

                return trimmedString;
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("mobile", teachermobile);
                params.put("empid", teacherEmpId);

                return params;
            }
        };

        MySingelton.getInstance(getContext()).addToRequestQueue(stringRequest);
    }

}
