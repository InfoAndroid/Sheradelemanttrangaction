package com.example.admin.sheradelemanttrangaction.simple_fragment_to_fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.sheradelemanttrangaction.R;

public class FragmentToFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);
        SimpleFragmentA simpleFragmentA = new SimpleFragmentA();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, simpleFragmentA)
                .commit();
    }
}
