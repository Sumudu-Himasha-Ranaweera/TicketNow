package com.example.ticketnow.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ticketnow.QRcodeActivity;
import com.example.ticketnow.R;
import com.example.ticketnow.UserLogin.OTPActivity;
import com.example.ticketnow.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    Activity context;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }


    public void onStart() {
        super.onStart();
        TextView txt_QR = (TextView) context.findViewById(R.id.txtQrGenerate);
        txt_QR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(context, QRcodeActivity.class);
                startActivity(intent);
            }
        });
    }

}