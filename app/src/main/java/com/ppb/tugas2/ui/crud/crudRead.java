package com.ppb.tugas2.ui.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ppb.tugas2.R;

public class crudRead extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    TextView nama, nim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_read);

        database = new Database(this);
        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.NIM);
        btn_simpan = findViewById(R.id.btn_simpan);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM mahasiswa WHERE nama = '" +
                getIntent().getStringExtra("nama")+"'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(0).toString());
            nim.setText(cursor.getString(1).toString());
        }
    }
}