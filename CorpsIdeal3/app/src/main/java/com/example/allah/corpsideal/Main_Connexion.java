package com.example.allah.corpsideal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main_Connexion extends AppCompatActivity {
    private CheckBox check_session;
    private EditText a, b;

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__connexion);

        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sh.edit();

        a = (EditText) findViewById(R.id.pseudo_cnx);
        b = (EditText) findViewById(R.id.pass_cnx);
        check_session = (CheckBox) findViewById(R.id.checkBox);


        String login = sh.getString("login", null);
        String password = sh.getString("password", null);
        Boolean check = sh.getBoolean("check", false);

        if (check) {
            a.setText(login.toString());
            b.setText(password.toString());
            check_session.setChecked(true);
        } else {
            a.setText("");
            b.setText("");
            check_session.setChecked(false);
        }


    }

    public void onButtonClick(View v) {

        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sh.edit();


        if (v.getId() == R.id.btn_cnx) {


            if (check_session.isChecked()) {
                edit.putString("login", a.getText().toString());
                edit.putString("password", b.getText().toString());
                edit.putBoolean("check", true);
                edit.commit();

            } else {

                edit.putBoolean("check", false);
                edit.commit();
            }


            String str = a.getText().toString();
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if (pass.equals(password)) {
                Intent i = new Intent(Main_Connexion.this, Main_Menu.class);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(Main_Connexion.this, "Verifier les coordonnées saisie", Toast.LENGTH_SHORT);
                temp.show();
            }


        }


    }

}
