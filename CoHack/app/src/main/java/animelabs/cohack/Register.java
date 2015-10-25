package animelabs.cohack;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import animelabs.cohack.Utils;
/**
 * Created by Asheesh on 10/24/2015.
 */
public class Register extends Activity {
    EditText username,pass,phone;
    ImageButton ib1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pwd);
        ib1=(ImageButton)findViewById(R.id.imageButton3);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString();
                String pone=pass.getText().toString();
                String pword=phone.getText().toString();
                if(uname==null||pword==null||phone==null)
                {

                        return;
                }
                final ProgressDialog progressDialog=ProgressDialog.show(Register.this,null,"Registering");
                final ParseUser parseUser=new ParseUser();
                parseUser.setEmail(pword);
                parseUser.setPassword(pone);
                parseUser.setUsername(uname);
                parseUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        progressDialog.dismiss();
                        if(e==null)
                        {
                            ParseInstallation parseInstallation=ParseInstallation.getCurrentInstallation();
                            parseInstallation.put("username", parseUser.getUsername());
                            parseInstallation.saveInBackground();
                            setResult(RESULT_OK);
                            finish();
                        }
                        else
                        {
                            Utils.showDialog(
                                    Register.this,
                                    "Error while Registering" + " "
                                            + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
}
