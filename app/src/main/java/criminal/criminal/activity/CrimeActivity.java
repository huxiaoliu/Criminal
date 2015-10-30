package criminal.criminal.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import criminal.criminal.R;
import criminal.criminal.fragment.CrimeFragment;


/**
 * Created by 磊 on 2015/10/27.
 */
public class CrimeActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
