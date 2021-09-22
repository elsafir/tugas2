package com.ppb.tugas2.ui.exit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ppb.tugas2.R;
import com.ppb.tugas2.databinding.FragmentExitBinding;


public class ExitFragment extends Fragment {
    private Button btAlert;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewlast = inflater.inflate(R.layout.fragment_exit, container, false);
        btAlert = viewlast.findViewById(R.id.exit);
        btAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        // set title dialog
        alertDialogBuilder.setTitle("Keluar dari aplikasi?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk keluar!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        getActivity().finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }});
        return viewlast;
    }
    }