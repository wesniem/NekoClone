package nyc.c4q.wesniemarcelin.nikoandroidclone;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by wesniemarcelin on 12/4/16.
 */
//The WakefulBroadcastReceiver ensures that the device does not go back to sleep during the startup of the service
public class BootBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent = new Intent(context,CreatureNotificationService.class);
        startWakefulService(context,startServiceIntent);
    }
}
