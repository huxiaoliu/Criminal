package criminal.criminal.activity;



import android.support.v4.app.Fragment;

import criminal.criminal.fragment.CrimeListFragment;

/**
 * Created by asus on 2015/10/30.
 *
 */
public class CrimeListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();

    }
}
