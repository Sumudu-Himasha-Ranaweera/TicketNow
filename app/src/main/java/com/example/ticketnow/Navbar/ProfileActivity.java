package com.example.ticketnow.Navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticketnow.QRcodeActivity;
import com.example.ticketnow.R;
import com.example.ticketnow.UserLogin.RegisterActivity;
import com.example.ticketnow.models.ProfileModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    //attribute for remove bottom status bar
    private View decorView;

    ImageView btnBack;
    EditText Name, Address;
    Button Update;
    ImageButton view;

    private String homePassedID, homePassedEmail, homePassedPhone;

    //Firebase Connection
    FirebaseAuth auth;
    //realtime Database Connection
    FirebaseDatabase database; //rootNode
    //realtime database reference
    DatabaseReference reference;

    //progress bar
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        homePassedID = getIntent().getStringExtra("userID");
        homePassedEmail = getIntent().getStringExtra("email");
        homePassedPhone = getIntent().getStringExtra("number");

        TextView NIC = (TextView) findViewById(R.id.TxtID);
        NIC.setText(String.format(
                "%s", homePassedID
        ));

        TextView Email = findViewById(R.id.TxtEmail);
        Email.setText(String.format(
                "%s", homePassedEmail
        ));

        TextView Number = findViewById(R.id.TxtPhone);
        Number.setText(String.format(
                "+94-%s", homePassedPhone
        ));

        //firebase connection
        auth = FirebaseAuth.getInstance();


        //progress bar
//        progressBar = (ProgressBar) findViewById(R.id.progressbar);
//        progressBar.setVisibility(View.GONE);

        Name = (EditText) findViewById(R.id.EditTxtName);
        Address = (EditText) findViewById(R.id.EditTxtAddress);

        btnBack = (ImageView) findViewById(R.id.back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intend = new Intent(ProfileActivity.this, HomeActivity.class);
                    intend.putExtra("userID", homePassedID);
                    intend.putExtra("email", homePassedEmail);
                    intend.putExtra("number", homePassedPhone);
                startActivity(intend);

            }
        });

        Update = (Button) findViewById(R.id.update_button);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //realtime Database Connection
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("User Profile");

                //get all values
                String userName = Name.getText().toString().trim();
                String userAddress = Address.getText().toString().trim();

                boolean check = validateInfo(userName,userAddress);

                if (check == true)
                {
                    ProfileModel profileModel = new ProfileModel(userName, homePassedEmail, homePassedID, homePassedPhone, userAddress);

                    reference.child(homePassedID).setValue(profileModel);
                    Toast.makeText(ProfileActivity.this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ProfileActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        view = (ImageButton) findViewById(R.id.btn_view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent popWindow = new Intent(ProfileActivity.this,ViewProfileActivity.class);
                startActivity(popWindow);
            }
        });

        //Remove bottom status bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });

    }

    private boolean validateInfo(String userName, String userAddress) {

        if (userName.length() == 0)
        {
            Name.requestFocus();
            Name.setError("Name is Required");
            return false;
        }
        else if (userAddress.length() == 0)
        {
            Address.requestFocus();
            Address.setError("Address is Required");
            return false;
        }
        else
        {
            return true;
        }

    }

    //remove bottom status bar
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
        {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
}