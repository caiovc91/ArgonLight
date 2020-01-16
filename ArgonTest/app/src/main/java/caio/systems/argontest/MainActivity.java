package caio.systems.argontest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;


/*
 * Ver mais em:
 * NavHostFragment
 * https://developer.android.com/guide/navigation/navigation-getting-started
 * https://code.tutsplus.com/articles/how-to-use-bottom-sheets-with-the-design-support-library--cms-26031
 * https://medium.com/@droidbyme/android-bottom-sheet-7e9cfcec6427
 * https://medium.com/android-bits/android-bottom-sheet-30284293f066
 * https://www.androidhive.info/2017/12/android-working-with-bottom-sheet/
 *
 */

public class MainActivity extends AppCompatActivity {

    private Activity ativ;
    private BottomSheetBehavior mBottomSheetBehavior;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private NavHost navHost;
    private NavController navController;
    private Button button;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomsheet = findViewById(R.id.bottomSheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        mBottomSheetBehavior.setPeekHeight(40);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        setupNavHost();

        //if(savedInstanceState == null) {
            //fm.beginTransaction().replace(R.id.nav_host_fragment, new HomeMainSlider()).commit();
            //navController.getCurrentDestination();
            navController.navigate(R.id.homeMainSlider);
        //}




        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                if (i == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(30);
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }

    private void setupNavHost(){
        navController = Navigation.findNavController(findViewById(R.id.nav_host_fragment));
    }


    public void openFragment(View view) {
        //fm.beginTransaction().replace(R.id.mainFrame,new HomeFragment()).commit();
        //ft.addToBackStack("testfragment");
            //if (navController.getCurrentDestination().getId() == R.id.homeMainSlider) {
                navController.navigate(R.id.action_homeMainSlider_to_profileFragment);
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //}
    }

    public void openFragmentTwo(View view) {
        //fm.beginTransaction().replace(R.id.mainFrame,new EconomyFragment()).commit();
        //ft.addToBackStack("fragmenttwo");
       // if (navController.getCurrentDestination().getId() == R.id.mainFragment) {
//
        //}
    }

    public void openFragmentThree(View view) {
        //fm.beginTransaction().replace(R.id.mainFrame,new FragmentThree()).commit();
        //ft.addToBackStack("fragmentthree");
       // if (navController.getCurrentDestination().getId() == R.id.mainFragment) {
           // navController.navigate(R.id.action_mainFragment_to_fragmentThree);
       // }
    }

    public void openFragmentFour(View view) {
        //fm.beginTransaction().replace(R.id.mainFrame,new FragmentFour()).commit();
        //ft.addToBackStack("fragmentfour");
        //if (navController.getCurrentDestination().getId() == R.id.mainFragment) {
           // navController.navigate(R.id.action_mainFragment_to_fragmentFour);
        //}
    }
}
