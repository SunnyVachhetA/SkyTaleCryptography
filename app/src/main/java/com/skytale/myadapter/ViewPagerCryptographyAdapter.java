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

    public ViewPagerCryptographyAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        myFragList = new ArrayList<>(TAB_ITEMS_COUNT);
        myFragList.add("Encrypter");
        myFragList.add("Decrypter");
    }

    @Override
    public Fragment createFragment(int position) {
        Fragment currentFragment;
        System.out.println("InsideCreate");
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
        System.out.println("Current Fragment: " + currentFragment);
        return currentFragment;
    }

    @Override
    public int getItemCount() {
        return TAB_ITEMS_COUNT;
    }

    public String getFragmentTitle(int position){
        return myFragList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(myFragList.get(position));
    }
}
