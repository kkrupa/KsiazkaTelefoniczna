package com.kkrupa.android.nauka.ksiazkatelefoniczna;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText imie = null;
    EditText nazwisko = null;
    EditText numerTel = null;
    EditText email = null;
    ListView lista = null;
    ArrayList<Osoba> osoby = new ArrayList<Osoba>();
    Adapter4Osoba adapter = null;
    String imieText = null;
    String nazwiskoText = null;
    String numerTelText = null;
    String emailText = null;
    KontaktyOpenHelper db;
    Toast toast;

    public void onSave(View v) {
        imieText = imie.getText().toString();
        nazwiskoText = nazwisko.getText().toString();
        numerTelText = numerTel.getText().toString();
        emailText = email.getText().toString();

        Osoba osoba = new Osoba(imieText, nazwiskoText, numerTelText, emailText);
        adapter.add(osoba);
//        db.insertContact(imieText, nazwiskoText, numerTelText, emailText);
        if(db.insertContact(imieText, nazwiskoText, numerTelText, emailText)) {
            toast = Toast.makeText(this, "Dodano nowy wpis.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast = Toast.makeText(this, "Wystąpił błąd, spróbuj ponownie.", Toast.LENGTH_SHORT);
            toast.show();
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new KontaktyOpenHelper(this);

        imie = (EditText)findViewById(R.id.idImie);
        nazwisko = (EditText)findViewById(R.id.idNazwisko);
        numerTel = (EditText)findViewById(R.id.idNrTel);
        email = (EditText)findViewById(R.id.idEmail);
        lista = (ListView)findViewById(R.id.idLista);
        adapter = new Adapter4Osoba(this, osoby);

        lista.setAdapter(adapter);

    }
}
