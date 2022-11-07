package com.example.ticketnow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ticketnow.Navbar.HomeActivity;
import com.example.ticketnow.ui.home.HomeFragment;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRcodeActivity extends AppCompatActivity {

    //attribute for remove bottom status bar
    private View decorView;

    ImageView btnBack;
    Button generate;
//    EditText userIDNum;
    ImageView QR_Output;

    private String LoginSentID, LoginSentEmail, LoginSentPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        btnBack = (ImageView) findViewById(R.id.back);
//        userIDNum = (EditText) findViewById(R.id.EditTxtID);
        QR_Output = (ImageView) findViewById(R.id.QR_output);
        generate = (Button) findViewById(R.id.btnGenerate);

        LoginSentID = getIntent().getStringExtra("userID");
        LoginSentEmail = getIntent().getStringExtra("email");
        LoginSentPhone = getIntent().getStringExtra("number");

        TextView textViewNIC = findViewById(R.id.textNIC);
        textViewNIC.setText(String.format(
                "%s", LoginSentID
        ));

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get Input values from edit text
//                String UserInputID = userIDNum.getText().toString().trim();
                //Initialize multi Format
                MultiFormatWriter writer = new MultiFormatWriter();

                try {
                    //Initialize bit Matrix
                    BitMatrix matrix = writer.encode(LoginSentID, BarcodeFormat.QR_CODE, 300,320);
                    //Initialize Barcode encoder
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    //Initialize bitmap
                    Bitmap bitmap = encoder.createBitmap(matrix);
                    //Set bitmap on the image view
                    QR_Output.setImageBitmap(bitmap);
                    //Initialize input manager
                    InputMethodManager manager = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE
                    );
                    //Hide soft keyboard
//                    manager.hideSoftInputFromWindow(LoginSentID.getApplicationWindowToken(), 0);

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intend = new Intent(QRcodeActivity.this, HomeActivity.class);
                intend.putExtra("userID", LoginSentID);
                intend.putExtra("email", LoginSentEmail);
                intend.putExtra("number", LoginSentPhone);
                startActivity(intend);

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