package caio.systems.argonlight;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FragmentUtil{
    public final static String TAG_NAME_FRAGMENT = "ACTIVITY_FRAGMENT";
    private FragmentTransaction ft;
    private FragmentManager fm;

    public void addFragment(int resource, Fragment fragment){


    }

    public void removeFragment(int resource, Fragment fragment){
        fm.beginTransaction().remove(null);
    }

    public void createFragList(FragmentManager fm){
        List<Fragment> fragList = fm.getFragments();

        if(fm != null)
        {
            int size = fm.getFragments().size();
            for(int i=0;i<size;i++)
            {
                Fragment fragment = fragList.get(i);

                if(fragment!=null) {
                    String fragmentTag = fragment.getTag();
                    Log.d(TAG_NAME_FRAGMENT, fragmentTag);
                }
            }

            Log.d(TAG_NAME_FRAGMENT, "***********************************");
        }


    }

}
