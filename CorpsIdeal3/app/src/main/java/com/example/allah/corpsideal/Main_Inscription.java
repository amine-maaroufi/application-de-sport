package com.example.allah.corpsideal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_Inscription extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    boolean completed;
    SharedPreferences sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__inscription);

        sharedPrefs = getSharedPreferences("sharedprefs", 0);

        completed = sharedPrefs.getBoolean("complete", false);

        if (completed == true) {
            Intent intent = new Intent();
            intent.setClass(Main_Inscription.this, Main_Connexion.class);
            startActivity(intent);
            finish();
        }


    }

    //fonction de validation email

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }

    public void onSignUpClick(View v)

    {
        if(v.getId()== R.id.btn_inscri)

        {
            //sharedPrefs = getSharedPreferences("sharedprefs", 0);

            EditText nom = (EditText)findViewById(R.id.nom_insc);
            EditText prenom = (EditText)findViewById(R.id.prenom_insc);
            EditText email = (EditText)findViewById(R.id.email_insc);
            EditText pseudo = (EditText)findViewById(R.id.pseudo_insc);
            EditText pass1 = (EditText)findViewById(R.id.pass_insc);
            EditText pass2 = (EditText)findViewById(R.id.confirm_pass_insc);


            String nomstr = nom.getText().toString();
            String prenomstr = prenom.getText().toString();
            String emailstr = email.getText().toString();
            String pseudostr = pseudo.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            /**teste sur la correspandence de mots de passe*/
            if(!pass1str.equals(pass2str))
            {
                //popup msg
                Toast pass = Toast.makeText(Main_Inscription.this , "Les mots de passe ne sont pas identiques" , Toast.LENGTH_SHORT);
                pass.show();
            }
            /**teste sur les champs vide*/
            else if(nom.getText().length() == 0)
            {
                Toast t= Toast.makeText(getApplicationContext(),"Svp saisir votre Nom",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 300);
                t.show();
            }
            else if (prenom.getText().length() == 0)
            {
                Toast t= Toast.makeText(getApplicationContext(),"svp saisir votre Prènom",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 300);
                t.show();
            }
            else if (email.getText().length() == 0)
            {
                Toast t= Toast.makeText(getApplicationContext(),"svp saisir votre email",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 300);
                t.show();
            }
           else if (!(isEmailValid(email.getText().toString().trim())))
            {
                Toast t= Toast.makeText(getApplicationContext(),"addresse email n'est pas valide",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 300);
                t.show();
            }
            else if (pseudo.getText().length() == 0)
            {
                Toast t= Toast.makeText(getApplicationContext(),"svp saisir votre pseudo",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 300);
                t.show();
            }
            else if (pass1.getText().length() == 0)
            {
                Toast t= Toast.makeText(getApplicationContext(),"svp saisir votre mot de passe",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 300);
                t.show();
            }
            else
            {
                //insert the detailes in database
                Sportif s = new Sportif();
                s.setNom(nomstr);
                s.setPrenom(prenomstr);
                s.setEmail(emailstr);
                s.setPseudo(pseudostr);
                s.setPass(pass1str);

                helper.insertSportif(s);

                SharedPreferences.Editor editors = sharedPrefs.edit();
                editors.putString("spnom", nom.getText().toString());
                editors.putString("spprenom", prenom.getText().toString());
                editors.putString("spemail", email.getText().toString());
                editors.putString("splogin", pseudo.getText().toString());
                editors.putString("sppswd", pass1.getText().toString());
                editors.putBoolean("complete", true);
                editors.commit();

                Intent i = new Intent(Main_Inscription.this, Main_Connexion.class);
                startActivity(i);

                Toast reussi = Toast.makeText(Main_Inscription.this , "Inscription avec succée" , Toast.LENGTH_SHORT);
                reussi.show();
            }

        }

    }

}
