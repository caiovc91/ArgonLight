package caio.systems.argonlight;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DashboardUnit extends Fragment {

    private FragmentUtil fragUtil = new FragmentUtil();
    final FragmentManager fragmentManager = getFragmentManager();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_unit, container, false);
    }

}
