package animelabs.cohack;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Asheesh on 10/24/2015.
 */
public class Home extends Activity {
    ImageView i1,i2,i3,i4,i5;
    ImageButton ib1,ib2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        i1=(ImageView)findViewById(R.id.imageView3);
        i2=(ImageView)findViewById(R.id.imageView4);
        i3=(ImageView)findViewById(R.id.imageView5);
        i4=(ImageView)findViewById(R.id.imageView6);
        i5=(ImageView)findViewById(R.id.imageView7);
        ib1=(ImageButton)findViewById(R.id.imageButton);
        ib2=(ImageButton)findViewById(R.id.imageButton2);
        animstart();
        anim2start();
        anim3start();
        anim4start();
        anim5start();
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(ib1, View.TRANSLATION_X, 600);
                rotateAnimator.setRepeatCount(1);
                rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
                rotateAnimator.setDuration(600);
                rotateAnimator.start();
                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(610);
                        } catch (InterruptedException e) {
                            e.setStackTrace(getStackTrace());
                        } finally {
                            Intent i = new Intent(Home.this, Login.class);
                            startActivity(i);
                        }

                    }
                };
                timer.start();
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(ib2, View.TRANSLATION_X, 600);
                rotateAnimator.setRepeatCount(1);
                rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
                rotateAnimator.setDuration(600);
                rotateAnimator.start();
                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(610);
                        } catch (InterruptedException e) {
                            e.setStackTrace(getStackTrace());
                        } finally {
                            Intent i = new Intent(Home.this, Register.class);
                            startActivity(i);
                        }

                    }
                };
                timer.start();
            }
        });
    }

      private void anim2start() {
          ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(i2, View.ROTATION_Y, 360);
          rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
          rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
          rotateAnimator.setDuration(800);
          rotateAnimator.start();
    }
    private void anim3start() {
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(i3, View.ROTATION_Y, 360);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
        rotateAnimator.setDuration(800);
        rotateAnimator.start();
    }
    private void anim4start() {
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(i4, View.ROTATION_Y, 360);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
        rotateAnimator.setDuration(800);
        rotateAnimator.start();
    }
    private void anim5start() {
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(i5, View.ROTATION_Y, 360);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
        rotateAnimator.setDuration(800);
        rotateAnimator.start();
    }

    private void animstart() {
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(i1, View.ROTATION_Y, 360);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
        rotateAnimator.setDuration(800);
        rotateAnimator.start();
    }
}
