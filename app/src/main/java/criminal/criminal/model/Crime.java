package criminal.criminal.model;

import java.util.UUID;

/**
 * Created by 磊 on 2015/10/27.
 * Crime的model类
 */
public class Crime {

    private UUID mId;   //ID

    private String mTitle;  //标题

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
