package com.example.galleryapp;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView boj2;
    WebView obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boj2=findViewById(R.id.rv);
        GalleryProvider obj=new GalleryProvider();
        obj.execute();




    }


    public class GalleryProvider extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> data = new ArrayList<>();
            Cursor c = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Images.Media.DATA+" LIKE '%Snapchat%'", null, null);
            c.moveToFirst();
            do {
                data.add(c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA)));
            }
            while (c.moveToNext());
            c.close();

            return data;


        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            AdapterOne boj=new AdapterOne(MainActivity.this,strings);
            boj2.setAdapter(boj);
            GridLayoutManager boj1=new GridLayoutManager(MainActivity.this,3);
            boj1.setOrientation(GridLayoutManager.VERTICAL);
            boj2.setLayoutManager(boj1);


        }


    }

}

