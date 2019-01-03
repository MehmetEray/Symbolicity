package com.mehmeteraysurmeli.symbolicity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayList<String> symbolNames = new ArrayList<>();
        symbolNames.add("Galata Tower");
        symbolNames.add("The Statue of Liberty");
        symbolNames.add("Golden Gate Bridge");
        symbolNames.add("Clock Tower");
        Bitmap galataTower = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.galata);
        final Bitmap statueofLiberty = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ozgurlukaniti);
        Bitmap goldengateBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.goldengate);
        Bitmap clockTower = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.saatkulesi);


        final ArrayList<Bitmap> symbolImages = new ArrayList<>();
        symbolImages.add(galataTower);
        symbolImages.add(statueofLiberty);
        symbolImages.add(goldengateBridge);
        symbolImages.add(clockTower);


        final ArrayList<String> cityNames = new ArrayList<>();
        cityNames.add("Istanbul - TURKEY");
        cityNames.add("Newyork City - USA");
        cityNames.add("California - USA");
        cityNames.add("Izmir - TURKEY");



        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,cityNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",symbolNames.get(position));
                selectedImage = symbolImages.get(position);
                startActivity(intent);
            }
        });
    }

}
