package caio.systems.argontest;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnotherFragment extends Fragment {


    public AnotherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View anotherFragment = inflater.inflate(R.layout.fragment_another, container, false);
        // Inflate the layout for this fragment
        return anotherFragment;
    }

}
