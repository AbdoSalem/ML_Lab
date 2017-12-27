package com.hci.apps.ml_lab.firebase;

import android.content.SharedPreferences;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hci.apps.ml_lab.MLApplication;

import java.util.UUID;

/**
 * Created by abdo on 26/12/17.
 */

public class DatabaseManager {
    private static final DatabaseManager ourInstance = new DatabaseManager();
    private static String ID;
    private static final String ID_KEY="ID_KEY";
    static FirebaseDatabase database;
    static DatabaseReference myRef;
    public static DatabaseManager getInstance() {
        return ourInstance;
    }

    private DatabaseManager() {

    }


    private String getID(){
        if (ID != null)
            return ID;
        SharedPreferences pref = MLApplication.ctxt.getSharedPreferences("MyPref", 0); // 0 - for private mode
        ID = pref.getString(ID_KEY,null);
        if(ID == null){
            ID = UUID.randomUUID().toString();
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(ID_KEY,ID);
            editor.commit();
        }
        return ID;
    }

    public void addScenarioData(int scenarioIdx,Object data){
        DatabaseReference mobileRoot = init();
        DatabaseReference scenarioRoot =  mobileRoot.child(String.valueOf(scenarioIdx));
        scenarioRoot.setValue(data);
    }
    public void getScenarioData(int scenarioIdx, ValueEventListener value  ){


        DatabaseReference mobileRoot = init();
        DatabaseReference scenarioRoot =  mobileRoot.child(String.valueOf(scenarioIdx));
        scenarioRoot.addListenerForSingleValueEvent(value);
    }
    private  DatabaseReference init(){
        // Write a message to the database
        if(database == null)
            database = FirebaseDatabase.getInstance();
        if(myRef == null)
            myRef= database.getReference();
        return myRef.child(getID());
    }
}
