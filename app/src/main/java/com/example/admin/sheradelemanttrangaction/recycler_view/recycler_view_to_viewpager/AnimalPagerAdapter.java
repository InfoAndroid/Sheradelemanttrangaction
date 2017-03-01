package com.example.admin.sheradelemanttrangaction.recycler_view.recycler_view_to_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.sheradelemanttrangaction.recycler_view.AnimalItem;
import com.example.admin.sheradelemanttrangaction.recycler_view.recycler_view_to_fragment.AnimalDetailFragment;

import java.util.List;

public class AnimalPagerAdapter extends FragmentStatePagerAdapter {

    private List<AnimalItem> animalItems;

    AnimalPagerAdapter(FragmentManager fm, List<AnimalItem> animalItems) {
        super(fm);
        this.animalItems = animalItems;
    }

    @Override
    public Fragment getItem(int position) {
        AnimalItem animalItem = animalItems.get(position);
        return AnimalDetailFragment.newInstance(animalItem, "animal_image_" + position);
    }

    @Override
    public int getCount() {
        return animalItems.size();
    }

}