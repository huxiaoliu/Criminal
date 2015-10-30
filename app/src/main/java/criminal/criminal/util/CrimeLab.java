package criminal.criminal.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

import criminal.criminal.model.Crime;

/**
 * Created by asus on 2015/10/30.
 * 一个暂时用来保存数据的单例类
 */
public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i =0; i<100;i++){
            Crime c = new Crime();
            c.setTitle("阿杂 : "+i);
            c.setSolved(i%2==0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime c:mCrimes){
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }


}
