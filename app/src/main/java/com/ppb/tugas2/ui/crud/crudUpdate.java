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

public class crudUpdate extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    EditText nama, nim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_update);

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
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("UPDATE mahasiswa set nama = '" +
                        nama.getText().toString()+"', nim ='" +
                        nim.getText().toString() +"' WHERE nama = '" +
                        getIntent().getStringExtra("nama")+"'");
                Toast.makeText(crudUpdate.this, "Data berhasil di update", Toast.LENGTH_SHORT).show();
                crudHome.ch.RefreshList();
                finish();
            }
        });
    }
}