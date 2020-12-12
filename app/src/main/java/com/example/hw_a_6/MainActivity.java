package com.example.hw_a_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IFragments {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private Button buttonSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, ButtonFragment.newInstance("", ""));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFirstFragment() {
        transaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        transaction.hide(fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void onSecondFragment() {
        transaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        transaction.show(fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }

    @Override
    public void onSendMessages(String text) {
        transaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        ((TextView) fragment.getView().findViewById(R.id.txtSecond)).setText(text);
        transaction.show(fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}