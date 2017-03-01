package com.example.admin.sheradelemanttrangaction.recycler_view;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.sheradelemanttrangaction.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by admin on 27-02-2017.
 */

public class AnimalGalleryAdapter extends RecyclerView.Adapter<AnimalGalleryAdapter.ImageViewHolder> {

    private final AnimalItemClickListener animalItemClickListener;
    private ArrayList<AnimalItem> animalItems;

    public AnimalGalleryAdapter(ArrayList<AnimalItem> animalItems, AnimalItemClickListener animalItemClickListener) {
        this.animalItems = animalItems;
        this.animalItemClickListener = animalItemClickListener;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal_square, parent, false));
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, final int position) {
        final AnimalItem animalItem = animalItems.get(position);
        Picasso.with(holder.itemView.getContext())
                .load(animalItem.imageUrl)
                .into(holder.animalImageView);

        final String transitionName = "animal_image_" + String.valueOf(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.animalImageView.setTransitionName(transitionName);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalItemClickListener.onAnimalItemClick(position, animalItem, holder.animalImageView, transitionName);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalItems.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView animalImageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            animalImageView = (ImageView) itemView.findViewById(R.id.item_animal_square_image);
        }
    }
}
