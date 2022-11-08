package com.example.ticketnow.Navbar;


import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ticketnow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class ViewProfileActivity extends AppCompatActivity {

    ImageView close;

    private String profilePassedID;

    //Firebase Connection
    FirebaseAuth auth;
    //realtime Database Connection
    FirebaseDatabase database; //rootNode
    //realtime database reference
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        //firebase connection
        auth = FirebaseAuth.getInstance();
        //realtime Database Connection
        database = FirebaseDatabase.getInstance();


        close = (ImageView) findViewById(R.id.btn_close);

        profilePassedID = getIntent().getStringExtra("userID");

        TextView NIC = (TextView) findViewById(R.id.TxtID);
        NIC.setText(String.format(
                "%s", profilePassedID
        ));

        reference = database.getReference("User Profile");
        Query checkUser = reference.orderByChild("userID").equalTo(profilePassedID);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String userNameFromDB = snapshot.child(profilePassedID).child("userName").getValue(String.class);
                    String userEmailFromDB = snapshot.child(profilePassedID).child("userEmail").getValue(String.class);
                    String userNumberFromDB = snapshot.child(profilePassedID).child("userNumber").getValue(String.class);
                    String userAddressFromDB = snapshot.child(profilePassedID).child("userAddress").getValue(String.class);

                    TextView Name = (TextView) findViewById(R.id.TxtName);
                    Name.setText(String.format(
                            "%s", userNameFromDB
                    ));

                    TextView Email = (TextView) findViewById(R.id.TxtEmail);
                    Email.setText(String.format(
                            "%s", userEmailFromDB
                    ));

                    TextView Phone = (TextView) findViewById(R.id.TxtPhone);
                    Phone.setText(String.format(
                            "%s", userNumberFromDB
                    ));

                    TextView Address = (TextView) findViewById(R.id.TxtAddress);
                    Address.setText(String.format(
                            "%s", userAddressFromDB
                    ));
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

//        ------------------------------------------------------------------------------------
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.7), (int) (height*.5));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
    }
}