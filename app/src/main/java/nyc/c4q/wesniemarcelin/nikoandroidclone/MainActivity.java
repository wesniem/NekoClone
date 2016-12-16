package nyc.c4q.wesniemarcelin.nikoandroidclone;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.wesniemarcelin.nikoandroidclone.RecyclerviewStuff.CatAdapter;
import nyc.c4q.wesniemarcelin.nikoandroidclone.model.Cat;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private CatAdapter adapter;
    private SQLiteDatabase sqLiteDatabase;
    private String TAG = "DEBUGGER TOOL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        showSimpleNotification();
        showPendingIntentNotification();
        scheduleAlarm();
    }

    @Override
    protected void onStart() {
        super.onStart();

        sqLiteDatabase = CatDatabaseHelper.getInstance(this)
                                          .getWritableDatabase();

        adapter = new CatAdapter(getCatsInCollection());
        rv = (RecyclerView) findViewById(R.id.recyclerView_id);
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        rv.setAdapter(adapter);


    }


    private List<Cat> getCatsInCollection() {
        List<Cat> catList = new ArrayList<>();

        try{
            QueryResultIterable<Cat> iterableQueryList = cupboard()
                                                        .withDatabase(sqLiteDatabase)
                                                        .query(Cat.class).query();
            for(Cat cat : iterableQueryList){
                catList.add(cat);
            }
            iterableQueryList.close();
        }catch (Exception e){
            Log.e(TAG, "getCatsInCollection: ", e);
        }
        return catList;
    }


    public void showSimpleNotification() {
        int NOTIFICATION_ID = 555;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon_)
                .setContentTitle("New Cat Alert!")
                .setContentText("Click to add new cat to database");

// Get the notification manager system service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Setting a notification ID allows you to update the notification later on.
        notificationManager.notify(NOTIFICATION_ID, builder.build());

        vibratePhone();
        catSound();
    }
    public void showPendingIntentNotification() {
        int NOTIFICATION_ID = 555;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon_)
                .setContentTitle("New Cat Alert!")
                .setContentText("Click to add new cat to database");

// Get the notification manager system service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Setting a notification ID allows you to update the notification later on.
        notificationManager.notify(NOTIFICATION_ID, builder.build());

        vibratePhone();
        catSound();
    }
    // ... call launchTestService() in the Activity onCreate()



    private void vibratePhone() {
        //Ensures that phone also vibrates with notification
        Vibrator v = (Vibrator) this.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);
    }

    private void catSound() {
        MediaPlayer catSound = MediaPlayer.create(getApplicationContext(), R.raw.cat_meow);
        catSound.start();
    }

    // Setup a recurring alarm every half hour
    public void scheduleAlarm() {

        // Construct an intent that will execute the AlarmReceiver
        Intent intent = new Intent(getApplicationContext(), CreatureAlarmReceiver.class);

        // Create a PendingIntent to be triggered when the alarm goes off
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, CreatureAlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        long firstMillis = System.currentTimeMillis(); // alarm is set right away

        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, (60000), pendingIntent);
    }

}
