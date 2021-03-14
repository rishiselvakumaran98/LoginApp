package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText eRegName;
    private EditText eRegPw;
    private Button eRegister;

    public Credentials credentials;
    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        eRegName = findViewById(R.id.getEmailAddress);
        eRegPw = findViewById(R.id.getPassword);
        eRegister = findViewById(R.id.btnRegister);

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getApplicationContext().getSharedPreferences("CredentialsDb", MODE_PRIVATE);
                preferencesEditor = preferences.edit();
                credentials = new Credentials();
                String new_username = eRegName.getText().toString();
                String new_password = eRegPw.getText().toString();
                if(UserValidate(new_username, new_password)) {
                    if (!credentials.CheckUsernameTaken(new_username)){
                        credentials.AddCredentials(new_username, new_password); // Add the newUsername and password to the HashMap
                        preferencesEditor.putString(new_username, new_password); // Store the credentials in a offline file in the device

                        preferencesEditor.putString("LastSavedUser", new_username);
                        preferencesEditor.putString("LastSavedPw", new_password);

                        preferencesEditor.apply(); // command used to commit the changes and add them to the offline file
                        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                        Toast.makeText(RegistrationActivity.this,"Welcome to my first Login App!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this,"Sorry Username is already taken", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
    private boolean UserValidate(String newUser, String newPw){

        if (newUser.isEmpty() || newPw.isEmpty()){
            Toast.makeText(this,"Please enter valid Email and Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
}
