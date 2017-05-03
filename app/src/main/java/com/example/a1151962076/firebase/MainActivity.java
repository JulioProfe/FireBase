package com.example.a1151962076.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{
        FirebaseDatabase database;
        DatabaseReference myReference;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myReference = database.getReference("message");
        //myReference.setValue("Hola FireBase");
    final TextView texto = (TextView) findViewById(R.id.mensaje);


        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String txt = dataSnapshot.getValue().toString();
                texto.setText(txt);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
