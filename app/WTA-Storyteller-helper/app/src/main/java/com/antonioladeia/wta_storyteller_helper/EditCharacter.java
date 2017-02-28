package com.antonioladeia.wta_storyteller_helper;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditCharacter extends AppCompatActivity {

    private TextView etName;
    private TextView etBreed;
    private TextView etAuspice;
    private TextView etTribe;
    private TextView etRage;
    private TextView etGnosis;
    private TextView etWillpower;
    private TextView etHealth ;
    private int id;
    private WTADatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_character);

        etName = (TextView) findViewById(R.id.tvCharacterName);
        etBreed = (TextView)findViewById((R.id.tvCharacterBreed));
        etAuspice = (TextView)findViewById(R.id.tvCharacterAuspice);
        etTribe = (TextView)findViewById(R.id.tvCharacterTribe);
        etRage = (TextView)findViewById((R.id.tvCharacterRage));
        etGnosis = (TextView)findViewById(R.id.tvCharacterGnosis);
        etWillpower = (TextView)findViewById(R.id.tvCharacterWillpower);
        etHealth = (TextView)findViewById((R.id.tvCharacterHealth));

        id = Integer.parseInt(this.getIntent().getStringExtra("id"));

        database = new WTADatabase(this);

        Cursor cursor = database.getCharacterByID(getBaseContext(), id);

        etName.setText(cursor.getString(cursor.getColumnIndexOrThrow("NAME")));
        etAuspice.setText(cursor.getString(cursor.getColumnIndexOrThrow("AUSPICE")));
        etBreed.setText(cursor.getString(cursor.getColumnIndexOrThrow("BREED")));
        etTribe.setText(cursor.getString(cursor.getColumnIndexOrThrow("TRIBE")));
        etRage.setText(cursor.getString(cursor.getColumnIndexOrThrow("RAGE")));
        etGnosis.setText(cursor.getString(cursor.getColumnIndexOrThrow("GNOSIS")));
        etWillpower.setText(cursor.getString(cursor.getColumnIndexOrThrow("WILLPOWER")));
        etHealth.setText(cursor.getString(cursor.getColumnIndexOrThrow("HEALTH")));

    }

    public void editCharacter(View view){

    }

    public void deleteCharacter(View view){
        Context context = getBaseContext();
        try {
            database.deletCharacter(context, id);
            Toast.makeText(context, getString(R.string.characterSucessfullyDeleted), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EditCharacter.this, MainActivity.class);
            startActivity(intent);

        } catch (Exception e) {

            Toast.makeText(context, getString(R.string.errorDeletCharacter), Toast.LENGTH_SHORT).show();
        }
    }

    public void ragePlus(View view) {
        int rage = Integer.parseInt(etRage.getText().toString());
        rage++;
        etRage.setText(String.valueOf(rage));
        database.updateRage(getBaseContext(), rage, id);
    }

    public void rageMinus(View view) {
        int rage = Integer.parseInt(etRage.getText().toString());
        rage--;
        etRage.setText(String.valueOf(rage));
        database.updateRage(getBaseContext(), rage, id);
    }

    public void gnosisPlus(View view) {
        int gnosis = Integer.parseInt(etGnosis.getText().toString());
        gnosis++;
        etGnosis.setText(String.valueOf(gnosis));
        database.updateGnosis(getBaseContext(), gnosis, id);
    }

    public void gnosisMinus(View view) {
        int gnosis = Integer.parseInt(etGnosis.getText().toString());
        gnosis--;
        etGnosis.setText(String.valueOf(gnosis));
        database.updateGnosis(getBaseContext(), gnosis, id);
    }

    public void willpowerPlus(View view) {
        int willpower = Integer.parseInt(etWillpower.getText().toString());
        willpower++;
        etWillpower.setText(String.valueOf(willpower));
        database.updateWillpower(getBaseContext(), willpower, id);
    }

    public void willpowerMinus(View view) {
        int willpower = Integer.parseInt(etWillpower.getText().toString());
        willpower--;
        etWillpower.setText(String.valueOf(willpower));
        database.updateWillpower(getBaseContext(), willpower, id);
    }

    public void healthPlus(View view) {
        int health = Integer.parseInt(etHealth.getText().toString());
        health++;
        etHealth.setText(String.valueOf(health));
        database.updateHealth(getBaseContext(), health, id);
    }

    public void healthMinus(View view) {
        int health = Integer.parseInt(etHealth.getText().toString());
        health--;
        etHealth.setText(String.valueOf(health));
        database.updateHealth(getBaseContext(), health, id);
    }

    public void backHome(View view) {
        Intent intent = new Intent(EditCharacter.this, MainActivity.class);
        startActivity(intent);
    }
}
