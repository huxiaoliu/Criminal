package criminal.criminal.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import criminal.criminal.R;
import criminal.criminal.activity.CrimePagerActivity;
import criminal.criminal.adapter.CrimeListAdapter;
import criminal.criminal.model.Crime;
import criminal.criminal.util.CrimeLab;

/**
 * Created by asus on 2015/10/30.
 */
public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
        CrimeListAdapter adapter = new CrimeListAdapter(getActivity(), R.layout.list_item_crime, mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Crime c = ((CrimeListAdapter) getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(), CrimePagerActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeListAdapter)getListAdapter()).notifyDataSetChanged();
    }
}
