package com.example.android3_lesson2_hw2_perizat.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android3_lesson2_hw2_perizat.R;
public class FourthFragment extends Fragment {
    TextView textView;
    String foodFromThirdFragment;
    String colorFromFirstFragment;
    String filmFromSecondFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        setTextViewText();
    }

    private void findViews() {
        textView = requireView().findViewById(R.id.text_view_fourth);
    }

    private void getBundle() {
        foodFromThirdFragment=getArguments().getString("food");
        colorFromFirstFragment=getArguments().getString("color");
        filmFromSecondFragment=getArguments().getString("film");

    }

    @SuppressLint("SetTextI18n")
    private void setTextViewText() {
        textView.setText(colorFromFirstFragment+"  "+filmFromSecondFragment+"   " +foodFromThirdFragment);
    }
}