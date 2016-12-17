package nyc.c4q.wesniemarcelin.nikoandroidclone.RenameMe;

import android.content.Context;

/**
 * Created by shawnspeaks on 12/15/16.
 */

public class ApplicationContextProvider extends AccessCatsApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
