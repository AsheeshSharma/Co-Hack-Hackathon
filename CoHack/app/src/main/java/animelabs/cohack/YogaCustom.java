package animelabs.cohack;

/**
 * Created by Asheesh on 10/24/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class YogaCustom extends Activity {
    ListView list;
    String[] web = {
            "Malasana",
            "Chaturanga Dandasana",
            "Utthita Trikonasana",
            "High Lunge",
            "Sirsasana II",
            "Bandha Sarvangasana",
            "Ustrasana"
    } ;
    String[] sub = {
            "Garland Pose",
            "Extended Triangle Pose",
            "Crescent Pose",
            "Revolved Chair Pose",
            "Tripod Headstand",
            "Supported Bridge Pose",
            "Camel Pose"
    } ;
    Integer[] imageId = {
            R.drawable.thmb,
            R.drawable.thmb2,
            R.drawable.thmb3,
            R.drawable.thmb4,
            R.drawable.thmb5,
            R.drawable.thmb6,
            R.drawable.thmb7

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yoga);

        CustomAdapter adapter = new
                CustomAdapter(YogaCustom.this, web,sub, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                if(position==0)
                {
                    Intent i = new Intent(getApplicationContext(), Details.class);
                    i.putExtra("id",1);
                    startActivity(i);
                }
                if(position==1)
                {
                    Intent i = new Intent(getApplicationContext(), Details.class);
                    i.putExtra("id",2);
                    startActivity(i);
                }
                if(position==2)
                {
                    Intent i = new Intent(getApplicationContext(), Details.class);
                    i.putExtra("id",3);
                    startActivity(i);
                }
                if(position==3)
                {
                    Intent i = new Intent(getApplicationContext(), Details.class);
                    i.putExtra("id",4);
                    startActivity(i);
                }

            }
        });

    }

}