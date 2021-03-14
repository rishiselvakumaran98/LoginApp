package com.example.loginapplication;

import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Credentials {

    HashMap<String, String> credentialsHashMap = new  HashMap<String, String>();

    public void AddCredentials(String Username, String Password){
        credentialsHashMap.put(Username, Password);
    }
    public boolean CheckUsernameTaken(String User){
        if(credentialsHashMap.isEmpty()) return false;
        return credentialsHashMap.containsKey(User);
    }

    public boolean VerifyCredentials(String Username, String Pw){
        System.out.println(credentialsHashMap.toString());

        if (credentialsHashMap.containsKey(Username)){
            if (Pw.equals(credentialsHashMap.get(Username))){
                return true;
            }
        }
        return false;
    }

    public void LoadCredentials(Map<String, ?> preference_Map){
        for (Map.Entry<String, ?> entries : preference_Map.entrySet()){
            if(!entries.getKey().equals("Remember Me")){
                credentialsHashMap.put(entries.getKey(), entries.getValue().toString());
            }
        }
    }
}
