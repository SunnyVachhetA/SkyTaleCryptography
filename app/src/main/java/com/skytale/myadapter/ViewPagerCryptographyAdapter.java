package com.skytale.myadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.skytale.tabfragments.DecrypterFragment;
import com.skytale.tabfragments.EncrypterFragment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerCryptographyAdapter extends FragmentStateAdapter
{
    private static final int TAB_ITEMS_COUNT = 2;
    private static List<String> myFragList;

    public ViewPagerCryptographyAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        myFragList = new ArrayList<>();
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        Fragment currentFragment;
        switch (position)
        {
            case 1:
                currentFragment = new EncrypterFragment();
                break;
            case 2:
                currentFragment = new DecrypterFragment();
                break;
            default:
                currentFragment = null;
        }
        return currentFragment;
    }

    @Override
    public int getItemCount() {
        return TAB_ITEMS_COUNT;
    }

    public void addFragmentInList(String fragmentName){
        myFragList.add(fragmentName);
    }

    public String getFragmentTitle(int position){
        return myFragList.get(position);
    }
}
