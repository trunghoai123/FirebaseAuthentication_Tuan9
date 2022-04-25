package com.example.firebasecustomeruser_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnLogOut;
    FirebaseAuth mAuth;
    TextView txtDisplayEmail;
    TextView txtDisplayPhone;
    TextView txtDisplayRole;
    TextView txtDisplayName;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogOut = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        txtDisplayEmail = findViewById(R.id.txtDisplayEmail);
        txtDisplayName = findViewById(R.id.txtDisplayName);
        txtDisplayPhone = findViewById(R.id.txtDisplayPhone);
        txtDisplayRole = findViewById(R.id.txtDisplayRole);
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();

                // Name, email address, and profile photo Url
//                String name = profile.getDisplayName();
//                profile.
                String email = profile.getEmail();
                txtDisplayEmail.setText(email);

//                String name = profile.getDisplayName();
//                txtDisplayEmail.setText(email);


//                String name = profile.getDisplayName();
//                Uri photoUrl = profile.getPhotoUrl();




                final DatabaseReference ref1 = database.getReference("Users").
                        child(FirebaseAuth.getInstance().getCurrentUser().getUid());

//                txtDisplayName.setText(ref1.child("name"));
//                ref1.child("name").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        String name = dataSnapshot.getValue().toString();
//                        txtDisplayName.setText("Name: " + name);
//                        Toast.makeText(MainActivity.this, "handle dataChange", Toast.LENGTH_SHORT).show();
//                    }
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
            }
        }

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}