package com.example.admin.sheradelemanttrangaction.simple_activity_to_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.sheradelemanttrangaction.R;

public class SimpleActivityA extends AppCompatActivity {
    private Button simple_activity_a_btn;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simple_activity_a_btn = (Button) findViewById(R.id.simple_activity_a_btn);
        imageView = (ImageView) findViewById(R.id.simple_activity_a_imageView);
        simple_activity_a_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleActivityA.this, SimpleActivityB.class);
                ActivityOptionsCompat option = ActivityOptionsCompat.makeSceneTransitionAnimation(SimpleActivityA.this, imageView, "simple_activity_transition");
                startActivity(intent, option.toBundle());
            }
        });
    }
  /*  @Override
    protected void onResume() {
        super.onResume();
        if (ApplicationLifecycleHandler.isInBackground){
            Toast.makeText(getApplicationContext(),"Application In Background",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Application In Forground",Toast.LENGTH_SHORT).show();
        }
    }*/
}
