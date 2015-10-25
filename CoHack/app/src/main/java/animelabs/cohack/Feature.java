package animelabs.cohack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Asheesh on 10/25/2015.
 */
public class Feature extends Activity {
    ImageView iv1,iv2,iv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feature);
        iv1=(ImageView)findViewById(R.id.imageView14);
        iv2=(ImageView)findViewById(R.id.imageView15);
        iv3=(ImageView)findViewById(R.id.imageView16);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Feature.this,YogaCustom.class);
                startActivity(i);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Feature.this,CallServer.class);
                startActivity(i);
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Feature.this,Pgcorner.class);
                startActivity(i);
            }
        });

    }
}
