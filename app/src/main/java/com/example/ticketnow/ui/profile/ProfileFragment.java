package com.example.ticketnow.ui.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ticketnow.Navbar.ProfileActivity;
import com.example.ticketnow.R;

public class ProfileFragment extends Fragment {

    Activity context;
    Button profile;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        context = getActivity();
        View root = inflater.inflate(R.layout.fragment_profile, container,false);

        profile = root.findViewById(R.id.profile_button);



//        name = root.findViewById(R.id.EditTxtName);
//        email = root.findViewById(R.id.EditTxtEmail);
//        Nic = root.findViewById(R.id.EditTxtID);
//        PhoneNo = root.findViewById(R.id.EditTxtNumber);
//        Address = root.findViewById(R.id.EditTxtAddress);
//
//        Bundle bundle = getArguments();
//
//        email.setText(bundle.getString("email"));
//        Nic.setText(bundle.getString("userID"));
//        PhoneNo.setText(bundle.getString("number"));

        return root;

    }
    public void onStart() {
        super.onStart();

        profile = (Button) context.findViewById(R.id.profile_button);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(context, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

}