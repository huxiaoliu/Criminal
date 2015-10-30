package criminal.criminal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import criminal.criminal.R;
import criminal.criminal.model.Crime;

/**
 * Created by asus on 2015/10/30.
 */
public class CrimeListAdapter extends ArrayAdapter<Crime> {

    private int resourceId;


    public CrimeListAdapter(Context context, int resource, ArrayList<Crime> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Crime mCrime = getItem(position);
        View mView;
        ViewHolder mViewHolder;
        if (convertView == null) {
            mView = LayoutInflater.from(getContext()).inflate(resourceId, null);
            mViewHolder = new ViewHolder();
            mViewHolder.solvedCheckBox = (CheckBox) mView.findViewById(R.id.crime_list_item_solvedCheckBox);
            mViewHolder.dateTextView = (TextView) mView.findViewById(R.id.crime_list_item_dateTextView);
            mViewHolder.titleTextView = (TextView) mView.findViewById(R.id.crime_list_item_titleTextView);
            mView.setTag(mViewHolder);
        } else {
            mView = convertView;
            mViewHolder = (ViewHolder) mView.getTag();
        }

        mViewHolder.solvedCheckBox.setChecked(mCrime.isSolved());
        mViewHolder.titleTextView.setText(mCrime.getTitle());
        mViewHolder.dateTextView.setText(mCrime.getDate().toString());

        return mView;
    }

    class ViewHolder {
        CheckBox solvedCheckBox;
        TextView titleTextView;
        TextView dateTextView;
    }
}
