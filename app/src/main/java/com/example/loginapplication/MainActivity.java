package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private Button eRegister;
    private TextView eAttemptInfo;
    private CheckBox eRememberMe;

    boolean is_valid = false;
    private int counter = 5;
    SharedPreferences preferences;
    SharedPreferences.Editor preferenceEdit;

    public Credentials credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.Loginbutton);
        eAttemptInfo = findViewById(R.id.AttemptsNo);
        eRegister = findViewById(R.id.Regbutton);
        eRememberMe = findViewById(R.id.cdRemUser);

        preferences = getApplicationContext().getSharedPreferences("CredentialsDb", MODE_PRIVATE);
        preferenceEdit = preferences.edit();

        credentials = new Credentials();

        if(preferences != null ){

            Map<String, ?> preferencesMap = preferences.getAll();
            if (preferencesMap.size() != 0){
                credentials.LoadCredentials(preferencesMap);
            }

            String savedUsername = preferences.getString("LastSavedUser", "");
            String savedPw = preferences.getString("LastSavedPw", "");

            if(preferences.getBoolean("Remember Me", false)){ // default checkbox value would be false
                eName.setText(savedUsername);
                ePassword.setText(savedPw);
                eRememberMe.setChecked(true);
            }
        }
        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });


        eLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all text fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    is_valid = validate(inputName, inputPassword);
                    if (!is_valid){
                        counter-- ;
                        Toast.makeText(MainActivity.this, "Incorrect Name or Password", Toast.LENGTH_SHORT).show();
                        eAttemptInfo.setText("No. of Attempts remaining: "+counter);
                        if (counter == 0){
                            eLogin.setEnabled(false);
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        preferenceEdit.putString("LastSavedUser", inputName);
                        preferenceEdit.putString("LastSavedPw", inputPassword);
                        preferenceEdit.apply();
                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }


                }
            }
        });
    }
    private boolean validate(String name, String password){
        return credentials.VerifyCredentials(name, password);
    }
}