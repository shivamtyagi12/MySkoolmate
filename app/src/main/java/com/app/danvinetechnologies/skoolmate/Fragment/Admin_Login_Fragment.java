package com.app.danvinetechnologies.skoolmate.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.app.danvinetechnologies.skoolmate.R;
import com.app.danvinetechnologies.skoolmate.Teacher_Home_Activity;
import com.app.danvinetechnologies.skoolmate.VollySinglton.MySingelton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_Login_Fragment extends Fragment {
    Button login;
    EditText editText_moblile, editText_uniquekey;
    public static final String ADMIN_URL = "http://aryaschooljjk.com/admin/webservices/admin_login.php";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin__login_, container, false);

        login = view.findViewById(R.id.btn_admin_login);
        editText_moblile = view.findViewById(R.id.edit_text_admin_mobile);
        editText_uniquekey = view.findViewById(R.id.edit_text_admin_unique_key);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_User();
            }
        });

        return view;
    }

    void get_User() {


        final String adminmobile = editText_moblile.getText().toString();
        final String adminUniquekey = editText_uniquekey.getText().toString();

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, ADMIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getContext(), "inset data ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), Teacher_Home_Activity.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                String json = null;

                NetworkResponse response = error.networkResponse;
                if (response != null && response.data != null) {

                    json = new String(response.data);

                    json = trimMessage(json, "result");

                    if (json.equals("admin not registered.")) {
                        Toast.makeText(getContext(), json, Toast.LENGTH_SHORT).show();
                    } else if (json.equals("invalid unique id")) {
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
                params.put("mobile", adminmobile);
                params.put("uniqueid", adminUniquekey);

                return params;
            }
        };

        MySingelton.getInstance(getContext()).addToRequestQueue(stringRequest);
    }

}
