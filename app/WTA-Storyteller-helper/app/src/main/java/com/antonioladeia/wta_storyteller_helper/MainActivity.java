package com.antonioladeia.wta_storyteller_helper;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    private ListView lvCharacter ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        try {
            this.getCharacters();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createNewCharacter(View view){
        Intent it = new Intent(MainActivity.this, CreateCharacter.class);
        startActivity(it);
    }

    public void about(View view){
        Intent it = new Intent(MainActivity.this, About.class);
        startActivity(it);
    }

    public void getCharacters() throws Exception {
        WTADatabase database = new WTADatabase(this);
        Context context = getBaseContext();
        final Cursor cursor = database.getCharacters(context);

        String[] fieldNames = new String[] {"_id", "NAME"};
        int[] idViews = new int[] {R.id.idCharacter, R.id.nameCharacter};
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(context,
                R.layout.character, cursor, fieldNames, idViews, 0);

        if (listAdapter.getCount() > 0) {
            lvCharacter = (ListView) findViewById(android.R.id.list);
            lvCharacter.setAdapter(listAdapter);

            lvCharacter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String codigo;
                    cursor.moveToPosition(position);
                    codigo = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                    Intent intent = new Intent(MainActivity.this, EditCharacter.class);
                    intent.putExtra("id", codigo);
                    startActivity(intent);
                    finish();
                }
            });

            findViewById(R.id.textViewNoItems).setVisibility(View.GONE);
            lvCharacter.setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.textViewNoItems).setVisibility(View.VISIBLE);
            lvCharacter.setVisibility(View.GONE);
        }
    }
}
