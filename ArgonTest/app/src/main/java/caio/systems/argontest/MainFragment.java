package caio.systems.argontest;


import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private Activity ativ;
    private BottomSheetBehavior mBottomSheetBehavior;
    private FragmentManager fm;
    private FragmentTransaction ft;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainFragment = inflater.inflate(R.layout.fragment_main, container, false);
        return mainFragment;
    }



}
