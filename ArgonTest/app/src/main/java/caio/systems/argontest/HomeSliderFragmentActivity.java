package caio.systems.argontest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import static androidx.navigation.Navigation.findNavController;

public class HomeSliderFragmentActivity extends FragmentActivity {

        private ViewPager mPager;
        private HomeMainSlider.InternalPagerAdapter internalAdapter;
        private NavController navController;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_home_main_slider);

            mPager = findViewById(R.id.pager);
            internalAdapter = new HomeMainSlider.InternalPagerAdapter(getSupportFragmentManager());
            mPager.setAdapter(internalAdapter);

            navController = findNavController(findViewById(R.id.nav_host_fragment));
        }


        @Override
        public void onBackPressed() {
            if (mPager.getCurrentItem() == 0) {
                super.onBackPressed();
                navController.navigate(R.id.homeMainSlider);

            } else {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        }

}
