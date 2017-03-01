package com.example.admin.sheradelemanttrangaction.recycler_view;

import android.widget.ImageView;

/**
 * Created by admin on 27-02-2017.
 */
public interface AnimalItemClickListener {
    void onAnimalItemClick(int pos, AnimalItem animalItem, ImageView shareImageView, String transitionName);
}
