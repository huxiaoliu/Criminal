package criminal.criminal.util;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

import criminal.criminal.model.Crime;

/**
 * Created by asus on 2015/10/30.
 * 一个暂时用来保存数据的单例类
 */
public class CrimeLab {

    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crimes.json";

    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;
    private CriminialJSONSerializer mSerializer;


    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mSerializer = new CriminialJSONSerializer(mAppContext,FILENAME);
        try {
            mCrimes = mSerializer.loadCrimes();
        }catch (Exception e){
            mCrimes = new ArrayList<Crime>();
            Log.d(TAG,"Error loading crimes: ",e);
        }
    }

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public boolean saveCrimes() {
        try {
            mSerializer.saveCrimes(mCrimes);
            Log.d(TAG, "保存成功");
            return true;
        } catch (Exception e) {
            Log.d(TAG, "保存失败");
            return false;
        }
    }

}
