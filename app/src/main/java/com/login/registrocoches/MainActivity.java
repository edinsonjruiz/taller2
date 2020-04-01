package com.login.registrocoches;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    RadioGroup list;
    EditText placa, marca;
    String TAG,seleccionado;
    TextView modelo;
    Button save, press, press2,select;
    RadioButton rb1,rb2;
    DatePickerDialog.OnDateSetListener models;
    ArrayList<Datos> contactos = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        placa = (EditText) findViewById(R.id.placa);
        marca = (EditText) findViewById(R.id.marca);
        list = (RadioGroup) findViewById(R.id.list);
        save = (Button) findViewById(R.id.save);
        press = (Button)findViewById(R.id.Ldatos);
        press2 = (Button)findViewById(R.id.eliminarAleatorio);
        rb1 = (RadioButton)findViewById(R.id.mecanico);
        rb2 = (RadioButton)findViewById(R.id.automatico);
        modelo = (TextView) findViewById(R.id.moan);

        ArrayAdapter<CharSequence> modelador = ArrayAdapter.createFromResource(this, R.array.modelos, android.R.layout.simple_list_item_single_choice);


        modelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar fecha = Calendar.getInstance();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH);
                int día = fecha.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        models,
                        año,mes,día);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        models = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
                mes = mes + 1;
                Log.d(TAG,"onDateSet: mm/dd/yyy: " + mes + "/" + dia + "/" + año);

                String date = mes + "/" + dia  + "/" + año;
                modelo.setText(date);

            }
        };

        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parcelable send = Parcels.wrap(contactos);

                Intent intent = new Intent(MainActivity.this,Filtro.class);
                intent.putExtra("box", send);
                startActivity(intent);
            }
        });

        press2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placa.setText("");
                marca.setText("");
                modelo.setText("");

            }
        });






        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!placa.getText().toString().equals("") && !marca.getText().toString().equals("") && !modelo.getText().toString().equals("")
                        && !rb1.getText().toString().equals("") || !rb2.getText().toString().equals("")){
                    boolean estado = rb1.isChecked();
                    if (estado == true){
                        seleccionado = "mecanico";
                    }else{
                        seleccionado = "automatico";
                    }
                    contactos.add (new Datos(placa.getText().toString(), marca.getText().toString(),modelo.getText().toString(),seleccionado));
                    Toast.makeText(getApplicationContext(),"Adición Exitosa",Toast.LENGTH_LONG);
                }else{

                    Toast.makeText(getApplicationContext(),"Vacio",Toast.LENGTH_LONG);
                }
            }
        });









    }

}
