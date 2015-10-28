package criminal.criminal.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import criminal.criminal.R;
import criminal.criminal.fragment.CrimeFragment;


/**
 * Created by 磊 on 2015/10/27.
 */
public class CrimeActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null){
            fragment = new CrimeFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer,fragment)
                    .commit();
        }

    }
}
