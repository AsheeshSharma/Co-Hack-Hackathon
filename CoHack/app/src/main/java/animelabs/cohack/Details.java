package animelabs.cohack;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * Created by Asheesh on 10/25/2015.
 */
public class Details extends Activity {
    ImageView i1,i2;
    TextView t1,t3;
    String choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        i1=(ImageView)findViewById(R.id.imageView12);
        t1=(TextView)findViewById(R.id.textView5);
        t1.setMovementMethod(new ScrollingMovementMethod());
        t3=(TextView)findViewById(R.id.textView6);
        i2=(ImageView)findViewById(R.id.imageView13);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id=extras.getInt("id");
            if(id==0)
            {
                i1.setImageResource(R.mipmap.lk);
                t1.setText("This beautiful squat is one of my all-time favorite poses. Malasana releases the lower back, opens the hips, and turns the practitioner into a cute little nugget. " +
                        "Explore variations and tips on how to make this pose easier or how to go deeper.");
                t3.setText("Malasana");
                choice=t3.getText().toString();

            }
            else if(id==1)
            {
                i1.setImageResource(R.mipmap.lkk);
                t1.setText("Chaturanga is one of the most common postures in Vinyasa yoga—but also one of the most abused. Students tend to rush this pose, cheating its alignment, which with repetition can lead to injury." +
                        " Check out my pointers below to revisit this foundational posture and begin treating it as its own pose instead of a transition.");
                t3.setText("Chaturanga Dandasana");
                choice=t3.getText().toString();

            }
            else if(id==2)
            {
                i1.setImageResource(R.mipmap.lkkk);
                t1.setText("Trikonasana. Such a classic standing pose! We live in a world where standing poses are often ignored, but this one is part of my regular practice come rain or shine." +
                        " It is a glorious way to release your lower back, strengthen your core, and expand your body (and mind).");
                t3.setText("Utthita Trikonasana");
                choice=t3.getText().toString();

            }
            else if(id==3)
            {
                i1.setImageResource(R.mipmap.lkl);
                t1.setText("I know Chair isn't the most popular pose in the world, but this is why it's on the list. It's a great foundational pose to teach us how to twist safely. " +
                        "If you can learn the mechanics of a twist here, you'll be safer in more advanced postures.");
                t3.setText("High Lunge");

            }
            i2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ParseObject parseObject=new ParseObject("Choice");
                    parseObject.put("choice",choice);
                    parseObject.saveEventually(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null)
                            {
                                Snackbar.make(getWindow().getDecorView().getRootView(), "Preference Succesfully Saved", Snackbar.LENGTH_SHORT).show();
                            }
                            else
                            {

                            }

                        }
                    });
                }
            });

        }
    }
}
