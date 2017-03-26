package com.antonioladeia.wta_storyteller_helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CreateCharacter extends AppCompatActivity {

    private EditText etName;
    private EditText etBreed;
    private EditText etAuspice;
    private EditText etTribe;
    private EditText etRage;
    private EditText etGnosis;
    private EditText etWillpower;
    private EditText etHealth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = (EditText) findViewById(R.id.etCharacterName);
        etBreed = (EditText)findViewById((R.id.etCharacterBreed));
        etAuspice = (EditText)findViewById(R.id.etcharacterAuspice);
        etTribe = (EditText)findViewById(R.id.etCharacterTribe);
        etRage = (EditText)findViewById((R.id.etCharacterRage));
        etGnosis = (EditText)findViewById(R.id.etCharacterGnosis);
        etWillpower = (EditText)findViewById(R.id.etCharacterWillpower);
        etHealth = (EditText)findViewById((R.id.etCharacterHealth));
    }

    public void saveCharacter(View view){

        PlayerCharacter player = populateCharacter();
        Context context = getBaseContext();
        WTADatabase database = new WTADatabase(this);
        Intent intent = new Intent(CreateCharacter.this, MainActivity.class);

        try {
            database.insertCharacter(player, context);
            Toast.makeText(context, getString(R.string.characterSaved), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, getString(R.string.errorSaveCharacter)+" "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }

    private PlayerCharacter populateCharacter() {
        PlayerCharacter player = new PlayerCharacter();

        player.setCharacterName(etName.getText().toString());
        player.setCharacterAuspice(etAuspice.getText().toString());
        player.setCharacterBreed(etBreed.getText().toString());
        player.setCharacterTribe(etTribe.getText().toString());
        player.setCharacterRage(Integer.parseInt(etRage.getText().toString()));
        player.setCharacterGnosis(Integer.parseInt(etGnosis.getText().toString()));
        player.setCharacterWillpower(Integer.parseInt(etWillpower.getText().toString()));
        player.setCharacterHealth(Integer.parseInt(etHealth.getText().toString()));

        return player;
    }
}
