package caio.systems.argonlight;

import androidx.fragment.app.Fragment;

class FragmentSingleton extends Fragment {
    private static final FragmentSingleton ourInstance = new FragmentSingleton();

    static FragmentSingleton getInstance() {
        return ourInstance;
    }

    private FragmentSingleton() {
    }
}
