package com.example.allah.corpsideal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Main_caraterestiques_corporelle extends AppCompatActivity implements View.OnClickListener {
    EditText poids, taille, age;
    Button btnEnreg,btnSuivre;
    ImageButton imageButtonimc,imageButtonimg;
    TextView resultat,interpretaion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_caraterestiques_corporelle);

        final RadioGroup rg = (RadioGroup) findViewById(R.id.group);
        final EditText poids = (EditText) findViewById(R.id.edtpoid);
        final EditText taille = (EditText) findViewById(R.id.edttaille);
        final EditText age = (EditText) findViewById(R.id.edtage);
        btnEnreg=(Button)findViewById(R.id.btnEnrgRes);
        btnEnreg.setOnClickListener(this);
        btnSuivre=(Button)findViewById(R.id.btnSuivreRes);
        btnSuivre.setOnClickListener(this);
        imageButtonimc=(ImageButton)findViewById(R.id.imageButtonImc);
        imageButtonimc.setOnClickListener(this);

       imageButtonimg =(ImageButton)findViewById(R.id.imageButtonImg);
        imageButtonimg.setOnClickListener(this);


        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String strpoids = poids.getText().toString();
                    String strtaille = taille.getText().toString();
                    String strage = age.getText().toString();
                    TextView txtimc = (TextView) findViewById(R.id.resimc);
                    double dpoids = Double.parseDouble(strpoids);
                    double dtaille = Double.parseDouble(strtaille);
                    final   double dage = Double.parseDouble(strage);
                    // double dage = Double.parseDouble(strage);
                    final double IMC = dpoids / (dtaille * dtaille);
                    String strimc = "" + IMC;
                    final String sstrimc = strimc.substring(0, 5);
                    txtimc.setText("IMC:"+sstrimc);
                    /***************************/
                    TextView txtInterp = (TextView) findViewById(R.id.textInterp);
                    if (IMC <= 16)
                    {
                        txtInterp.setText("Votre indice est un très faible, c'est à dire que vous êtes très maigre. Il faut faire très attention, je vous recomande de voir un nutrioniste!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=18 && IMC >16)
                    {
                        txtInterp.setText("Votre indice est faible, vous êtes maigre, il faut surveiller votre ligne!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=20 && IMC >18)
                    {
                        txtInterp.setText("Vous êtes en leger et sous-poids.Il faut manger!!!");
                        txtInterp.setTextColor(Color.parseColor("#fede29"));
                    }
                    if (IMC <=24 && IMC >20)
                    {
                        txtInterp.setText("Vous êtes dans la moyenne, ne vous inquietez pas!");
                        txtInterp.setTextColor(Color.parseColor("#FF01B60A"));
                    }
                    if (IMC <=26 && IMC >24)
                    {
                        txtInterp.setText("Vous êtes en très leger sur-poids, ce n'est pas bien grave");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=28 && IMC >26)
                    {
                        txtInterp.setText("Vous êtes en sur-poids mais ce n'est pas iratrappable!");
                        txtInterp.setTextColor(Color.parseColor("#fede29"));
                    }
                    if (IMC <=32 && IMC >28)
                    {
                        txtInterp.setText("Vous êtes en sur-poids!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC >32)
                    {
                        txtInterp.setText("Vous êtes vraiment en sur-poids, je vous conseil de voir un nutritioniste pour qu'il vous adapte un regime personnalisé.");
                    }
/***********************/
                    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group);

                    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                        @Override

                        public void onCheckedChanged(RadioGroup group, int checkedId) {

                            if (checkedId == R.id.rh) {
                                Double IMG = 1.2 * IMC + 0.23 * dage - 10.8 * 1 - 5.4;
                                String strimg = IMG.toString();
                                String sstrimg = strimg.substring(0, 5);
                                TextView resultatimg = (TextView) findViewById(R.id.imgres);
                                resultatimg.setText("IMG:" + sstrimg + "%");
                            } else if (checkedId == R.id.rf) {
                                Double IMG = 1.2 * IMC + 0.23 * dage - 10.8 * 0 - 5.4;
                                String strimg = IMG.toString();
                                String sstrimg = strimg.substring(0, 5);
                                TextView resultatimg = (TextView) findViewById(R.id.imgres);
                                resultatimg.setText("IMG:" + sstrimg + "%");
                            }

                        }


                    });

                } catch (Exception e) {
                    TextView txtimc = (TextView) findViewById(R.id.resimc);
                    txtimc.setText("00");
                    TextView resultatimg = (TextView) findViewById(R.id.imgres);
                    resultatimg.setText("00");
                    TextView interp = (TextView) findViewById(R.id.textInterp);
                    interp.setText("  ");
                }


            }


        });

        taille.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String strpoids = poids.getText().toString();
                    String strtaille = taille.getText().toString();
                    String strage = age.getText().toString();
                    TextView txtimc = (TextView) findViewById(R.id.resimc);
                    double dpoids = Double.parseDouble(strpoids);
                    double dtaille = Double.parseDouble(strtaille);
                    final double dage = Double.parseDouble(strage);
                    // double dage = Double.parseDouble(strage);
                    final double IMC = dpoids / (dtaille * dtaille);
                    String strimc = "" + IMC;
                    final String sstrimc = strimc.substring(0, 5);
                    txtimc.setText("IMC:" + sstrimc);
                    /***************************/
                    TextView txtInterp = (TextView) findViewById(R.id.textInterp);
                    if (IMC <= 16)
                    {
                        txtInterp.setText("Votre indice est un très faible, c'est à dire que vous êtes très maigre. Il faut faire très attention, je vous recomande de voir un nutrioniste!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=18 && IMC >16)
                    {
                        txtInterp.setText("Votre indice est faible, vous êtes maigre, il faut surveiller votre ligne!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=20 && IMC >18)
                    {
                        txtInterp.setText("Vous êtes en leger et sous-poids.Il faut manger!!!");
                        txtInterp.setTextColor(Color.parseColor("#fede29"));
                    }
                    if (IMC <=24 && IMC >20)
                    {
                        txtInterp.setText("Vous êtes dans la moyenne, ne vous inquietez pas!");
                        txtInterp.setTextColor(Color.parseColor("#FF01B60A"));
                    }
                    if (IMC <=26 && IMC >24)
                    {
                        txtInterp.setText("Vous êtes en très leger sur-poids, ce n'est pas bien grave");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=28 && IMC >26)
                    {
                        txtInterp.setText("Vous êtes en sur-poids mais ce n'est pas iratrappable!");
                        txtInterp.setTextColor(Color.parseColor("#fede29"));
                    }
                    if (IMC <=32 && IMC >28)
                    {
                        txtInterp.setText("Vous êtes en sur-poids!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC >32)
                    {
                        txtInterp.setText("Vous êtes vraiment en sur-poids, je vous conseil de voir un nutritioniste pour qu'il vous adapte un regime personnalisé.");
                    }
/***********************/
                    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group);

                    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                        @Override

                        public void onCheckedChanged(RadioGroup group, int checkedId) {

                            if (checkedId == R.id.rh) {
                                Double IMG = 1.2 * IMC + 0.23 * dage - 10.8 * 1 - 5.4;
                                String strimg = IMG.toString();
                                String sstrimg = strimg.substring(0, 5);
                                TextView resultatimg = (TextView) findViewById(R.id.imgres);
                                resultatimg.setText("IMG:" + sstrimg + "%");
                            } else if (checkedId == R.id.rf) {
                                Double IMG = 1.2 * IMC + 0.23 * dage - 10.8 * 0 - 5.4;
                                String strimg = IMG.toString();
                                String sstrimg = strimg.substring(0, 5);
                                TextView resultatimg = (TextView) findViewById(R.id.imgres);
                                resultatimg.setText("IMG:" + sstrimg + "%");
                            }

                        }


                    });

                } catch (Exception e) {
                    TextView txtimc = (TextView) findViewById(R.id.resimc);
                    txtimc.setText("00");
                    TextView resultatimg = (TextView) findViewById(R.id.imgres);
                    resultatimg.setText("00");
                    TextView Interpretation = (TextView) findViewById(R.id.textInterp);
                    Interpretation.setText("  ");

                }


            }


        });

        poids.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String strpoids = poids.getText().toString();
                    String strtaille = taille.getText().toString();
                    String strage = age.getText().toString();
                    TextView txtimc = (TextView) findViewById(R.id.resimc);
                    double dpoids = Double.parseDouble(strpoids);
                    double dtaille = Double.parseDouble(strtaille);
                    final double dage = Double.parseDouble(strage);
                    // double dage = Double.parseDouble(strage);
                    final double IMC = dpoids / (dtaille * dtaille);
                    String strimc = "" + IMC;
                    final String sstrimc = strimc.substring(0, 5);
                    txtimc.setText("IMC:" + sstrimc);

                    /***************************/
                    TextView txtInterp = (TextView) findViewById(R.id.textInterp);
                    if (IMC <= 16)
                    {
                        txtInterp.setText("Votre indice est un très faible, c'est à dire que vous êtes très maigre. Il faut faire très attention, je vous recomande de voir un nutrioniste!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=18 && IMC >16)
                    {
                        txtInterp.setText("Votre indice est faible, vous êtes maigre, il faut surveiller votre ligne!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=20 && IMC >18)
                    {
                        txtInterp.setText("Vous êtes en leger et sous-poids.Il faut manger!!!");
                        txtInterp.setTextColor(Color.parseColor("#fede29"));
                    }
                    if (IMC <=24 && IMC >20)
                    {
                        txtInterp.setText("Vous êtes dans la moyenne, ne vous inquietez pas!");
                        txtInterp.setTextColor(Color.parseColor("#FF01B60A"));
                    }
                    if (IMC <=26 && IMC >24)
                    {
                        txtInterp.setText("Vous êtes en très leger sur-poids, ce n'est pas bien grave");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC <=28 && IMC >26)
                    {
                        txtInterp.setText("Vous êtes en sur-poids mais ce n'est pas iratrappable!");
                        txtInterp.setTextColor(Color.parseColor("#fede29"));
                    }
                    if (IMC <=32 && IMC >28)
                    {
                        txtInterp.setText("Vous êtes en sur-poids!");
                        txtInterp.setTextColor(Color.parseColor("#FFFC192C"));
                    }
                    if (IMC >32)
                    {
                        txtInterp.setText("Vous êtes vraiment en sur-poids, je vous conseil de voir un nutritioniste pour qu'il vous adapte un regime personnalisé.");
                    }
/***********************/

                    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group);

                    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                        @Override

                        public void onCheckedChanged(RadioGroup group, int checkedId) {

                            if (checkedId == R.id.rh) {
                                Double IMG = 1.2 * IMC + 0.23 * dage - 10.8 * 1 - 5.4;
                                String strimg = IMG.toString();
                                String sstrimg = strimg.substring(0, 5);
                                TextView resultatimg = (TextView) findViewById(R.id.imgres);
                                resultatimg.setText("IMG:" + sstrimg + "%");



                            } else if (checkedId == R.id.rf) {
                                Double IMG = 1.2 * IMC + 0.23 * dage - 10.8 * 0 - 5.4;
                                String strimg = IMG.toString();
                                String sstrimg = strimg.substring(0, 5);
                                TextView resultatimg = (TextView) findViewById(R.id.imgres);
                                resultatimg.setText("IMG:" + sstrimg + "%");
                            }

                        }


                    });

                } catch (Exception e) {
                    TextView txtimc = (TextView) findViewById(R.id.resimc);
                    txtimc.setText("00");
                    TextView resultatimg = (TextView) findViewById(R.id.imgres);
                    resultatimg.setText("00");
                    TextView interp = (TextView) findViewById(R.id.textInterp);
                    interp.setText("  ");
                }


            }


        });
    }

    @Override
    public void onClick(View v) {

        final Context context = v.getContext();
            if(v.getId()==btnEnreg.getId())
            {
                final TextView textimc = (TextView)findViewById(R.id.resimc);
                final TextView textimg = (TextView)findViewById(R.id.imgres);


                String TEXTIMC = textimc.getText().toString();
                String TEXTIMG = textimg.getText().toString();
                //String TEXTDate = "11/05/2016";

                ObjectCritere objectCritere = new ObjectCritere();
                objectCritere.IMC = TEXTIMC;
                objectCritere.IMG = TEXTIMG;
                //objectCritere.Date = TEXTDate;

                boolean createSuccessful = new TableControllerCritere(context).create(objectCritere);

                if (createSuccessful) {
                    Toast.makeText(context, "Ajout avec succée.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Impossible d\'enregistrer les caractéres.", Toast.LENGTH_SHORT).show();
                }
            }else if(v.getId()==imageButtonimc.getId())
        {
            AlertDialog alertDialog = new AlertDialog.Builder(Main_caraterestiques_corporelle.this).create();
            alertDialog.setTitle("Indice de masse corporelle");
            alertDialog.setMessage("L'indice de masse corporelle (IMC) est une grandeur qui permet d’estimer la corpulence d’une personne.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }else if(v.getId()==imageButtonimg.getId())
            {
                AlertDialog alertDialog = new AlertDialog.Builder(Main_caraterestiques_corporelle.this).create();
                alertDialog.setTitle("Indice de masse graisseuse");
                alertDialog.setMessage("L’indice de masse grasse (IMG) est un indice, exprimé en pourcentage," +
                        " permettant de juger de la proportion de tissus adipeux d’une personne, " +
                        "qui rend compte de la disproportion entre la masse de graisse et celles des muscles.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }else if (v.getId()==btnSuivre.getId())
            {
                Intent i = new Intent(Main_caraterestiques_corporelle.this,SuivreCaracteres.class);
                startActivity(i);
            }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_caraterestiques_corporelle.this,Main_Menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.deconnexion) {

            //le code lorsque je clique sur item home
            Intent i =new Intent(Main_caraterestiques_corporelle.this,Main_Connexion.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.apropos) {

            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.apropos, null, false);



            AlertDialog alertDialog = new AlertDialog.Builder(Main_caraterestiques_corporelle.this).create();
            alertDialog.setTitle("à propos");
            alertDialog.setView(formElementsView);
           /* alertDialog.setMessage(" cette application permettre ");*/
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
