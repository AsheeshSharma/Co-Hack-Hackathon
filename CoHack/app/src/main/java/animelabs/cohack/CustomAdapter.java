package animelabs.cohack;

/**
 * Created by Asheesh on 10/24/2015.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    private final String[] sub;
    public CustomAdapter(Activity context,
                         String[] web,String sub[], Integer[] imageId) {
        super(context, R.layout.template, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
        this.sub=sub;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.template, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView2);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        txtTitle.setText(web[position]);
        txtTitle2.setText(sub[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}