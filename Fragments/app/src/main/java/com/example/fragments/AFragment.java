package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AFragment extends Fragment {
    private static final String Arg1 = "argument1";
    private static final String Arg2 = "argument2";

    public AFragment() {
        // Required empty public constructor
    }
    public static AFragment getInstance(String value1,int value2){

        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Arg1,value1);
        bundle.putInt(Arg2,value2);
        aFragment.setArguments(bundle);

        return aFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        view.findViewById(R.id.txtFrag);
        if (getArguments()!=null){
            String name = getArguments().getString("Arg1");
            int Roll = getArguments().getInt("Arg2");
            Log.d("Value From Act","Name is : "+name+" , Roll is : "+Roll);
        }
        //Your Set Of Instruction

        return view;
    }
}