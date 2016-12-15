package nyc.c4q.wesniemarcelin.nikoandroidclone;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by wesniemarcelin on 12/4/16.
 */

public class AccessCatsApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

}
