package com.example.listapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mLeadsList;
    LeadsAdapter mLeadsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Instancia del ListView.
        mLeadsList = (ListView) findViewById(R.id.leads_list);
// Inicializar el adaptador con la fuente de datos.
        mLeadsAdapter = new LeadsAdapter(this, LeadsRepository.getInstance().getLeads());
//Relacionando la lista con el adaptador
        mLeadsList.setAdapter(mLeadsAdapter);
        mLeadsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ?> arg0, android.view.View arg1, int arg2,
                                    long arg3) {
                ListAdapter la = (ListAdapter) arg0.getAdapter();
                Toast.makeText(
                        arg1.getContext()
                        ,la.getItem(arg2).toString()
                        ,Toast.LENGTH_LONG)
                        .show();
            };
        });
    }
}