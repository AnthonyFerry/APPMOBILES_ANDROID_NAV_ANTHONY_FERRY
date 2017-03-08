package com.example.anthonyferry.utilisateurs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    private Button btnCreate;
    private ListView userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkedObjects();

        displayPreferences();

        Intent intent = getIntent();

        User user = intent.getParcelableExtra("User");
        if (user != null)
        {
            Toast.makeText(this, "Nom : " + user.getName(), Toast.LENGTH_SHORT).show();
            Log.e("Nom", user.getName());
            Toast.makeText(this, "Mot de passe : " + user.getPassword(), Toast.LENGTH_SHORT).show();
            Log.e("Mot de passe", user.getPassword());
            Toast.makeText(this, "Mail : " + user.getMail(), Toast.LENGTH_SHORT).show();
            Log.e("Mail", user.getMail());
        }

        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(myIntent);
            }
        });
    }

    protected void onRestart() {
        displayPreferences();
    }

    private void displayPreferences()
    {
        final SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        Map<String, ?> map = prefs.getAll();
        List<String> values = new ArrayList<String>();
        for (Map.Entry<String, ?> entry : map.entrySet())
        {
            values.add(entry.getKey() + " / " + entry.getValue().toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        userList.setAdapter(adapter);
    }

    private void linkedObjects()
    {
        btnCreate = (Button) findViewById(R.id.btn_create);
        userList = (ListView) findViewById(R.id.userList);
    }
}
