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
        View view1= inflater.inflate(R.layout.fragment_home, container, false);
        cbEdu =  view1.findViewById(R.id.cb_education);
        cbLife = view1.findViewById(R.id.cb_lifestyle);
        cbTech = view1.findViewById(R.id.cb_technology);
        btSubmit =  view1.findViewById(R.id.bt_submit);
        btnToWebview = view1.findViewById(R.id.btn_webview);

        cbEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    Toast.makeText(getActivity(),
                            "Anda memilih Education", Toast.LENGTH_LONG).show(); }
            }});
        cbLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    Toast.makeText(getActivity(),
                            "Anda memilih Lifestyle", Toast.LENGTH_LONG).show();
                }
            }
        });
        cbTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    Toast.makeText(getActivity(),
                            "Anda memilih Technology", Toast.LENGTH_LONG).show();}}});
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "";
                if (cbEdu.isChecked() && cbLife.isChecked() && cbTech.isChecked()) {
                    query = "education lifestyle technology";
                } else if (cbEdu.isChecked() && cbLife.isChecked()) {
                    query = "education lifestyle";
                } else if (cbEdu.isChecked() && cbTech.isChecked()) {
                    query = "education technology";
                } else if (cbTech.isChecked() && cbLife.isChecked()) {
                    query = "technology lifestyle";
                } else if (cbLife.isChecked()) {
                    query = "lifestyle";
                } else if (cbTech.isChecked()) {
                    query = "technology";
                } else {
                    query = "education";
                }
                Intent dialPhoneIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + query));
                startActivity(dialPhoneIntent);
            }
        });
        btnToWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveIntent = new Intent(getActivity(), MainActivity2.class);
                startActivity(moveIntent);
            }
        });

                return view1;
    }


}