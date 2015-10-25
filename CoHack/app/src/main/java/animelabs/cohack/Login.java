package animelabs.cohack;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Asheesh on 10/24/2015.
 */
public class Login extends Activity {
    EditText e1,e2;
    ImageButton ib1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pwd);
        ib1=(ImageButton)findViewById(R.id.imageButton4);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=e1.getText().toString();
                String pwd=e2.getText().toString();
                if(uname==null||pwd==null)
                {
                    Toast.makeText(Login.this, "Please enter the required details", Toast.LENGTH_SHORT);
                }
                final ProgressDialog progressDialog=ProgressDialog.show(Login.this, null, "Signing In..");
                ParseUser.logInInBackground(uname, pwd, new LogInCallback() {
                            @Override
                            public void done(ParseUser parseUser, ParseException e) {
                                if (parseUser != null) {
                                    progressDialog.dismiss();

                                    startActivity(new Intent(Login.this, Feature.class));
                                } else {
                                    progressDialog.dismiss();
                                    Utils.showDialog(Login.this, e.getMessage());
                                    e.printStackTrace();
                                }
                            }
                        }
                );
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&&resultCode==RESULT_OK)
        {
            finish();
        }
    }
}
