package com.skytale.tabfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.skytale.R;
public class DecrypterFragment extends Fragment {

    public DecrypterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("DecryptFragmentStarted");
        return inflater.inflate(R.layout.fragment_decrypter, container, false);
    }
}