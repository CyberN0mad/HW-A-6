package com.example.hw_a_6;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ChangeFragment extends Fragment {

    private Button btnFirst;
    private Button brnSecond;
    private TextView textView;
    private IFragments listener;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        listener = (IFragments) context;

    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChangeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change, container, false);
        btnFirst = view.findViewById(R.id.btnFirst);
        brnSecond = view.findViewById(R.id.btnSecond);
        textView = view.findViewById(R.id.txtViewFirstFragment);

        if (mParam1 != null) {
            textView.setText(mParam1);
        }

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* TextView textView = getActivity().findViewById(R.id.txtViewFirstFragment);
                textView.setText("Hello main activity");*/
                listener.onFirstFragment();
            }
        });

        brnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               listener.onSecondFragment();
            }
        });
        return view;
    }
/*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnFirst = view.findViewById(R.id.btnFirst);
        brnSecond = view.findViewById(R.id.btnSecond);
        textView = view.findViewById(R.id.txtViewFirstFragment);

        if (mParam1 != null) {
            textView.setText(mParam1);
        }

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = getActivity().findViewById(R.id.txtViewFirstFragment);
                textView.setText("Hello main activity");
                listener.onFirstFragment();
            }
        });

        brnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSendMessages(textView.getText().toString());
            }
        });*/
    }
