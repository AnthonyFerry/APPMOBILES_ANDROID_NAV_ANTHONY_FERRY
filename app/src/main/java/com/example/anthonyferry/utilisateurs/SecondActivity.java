package com.example.anthonyferry.utilisateurs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {

    private EditText editUserName, editPassword, editMail;
    private Button btnValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        linkedObjects();

        btnValidate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                String name = editUserName.getText().toString();
                String password = editPassword.getText().toString();
                String mail = editMail.getText().toString();
                User newUser = new User(name, password, mail);

                saveObject(newUser);

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("User", newUser);

                startActivity(intent);
            }

        });
    }

    private void saveObject(User user)
    {
        final SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor MyEditor = prefs.edit();

        MyEditor.putString(user.getMail(), user.getName());
        MyEditor.apply();
    }

    private void linkedObjects()
    {
        editUserName = (EditText) findViewById(R.id.editUserName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editMail = (EditText) findViewById(R.id.editMail);
        btnValidate = (Button) findViewById(R.id.btnValidate);
    }
}
