package animelabs.cohack;

/**
 * Created by Asheesh on 10/24/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import io.saeid.fabloading.LoadingView;

/**
 * Created by Asheesh on 10/17/2015.
 */
public class Splash extends Activity {
    private LoadingView mLoadingView;
    private LoadingView mLoadViewLong;
    private LoadingView mLoadViewNoRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        mLoadingView = (LoadingView) findViewById(R.id.loading_view_repeat);
        boolean isLollipop = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
        int marvel_1 = isLollipop ? R.drawable.one : R.drawable.one;
        int marvel_2 = isLollipop ? R.drawable.two : R.drawable.two;
        int marvel_3 = isLollipop ? R.drawable.three : R.drawable.three;
        int marvel_4 = isLollipop ? R.drawable.four : R.drawable.four;
        int marvel_5 = isLollipop ? R.drawable.five : R.drawable.five;
        int marvel_6 = isLollipop ? R.drawable.six : R.drawable.six;
        int marvel_7 = isLollipop ? R.drawable.seven : R.drawable.seven;
        int marvel_8 = isLollipop ? R.drawable.aeit : R.drawable.aeit;
        mLoadingView.addAnimation(Color.parseColor("#eeff30"), marvel_1,
                LoadingView.FROM_LEFT);
        mLoadingView.addAnimation(Color.parseColor("#2F5DA9"), marvel_2,
                LoadingView.FROM_TOP);
        mLoadingView.addAnimation(Color.parseColor("#FF4218"), marvel_3,
                LoadingView.FROM_RIGHT);
        mLoadingView.addAnimation(Color.parseColor("#C7E7FB"), marvel_4,
                LoadingView.FROM_BOTTOM);
        mLoadingView.addAnimation(Color.parseColor("#fe5530"), marvel_5,
                LoadingView.FROM_TOP);
        mLoadingView.addAnimation(Color.parseColor("#2F5DA9"), marvel_6,
                LoadingView.FROM_RIGHT);
        mLoadingView.addAnimation(Color.parseColor("#C7E7FB"), marvel_7,
                LoadingView.FROM_LEFT);
        mLoadingView.addAnimation(Color.parseColor("#FF4218"), marvel_8,
                LoadingView.FROM_TOP);

        mLoadingView.addListener(new LoadingView.LoadingListener() {
            @Override
            public void onAnimationStart(int currentItemPosition) {

            }

            @Override
            public void onAnimationRepeat(int nextItemPosition) {

            }

            @Override
            public void onAnimationEnd(int nextItemPosition) {

            }
        });
        mLoadingView.setRepeat(8);
        mLoadingView.startAnimation();
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(4200);
                } catch (InterruptedException e) {
                    e.setStackTrace(getStackTrace());
                } finally {
                    Intent i = new Intent(Splash.this, Home.class);
                    startActivity(i);
                    finish();
                }

            }
        };
        timer.start();

    }

}
