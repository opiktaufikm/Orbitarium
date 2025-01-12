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

public class GalaxyActivity extends AppCompatActivity implements GalaxyAdapter.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_galaxy);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String galaxy = getIntent().getStringExtra("galaxy");
        TextView textView = findViewById(R.id.namagalaxy);
        textView.setText(galaxy);

        String img = getIntent().getStringExtra("img");
        ImageView imageView = findViewById(R.id.imggalaxy);
        imageView.setImageResource(getResources().getIdentifier(img, "drawable", getPackageName()));

        RecyclerView recyclerView = findViewById(R.id.listPlanet);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Map<String, String>> planets = new ArrayList<>();

        addPlanet(planets, "Merkurius", "merkurius", "Planet Terestrial", "~4.880 km",
                "Merkurius adalah planet terkecil dan terdekat dengan Matahari. Tidak memiliki atmosfer yang signifikan, " +
                        "permukaannya dipenuhi kawah akibat tumbukan asteroid, mirip dengan Bulan. Planet ini mengalami suhu ekstrem, " +
                        "dengan siang yang sangat panas dan malam yang sangat dingin. Dengan rotasi yang lambat, satu hari di Merkurius lebih panjang dari satu tahunnya.");

        addPlanet(planets, "Venus", "venus", "Planet Terestrial", "~12.104 km",
                "Venus adalah planet terpanas di Tata Surya, meskipun bukan yang terdekat dengan Matahari. Atmosfernya yang sangat tebal, " +
                        "penuh dengan karbon dioksida dan awan asam sulfat, menyebabkan efek rumah kaca yang ekstrem. Dengan permukaan vulkanik " +
                        "dan tekanan atmosfer yang sangat tinggi, Venus dianggap sebagai 'saudara jahat' Bumi karena ukurannya yang hampir sama.");

        addPlanet(planets, "Bumi", "bumi", "Planet Terestrial", "~12.742 km",
                "Bumi adalah satu-satunya planet yang diketahui mendukung kehidupan. Atmosfernya kaya oksigen, permukaan yang sebagian besar terdiri dari air, " +
                        "dan iklim yang bervariasi menciptakan kondisi ideal bagi keanekaragaman hayati. Bulan, satu-satunya satelit alami Bumi, " +
                        "memiliki peran penting dalam mengatur pasang surut dan stabilitas rotasi planet.");

        addPlanet(planets, "Mars", "mars", "Planet Terestrial", "~6.779 km",
                "Mars, dikenal sebagai 'Planet Merah,' memiliki permukaan kaya oksida besi yang memberinya warna khas. Planet ini memiliki gunung tertinggi di Tata Surya, " +
                        "Olympus Mons, dan lembah raksasa, Valles Marineris. Mars juga menjadi fokus eksplorasi manusia untuk mencari kemungkinan kehidupan masa lalu atau masa depan di planet ini.");

        addPlanet(planets, "Jupiter", "jupiter", "Planet Gas Raksasa", "~139.820 km",
                "Jupiter adalah raksasa gas terbesar di Tata Surya, dengan atmosfer penuh pusaran awan dan badai besar seperti Great Red Spot, " +
                        "yang telah berlangsung selama lebih dari 300 tahun. Planet ini memiliki medan magnet yang sangat kuat dan sistem cincin tipis yang sulit terlihat. " +
                        "Satelit-satelitnya, termasuk Europa dan Ganymede, menjadi target penelitian astrobiologi.");

        addPlanet(planets, "Saturnus", "saturnus", "Planet Gas Raksasa", "~116.460 km",
                "Saturnus dikenal karena sistem cincinnya yang paling kompleks dan indah, terdiri dari partikel es dan debu. Raksasa gas ini memiliki atmosfer yang didominasi hidrogen " +
                        "dan helium, serta angin yang sangat kencang. Salah satu satelitnya, Titan, memiliki atmosfer tebal dan lautan metana cair, menarik minat peneliti untuk memahami kemungkinan kehidupan.");

        addPlanet(planets, "Uranus", "uranus", "Planet Es Raksasa", "~50.724 km",
                "Uranus adalah planet yang 'berputar miring,' dengan sumbu rotasi hampir sejajar dengan bidang orbitnya, kemungkinan akibat tabrakan dengan objek besar di masa lalu. " +
                        "Atmosfernya kaya akan metana, memberikan warna biru kehijauan. Cincin tipisnya dan 27 satelitnya, termasuk Titania dan Oberon, menjadikannya obyek menarik untuk penelitian.");

        addPlanet(planets, "Neptunus", "neptunus", "Planet Es Raksasa", "~49.244 km",
                "Neptunus adalah planet terluar di Tata Surya dengan warna biru cerah yang disebabkan oleh metana di atmosfernya. Planet ini memiliki angin tercepat di Tata Surya, " +
                        "mencapai hingga 2.000 km/jam. Badai besar seperti Great Dark Spot menunjukkan aktivitas atmosfer yang dinamis. Triton, satelit terbesarnya, memiliki aktivitas geologi yang menarik dengan geyser nitrogen.");

        addPlanet(planets, "Pluto", "pluto", "Planet Kerdil", "~2.377 km",
                "Pluto, meski kini diklasifikasikan sebagai planet kerdil, tetap menarik perhatian astronom karena permukaannya yang penuh es nitrogen. " +
                        "Charon, satelit terbesarnya, memiliki hubungan gravitasi unik dengan Pluto sehingga mereka selalu menunjukkan sisi yang sama satu sama lain. " +
                        "Pluto terletak di Sabuk Kuiper, kawasan penuh objek es di luar Tata Surya.");

        addPlanet(planets, "Eris", "eris", "Planet Kerdil", "~2.326 km",
                "Eris adalah salah satu objek terbesar di Sabuk Kuiper, lebih masif dari Pluto meskipun lebih kecil diameternya. Permukaannya sangat reflektif karena dilapisi es metana. " +
                        "Dengan orbit yang sangat elips, Eris menghabiskan sebagian besar waktunya jauh dari Matahari, membuatnya menjadi salah satu objek paling dingin di Tata Surya.");

        GalaxyAdapter adapter = new GalaxyAdapter(planets, this);
        recyclerView.setAdapter(adapter);
    }

    private void addPlanet(List<Map<String, String>> dataPlanet, String nama, String img, String jenis, String diameter, String deskripsi) {
        Map<String, String> data = new HashMap<>();
        data.put("nama", nama);
        data.put("img", img);
        data.put("jenis", jenis);
        data.put("diameter", diameter);
        data.put("deskripsi", deskripsi);
        dataPlanet.add(data);
    }

    @Override
    public void onItemClick(Map<String, String> planet) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("nama", planet.get("nama"));
        intent.putExtra("diameter", planet.get("diameter"));
        intent.putExtra("deskripsi", planet.get("deskripsi"));
        intent.putExtra("img", planet.get("img"));
        startActivity(intent);
    }
}
