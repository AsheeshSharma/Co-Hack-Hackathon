package animelabs.cohack;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

/**
 * Created by Asheesh on 10/25/2015.
 */
public class CallServer extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callserve);
        final ImageView fabIconNew = new ImageView(getApplicationContext());
        fabIconNew.setImageDrawable(getResources().getDrawable(R.drawable.vc));
        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIconNew)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        SubActionButton moneybox=makeSAB(R.drawable.cv,getApplicationContext(),rLSubBuilder);
        SubActionButton profile=makeSAB(R.drawable.zx,getApplicationContext(),rLSubBuilder);
        SubActionButton settings=makeSAB(R.drawable.bv, getApplicationContext(), rLSubBuilder);

        moneybox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNotification(getBaseContext(),R.drawable.hh,"Download and Yoga Now");
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Find Your Fit");

                startActivity(Intent.createChooser(shareIntent, "Share using"));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CallServer.this, "Future Implementation", Toast.LENGTH_SHORT).show();
            }
        });
        // Build the menu with default options: light theme, 90 degrees, 72dp radius.
        // Set 4 default SubActionButtons
        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(moneybox)
                .addSubActionView(profile)
                .addSubActionView(settings)
                .setRadius(200)
                .attachTo(rightLowerButton)
                .build();

        // Listen menu open and close events to animate the button content view
        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                fabIconNew.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 180);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees counter-clockwise
                fabIconNew.setRotation(180);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }
        });
    }
    private SubActionButton makeSAB (int resId, Context c, SubActionButton.Builder sBuilder) {
        ImageView icon = new ImageView(c);
        icon.setImageResource(resId);
        icon.setPadding(10,10,10,10);
        int mySubActionButtonSize = getResources().getDimensionPixelSize(R.dimen.my_sub_action_button_size);
        int mySubActionButtonContentMargin = getResources().getDimensionPixelSize(R.dimen.my_sub_action_button_content_margin);
        FrameLayout.LayoutParams newContentParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        newContentParams.setMargins(mySubActionButtonContentMargin,
                mySubActionButtonContentMargin,
                mySubActionButtonContentMargin,
                mySubActionButtonContentMargin);
        sBuilder.setLayoutParams(newContentParams);
        FrameLayout.LayoutParams newParams = new FrameLayout.LayoutParams(mySubActionButtonSize, mySubActionButtonSize);
        sBuilder.setLayoutParams(newParams);
        return sBuilder.setContentView(icon).build();
    }
    public static void generateNotification(Context context, int icon, String message) {
        // Show the notification
        Intent notificationIntent;
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification(icon, message, when);
        String title = context.getString(R.string.app_name);

            notificationIntent = new Intent(context,YogaCustom.class);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent intent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
            notification.setLatestEventInfo(context, title, message, intent);
            notification.vibrate = new long[] { 500, 500 };
            notification.sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            notification.flags =
                    Notification.FLAG_AUTO_CANCEL |
                            Notification.FLAG_SHOW_LIGHTS;

            notificationManager.notify(0, notification);

        // set intent so it does not start a new activity

    }
}
