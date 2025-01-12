package com.example.projectopik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity implements GalaxyAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.listGalaxy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Map<String, String>> data = new ArrayList<>();
        addGalaksi(data, "Galaxy Bima Sakti", "bimasakti");

        GalaxyAdapter adapter = new GalaxyAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }

    private void addGalaksi(List<Map<String, String>> dataGalaxy, String nama, String img) {
        Map<String, String> data = new HashMap<>();
        data.put("img", img);
        data.put("nama", nama);
        dataGalaxy.add(data);
    }

    @Override
    public void onItemClick(Map<String, String> galaxy) {
        // Handle item click, for example, to show country details
        Intent intent = new Intent(HomeActivity.this, GalaxyActivity.class);
        intent.putExtra("galaxy", galaxy.get("nama"));
        intent.putExtra("img", galaxy.get("img"));
        startActivity(intent);
    }
    public void profile (View view){
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}

