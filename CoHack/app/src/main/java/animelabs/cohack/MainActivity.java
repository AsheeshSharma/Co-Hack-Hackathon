package animelabs.cohack;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseInstallation;


public class MainActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "wqkgIIcXS9j3iYbEV33X1FKIj57iqNwwAzyUJhNs", "X6SeTWSBhGVhUAGiZaZfrgnMTsivuFwAdGymB4LP");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
