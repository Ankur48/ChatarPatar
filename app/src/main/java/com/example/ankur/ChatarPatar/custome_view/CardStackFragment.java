package com.example.ankur.ChatarPatar.custome_view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ankur.ChatarPatar.R;

/**
 * Created by ankur on 03-04-2017.
 */

@SuppressLint("ValidFragment")
public class CardStackFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card, null);
    }
}
