package com.skytale.myadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.skytale.tabfragments.DecrypterFragment;
import com.skytale.tabfragments.EncrypterFragment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerCryptographyAdapter extends FragmentPagerAdapter
{
    private static final int TAB_COUNT = 2;
    private static String[] tabLabel = {"Encrypter", "Decrypter"};
    public ViewPagerCryptographyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment;
        switch (position)
        {
            case 1:
                selectedFragment = new DecrypterFragment();
                break;
            case 0:
            default:
                selectedFragment = new EncrypterFragment();
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabLabel[position];
    }
}
