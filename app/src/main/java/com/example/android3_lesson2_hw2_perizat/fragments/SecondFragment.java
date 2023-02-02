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
import android.widget.TextView;
import android.widget.Toast;

import com.example.android3_lesson2_hw2_perizat.R;


public class SecondFragment extends Fragment {
    TextView second_textView;
    AppCompatButton second_button;
    EditText second_edittext;
    String colorFromFirstFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        setOnClick();
    }

    private void findViews() {
        second_button=requireActivity().findViewById(R.id.button_second);
        second_textView=requireActivity().findViewById(R.id.text_view_second);
        second_edittext=requireActivity().findViewById((R.id.edit_text_second));
    }

    private void getBundle() {
        if(getArguments()!=null){
            colorFromFirstFragment=getArguments().getString("color");
        }
    }

    private void setOnClick() {
        second_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String filmFromEditText= second_edittext.getText().toString();
                if(!filmFromEditText.isEmpty() && filmFromEditText.length()>=3){
                    navigateToThirdFragment(filmFromEditText);
                } else{
                    Toast.makeText(requireActivity(),"Write your favourite film!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void navigateToThirdFragment(String filmFromEditText) {
        Bundle bundle=new Bundle();
        bundle.putString("film",filmFromEditText);
        bundle.putString("color",colorFromFirstFragment);
        System.out.println(filmFromEditText);

        ThirdFragment thirdFragment=new ThirdFragment();
        thirdFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction().
                replace(R.id.fragment_container_view,thirdFragment)
                .addToBackStack(null).commit();
    }

}