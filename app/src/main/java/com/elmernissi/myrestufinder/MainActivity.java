package com.elmernissi.myrestufinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.elmernissi.myrestufinder.MyAdapter.MyAdapter;
import com.elmernissi.myrestufinder.model.Magasin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Magasin> magasins = new ArrayList<>();
    private Spinner citySpinner;
    private List<String> citiesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Exemple de données pour le RecyclerView

        magasins.add(new Magasin("Restu00","Safi","098272727"));
        magasins.add(new Magasin("Restu01","Safi","098272727"));
        magasins.add(new Magasin("Restu02","Safi","098272727"));
        magasins.add(new Magasin("Restu03","Safi","098272727"));
        magasins.add(new Magasin("Restu04","casa","098272727"));
        magasins.add(new Magasin("Restu05","casa","098272727"));
        magasins.add(new Magasin("Restu06","casa","098272727"));
        magasins.add(new Magasin("Restu07","casa","098272727"));
        magasins.add(new Magasin("Restu08","Oujda","098272727"));
        magasins.add(new Magasin("Restu09","Oujda","098272727"));
        magasins.add(new Magasin("Restu10","Oujda","098272727"));
        magasins.add(new Magasin("Restu11","Oujda","098272727"));
        magasins.add(new Magasin("Restu12","Tanger","098272727"));
        magasins.add(new Magasin("Restu13","Tanger","098272727"));
        magasins.add(new Magasin("Restu14","Tanger","098272727"));
        magasins.add(new Magasin("Restu15","Tanger","098272727"));

        //Declarer le Adapter et passer les données magasins

        adapter = new MyAdapter(this,magasins);

        //setAdapter(adapter) a le recyclerView

         recyclerView.setAdapter(adapter);


















        // Initialiser le Spinner
        citySpinner = findViewById(R.id.citySpinner);
        citiesList  = List.of(getResources().getStringArray(R.array.cities));
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this,
               android.R.layout.simple_spinner_item,citiesList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
       citySpinner.setAdapter(spinnerAdapter);
        // Ajouter un écouteur de sélection au Spinner
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 List<Magasin> listMagasin = new ArrayList<>();
                 String city = parent.getItemAtPosition(position).toString();
//                citySpinner.setSelection(-1);
                switch (position){
                    case 0:
                        adapter.setData(magasins);
                        break;
                    default:
//                        List<Magasin> magasinsFiltre = magasins.stream()
//                                .filter(C->C.getNomVill().toLowerCase().equals(city))
//                                .collect(Collectors.toList());
                        for (Magasin i:magasins){
                            if (i.getNomVill().toLowerCase().equals(city.toLowerCase())){
                                listMagasin.add(i);
                            }
                        }

                        adapter.setData(listMagasin);
                }








            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "nothingSelected", Toast.LENGTH_SHORT).show();

            }
        });






    }
    //Ajouter le menu a l'application

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
          super.onCreateOptionsMenu(menu);
          getMenuInflater().inflate(R.menu.menu,menu);
          return true;
    }
}