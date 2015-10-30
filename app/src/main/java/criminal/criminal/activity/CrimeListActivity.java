package criminal.criminal.activity;

import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;

import criminal.criminal.fragment.CrimeListFragment;
import criminal.criminal.model.Crime;

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
