package com.ppb.tugas2.ui.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ppb.tugas2.R;

public class crudCreate extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    EditText nama, nim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_create);

        database = new Database(this);
        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.NIM);

        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into mahasiswa(nama, nim) values('" +
                        nama.getText().toString() + "','" +
                        nim.getText().toString() + "')");
                Toast.makeText(crudCreate.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                crudHome.ch.RefreshList();
                finish();
            }
        });
    }
}