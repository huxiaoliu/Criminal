package criminal.criminal.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 磊 on 2015/10/27.
 * Crime的model类
 */
public class Crime {

    private UUID mId;   //ID

    private String mTitle;  //标题

    private Date mDate; //时间

    private boolean mSolved;    //状态

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
