package nyc.c4q.wesniemarcelin.nikoandroidclone.NotificationStuff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.wesniemarcelin.nikoandroidclone.R;

public class ServiceLauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        launchTestService();
    }
    public void launchTestService() {
        Intent i = new Intent(this, CreatureNotificationService.class);
        startService(i);
    }
}
