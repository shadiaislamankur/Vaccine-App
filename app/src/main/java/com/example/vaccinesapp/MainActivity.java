package com.example.vaccinesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements  ItemClickListener{

    // 1- AdapterView: RecyclerView
    RecyclerView recyclerView;

    // 2 - Datasource :
    VaccineModel [] myListData;

    //3 - Adapter
    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        myListData = new VaccineModel[]{
                new VaccineModel("Hepatitis B Vaccine", R.drawable.vaccine1),
                new VaccineModel("Tetanus", R.drawable.vaccine4),
                new VaccineModel("Pneumococcal Vaccine", R.drawable.vaccine5),
                new VaccineModel("Rotavirus Vaccine", R.drawable.vaccine6),
                new VaccineModel("Measles Virus", R.drawable.vaccine7),
                new VaccineModel("Cholera Virus", R.drawable.vaccine8),
                new VaccineModel("Covid-19 Virus", R.drawable.vaccine9),

        };

        //Adapter
        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        //Handling the click events
        adapter.setClickListener(this);



    }

    @Override
    public void onClick(View view, int pos) {

        Toast.makeText(this,
                "Vaccine Name: "+myListData[pos].getTitle(),
                Toast.LENGTH_SHORT).show();

    }
}