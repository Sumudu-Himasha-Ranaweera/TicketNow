package com.example.ticketnow.Navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ticketnow.QRcodeActivity;
import com.example.ticketnow.R;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    TextView QRgenerate;

    private String userInputID, userInputEmail, userInputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userInputID = getIntent().getStringExtra("userID");
        userInputEmail = getIntent().getStringExtra("email");
        userInputNumber = getIntent().getStringExtra("number");

//        TextView textNIC = findViewById(R.id.textNIC);
//        textNIC.setText(String.format(
//                "+94-%s", userInputID
//        ));

        //Generate QR code
        QRgenerate = (TextView) findViewById(R.id.txtQrGenerate);
        QRgenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intend = new Intent(HomeActivity.this,QRcodeActivity.class);
                intend.putExtra("userID", userInputID);
                intend.putExtra("email", userInputEmail);
                intend.putExtra("number", userInputNumber);
                startActivity(intend);
            }
        });
        //End Code

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbarMenu);

        //Tool Bar
        setSupportActionBar(toolbar);

        //Navigation Drawer Menu

//           /* Hide or show items */
//        Menu menu = navigationView.getMenu();
//        menu.findItem(R.id.navbar_Logout).setVisible(false);
//        menu.findItem(R.id.navbar_Logout).setVisible(false);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.navbar_home);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.navbar_home:
                break;
            case R.id.navbar_profile:
                Intent intendProf = new Intent(HomeActivity.this,ProfileActivity.class);
                    intendProf.putExtra("userID", userInputID);
                    intendProf.putExtra("email", userInputEmail);
                    intendProf.putExtra("number", userInputNumber);
                startActivity(intendProf);
                break;
            case R.id.navbar_wallet:
                Intent intendWall = new Intent(HomeActivity.this,WalletActivity.class);
                startActivity(intendWall);
                break;
            case R.id.navbar_Timetable:
                Intent intendTime = new Intent(HomeActivity.this,TimeTableActivity.class);
                startActivity(intendTime);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}