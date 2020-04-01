package com.login.registrocoches;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.parceler.Parcels;
import java.util.ArrayList;



public class Filtro extends AppCompatActivity {
    ArrayList<Datos> Dllegada = new ArrayList<>();
    ArrayList<Datos> auxiliar = new ArrayList<>();
    ListView lista2, listadapter;
    private adapter var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);
        Parcelable llegada = getIntent().getParcelableExtra("box");
        Dllegada = Parcels.unwrap(llegada);
        lista2 = (ListView)findViewById(R.id.list2);
        lista2.setAdapter(new ArrayAdapter<Datos>(this,android.R.layout.simple_list_item_1, Dllegada));
        listadapter = (ListView)findViewById(R.id.list2);
        var = new adapter(this,R.layout.activity_adapter,Dllegada);
        listadapter.setAdapter(var);
    }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu, menu);

         return true;
     }
    @Override
    protected void onResume() {
        super.onResume();
        var.notifyDataSetChanged();
    }

     @Override
     public boolean onOptionsItemSelected( MenuItem item) {
      int id = item.getItemId();
      if (id == R.id.eliminarAleatorio){
          Dllegada.remove((int) (Math.random() * Dllegada.size()));
      //Dllegada.remove(Math.random()*Dllegada.size()+1);
          var.notifyDataSetChanged();
      }if (id == R.id.listarMecanicos){
          for (Datos mec: Dllegada){
              if (mec.getRadio1().equals("mecanico")){
                  auxiliar.add(mec);
              }
          }
             var = new adapter(this,R.layout.activity_adapter,auxiliar);
             listadapter.setAdapter(var);
             var.notifyDataSetChanged();
         }
         if (id == R.id.listar_automaticos){
             for (Datos mec: Dllegada){
                 if (mec.getRadio1().equals("automatico")){
                     auxiliar.add(mec);
                 }
             }
             var = new adapter(this,R.layout.activity_adapter,auxiliar);
             listadapter.setAdapter(var);
             var.notifyDataSetChanged();
         }
         return super.onOptionsItemSelected(item);

     }



 }
