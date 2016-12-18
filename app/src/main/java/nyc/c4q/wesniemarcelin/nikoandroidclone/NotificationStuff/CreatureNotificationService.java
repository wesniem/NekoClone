package nyc.c4q.wesniemarcelin.nikoandroidclone.NotificationStuff;

import android.accessibilityservice.AccessibilityService;
import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;
import java.util.Random;

import nyc.c4q.wesniemarcelin.nikoandroidclone.CatDatabaseHelper;
import nyc.c4q.wesniemarcelin.nikoandroidclone.R;
import nyc.c4q.wesniemarcelin.nikoandroidclone.model.Cat;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by wesniemarcelin on 12/4/16.
 */

public class CreatureNotificationService extends IntentService {
    //Names the working thread, important only for debugging
    private static final String SERVICE_NAME = "notification-service";
    private SQLiteDatabase db;
    private AccessibilityService context;


    public CreatureNotificationService() {
        super(SERVICE_NAME);
    }

    //Must create default constructor
    public CreatureNotificationService(String name) {
        super(SERVICE_NAME);
    }

    @Override
    // if you override onCreate(), make sure to call super().
    // If a Context object is needed, call getApplicationContext() here.
    public void onCreate() {
        super.onCreate();
        // get an instance of the DatabaseHelper
        CatDatabaseHelper dbHelper = CatDatabaseHelper.getInstance(this);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    // This describes what will happen when service is triggered, i.e. show a notification
    protected void onHandleIntent(Intent intent) {
//        int NOTIFICATION_ID = 555;
        Random random = new Random();

        String s = String.valueOf(random.nextInt(400) + 101);
        String tempCatString = "https://placekitten.com/g/" +  s + "/" + s;

        Cat newCat = new Cat("Cat " + (random.nextInt(8) + 1), Calendar.getInstance().getTimeInMillis(), tempCatString);

        int NOTIFICATION_ID = 555;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon_)
                .setContentTitle("New Cat Alert!")
                .setContentText("Click to add new cat to database");

// Get the notification manager system service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Setting a notification ID allows you to update the notification later on.
        notificationManager.notify(NOTIFICATION_ID, builder.build());

//        vibratePhone();
//     catSound();
//        //Adds cat to the database
        addCat(newCat);
        // ---OR-----
//        addCat(new Cat());

    }

    private void addCat(Cat cat) {
        cupboard().withDatabase(db).put(cat);
    }

    private void vibratePhone() {
        //Ensures that phone also vibrates with notification
        Vibrator v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);
    }

    private void catSound() {
        MediaPlayer catSound = MediaPlayer.create(getApplicationContext(), R.raw.cat_meow);
        catSound.start();
    }


}
