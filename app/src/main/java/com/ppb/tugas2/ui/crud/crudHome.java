package com.ppb.tugas2.ui.crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ppb.tugas2.MainActivity;
import com.ppb.tugas2.R;

public class crudHome extends AppCompatActivity {

    String[] daftar;
    ListView listView;
    Menu menu;
    protected Cursor cursor;
    Database database;
    public static crudHome ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crudHome.this,crudCreate.class));
            }
        });

        ch = this;
        database = new Database(this);
        // setiap menambah data akan selalu refresh
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM mahasiswa", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(0).toString();
        }
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView.setSelected(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                final String selection = daftar[position];
                final CharSequence[] dialogitem = {"Lihat mahasiswa", "Update mahasiswa", "Hapus mahasiswa"};
                AlertDialog.Builder builder = new AlertDialog.Builder(crudHome.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
//                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0:
                                Intent pertama = new Intent(getApplicationContext(), crudRead.class);
                                pertama.putExtra("nama", selection);
                                startActivity(pertama);
                                break;
                            case 1:
                                Intent kedua = new Intent(getApplicationContext(), crudUpdate.class);
                                kedua.putExtra("nama", selection);
                                startActivity(kedua);
                                break;
                            case 2:
                                SQLiteDatabase db = database.getWritableDatabase();
                                db.execSQL("DELETE FROM mahasiswa WHERE nama = '" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) listView.getAdapter()).notifyDataSetInvalidated();
    }
}