package com.antonioladeia.wta_storyteller_helper;

import android.content.ContentValues;

/**
 * Created by ladeia on 27/02/17.
 */
public class PlayerCharacter {
    private String characterName;
    private String characterBreed;
    private String characterAuspice;
    private String characterTribe;
    private int characterRage;
    private int characterWillpower;
    private int characterGnosis;
    private int characterHealth;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterBreed() {
        return characterBreed;
    }

    public void setCharacterBreed(String characterBreed) {
        this.characterBreed = characterBreed;
    }

    public String getCharacterAuspice() {
        return characterAuspice;
    }

    public void setCharacterAuspice(String characterAuspice) {
        this.characterAuspice = characterAuspice;
    }

    public String getCharacterTribe() {
        return characterTribe;
    }

    public void setCharacterTribe(String characterTribe) {
        this.characterTribe = characterTribe;
    }

    public int getCharacterRage() {
        return characterRage;
    }

    public void setCharacterRage(int characterRage) {
        this.characterRage = characterRage;
    }

    public int getCharacterWillpower() {
        return characterWillpower;
    }

    public void setCharacterWillpower(int characterWillpower) {
        this.characterWillpower = characterWillpower;
    }

    public int getCharacterGnosis() {
        return characterGnosis;
    }

    public void setCharacterGnosis(int characterGnosis) {
        this.characterGnosis = characterGnosis;
    }

    public int getCharacterHealth() {
        return characterHealth;
    }

    public void setCharacterHealth(int characterHealth) {
        this.characterHealth = characterHealth;
    }

    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put("NAME", this.getCharacterName());
        values.put("BREED", this.getCharacterBreed());
        values.put("AUSPICE", this.getCharacterAuspice());
        values.put("TRIBE", this.getCharacterTribe());
        values.put("RAGE", this.getCharacterRage());
        values.put("GNOSIS", this.getCharacterGnosis());
        values.put("WILLPOWER", this.getCharacterWillpower());
        values.put("HEALTH", this.getCharacterHealth());

        return values;
    }
}

