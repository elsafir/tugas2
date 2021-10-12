package com.ppb.tugas2.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ppb.tugas2.R;
import com.ppb.tugas2.ui.crud.crudHome;

public class HomeFragment extends Fragment {
    private CheckBox cbEdu, cbLife, cbTech;
    private Button btSubmit, btnToWebview, btnTocrud;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewlast = inflater.inflate(R.layout.fragment_home, container, false);

        cbEdu = viewlast.findViewById(R.id.cb_education);
        cbLife = viewlast.findViewById(R.id.cb_lifestyle);
        cbTech = viewlast.findViewById(R.id.cb_technology);
        btSubmit = viewlast.findViewById(R.id.bt_submit);
        btnToWebview = viewlast.findViewById(R.id.btn_webview);
        btnTocrud = viewlast.findViewById(R.id.btn_crud);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String query = "Universitas Trunojoyo Madura";
                        Intent goyt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + query));
                        startActivity(goyt);
            }
        });
        btnTocrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), crudHome.class));
            }
        });
        return viewlast;
    }

}