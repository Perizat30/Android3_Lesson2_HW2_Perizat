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

public class ThirdFragment extends Fragment {
    AppCompatButton third_button;
    EditText third_edittext;
    String filmFromSecondFragment;
    String colorFromFirstFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        setOnClickListener();
    }

    private void findViews() {
        third_button=requireActivity().findViewById(R.id.button_third);
        third_edittext=requireActivity().findViewById(R.id.edit_text_third);
    }

    private void getBundle() {
        if(getArguments()!=null){
            filmFromSecondFragment = getArguments().getString("film");
            colorFromFirstFragment= getArguments().getString("color");
        }
    }

    private void setOnClickListener() {
        third_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodFromEditText=third_edittext.getText().toString();
                if(!foodFromEditText.isEmpty() && foodFromEditText.length()>=3){
                    navigateToFourthFragment(foodFromEditText);
                } else{
                    Toast.makeText(requireActivity(),"Write your favourite food!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void navigateToFourthFragment(String foodFromEditText) {
        Bundle bundle=new Bundle();
        bundle.putString("food",foodFromEditText);
        bundle.putString("film",filmFromSecondFragment);
        bundle.putString("color",colorFromFirstFragment);
        System.out.println(foodFromEditText);

        FourthFragment fourthFragment=new FourthFragment();
        fourthFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction().
                replace(R.id.fragment_container_view,fourthFragment)
                .addToBackStack(null).commit();
    }

}