package com.example.admin.sheradelemanttrangaction.simple_fragment_to_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.sheradelemanttrangaction.R;


public class SimpleFragmentA extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ImageView imageView = (ImageView) view.findViewById(R.id.fragment_a_imageView);
        Button button = (Button) view.findViewById(R.id.fragment_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleFragmentB simpleFragmentB = new SimpleFragmentB();
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView, getString(R.string.simple_fragment_transition))
                        .addToBackStack("simpleFragmentB")
                        .replace(R.id.content, simpleFragmentB)
                        .commit();
            }
        });
    }
}
