package com.example.admin.sheradelemanttrangaction.recycler_view.recycler_view_to_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.admin.sheradelemanttrangaction.R;
import com.example.admin.sheradelemanttrangaction.recycler_view.AnimalGalleryAdapter;
import com.example.admin.sheradelemanttrangaction.recycler_view.AnimalItem;
import com.example.admin.sheradelemanttrangaction.recycler_view.AnimalItemClickListener;
import com.example.admin.sheradelemanttrangaction.recycler_view.Utils;

public class RecyclerViewActivity extends AppCompatActivity implements AnimalItemClickListener {

    public static final String EXTRA_ANIMAL_ITEM = "animal_image_url";
    public static final String EXTRA_ANIMAL_IMAGE_TRANSITION_NAME = "animal_image_transition_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        AnimalGalleryAdapter animalGalleryAdapter = new AnimalGalleryAdapter(Utils.generateAnimalItems(this), this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(animalGalleryAdapter);
    }

    @Override
    public void onAnimalItemClick(int pos, AnimalItem animalItem, ImageView shareImageView, String transitionName) {
        Intent intent = new Intent(this, AnimalDetailActivity.class);
        intent.putExtra(EXTRA_ANIMAL_ITEM, animalItem);
        intent.putExtra(EXTRA_ANIMAL_IMAGE_TRANSITION_NAME, transitionName);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                shareImageView,
                transitionName);

        startActivity(intent, options.toBundle());
    }

}