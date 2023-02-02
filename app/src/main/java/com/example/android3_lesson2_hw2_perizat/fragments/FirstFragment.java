package com.example.android3_lesson2_hw2_perizat.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android3_lesson2_hw2_perizat.R;

public class FirstFragment extends Fragment {
    AppCompatButton first_button;
    EditText first_edittext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        setOnClickListener();
    }

    private void findViews() {
        first_button=requireActivity().findViewById(R.id.button_first);
        first_edittext=requireActivity().findViewById(R.id.edit_text_first);
    }

    private void setOnClickListener() {
        first_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colorFromEditText=first_edittext.getText().toString();
                if(!colorFromEditText.isEmpty() && colorFromEditText.length()>=3){
                    navigateToSecondFragment(colorFromEditText);
                } else{
                    Toast.makeText(requireActivity(),"Write your favourite color!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void navigateToSecondFragment(String colorFromEditText) {
        Bundle bundle=new Bundle();
        bundle.putString("color",colorFromEditText);
        System.out.println(colorFromEditText);

        SecondFragment secondFragment=new SecondFragment();
        secondFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction().
                replace(R.id.fragment_container_view,secondFragment)
                .addToBackStack(null).commit();
    }
}