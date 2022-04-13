package com.example.sharedpreferencesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView name;
    TextView email;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the text view from xml layout
        name = findViewById(R.id.txtname);
        email = findViewById(R.id.txtemail);
        // instanciate sharedoreferences file and mode ( private only this app has acces to this file
        sharedpreferences = getSharedPreferences("mypref",
                MODE_PRIVATE);
        // check if the file has already an attriobue name and get its value and set textview else use space
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        // check if the file has already an attribute email and get its value and set textview else use space
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
    }

    // sauvegarder les donne dans le fichier de preference partages
    public void Save(View view) {
        // recuoperation des donnéedepuis edittext
        String n = name.getText().toString();
        String e = email.getText().toString();
        // Initialiser un editeur
        SharedPreferences.Editor editor = sharedpreferences.edit();
        // ajouter les données
        editor.putString(Name, n);
        editor.putString(Email, e);
        // sauvegarder
        editor.commit();
    }
// vider le fichier supprimrer les pereferences
    public void clear(View view) {
        // recuperation des edittexts
        name =  findViewById(R.id.txtname);
        email =  findViewById(R.id.txtemail);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove("nameKey"); // supp le tag namekey
        editor.remove("emailKey"); // supp le tag emailkey
        // valider la suppression
        editor.commit();
        // vider les edittexts
        name.setText("");
        email.setText("");

    }
// charger les pereference sur l'appli
    public void Get(View view) {
        // recuperation des edittexts
        name = findViewById(R.id.txtname);
        email = findViewById(R.id.txtemail);
        // Instatiate sharedpreferences par GetSharedpreferences mode prive
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
    }

}