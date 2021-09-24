package com.ppb.tugas2.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ppb.tugas2.MainActivity;
import com.ppb.tugas2.MainActivity2;
import com.ppb.tugas2.R;
import com.ppb.tugas2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private CheckBox cbEdu, cbLife, cbTech;
    private Button btSubmit, btnToWebview;
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

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "Universitas Trunojoyo Madura";
                Intent goyt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + query));
                startActivity(goyt);
            }
        });
        return viewlast;
    }

}