package com.app.danvinetechnologies.skoolmate.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.app.danvinetechnologies.skoolmate.R;
import com.app.danvinetechnologies.skoolmate.Student_Home_Activity;
import com.app.danvinetechnologies.skoolmate.Teacher_Home_Activity;
import com.app.danvinetechnologies.skoolmate.VollySinglton.MySingelton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Student_Login_Fragment extends Fragment {

    Button btnstudentlogin;
    EditText editText_mobile, editText_name;
    public static final String STUDENT_LOGIN_URL = "http://aryaschooljjk.com/admin/webservices/parent_login.php";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student__login_, container, false);


        btnstudentlogin = view.findViewById(R.id.btn_student_loginid);
        editText_mobile = view.findViewById(R.id.edittext_student_mobile_login);
        editText_name = view.findViewById(R.id.edittext_student_name_login);

        btnstudentlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_User();
                //
            }
        });

        return view;
    }



    void get_User() {


        final String studentmobile = editText_mobile.getText().toString();
        final String studentName = editText_name.getText().toString();

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, STUDENT_LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "inset data shivam", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),Student_Home_Activity.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String json = null;

                NetworkResponse response = error.networkResponse;
                if (response != null && response.data != null) {

                    json = new String(response.data);

                    json = trimMessage(json, "result");

                    if (json.equals("invalid student name")) {
                        Toast.makeText(getContext(), json, Toast.LENGTH_SHORT).show();
                    } else if (json.equals("student not registered.")) {
                        Toast.makeText(getContext(), "Student's Mobile Number Not Registered", Toast.LENGTH_SHORT).show();
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
                params.put("mobile", studentmobile);
                params.put("studentName", studentName);

                return params;
            }
        };

        MySingelton.getInstance(getContext()).addToRequestQueue(stringRequest);
    }


}
