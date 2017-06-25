package app.com.redi.redidemo1;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES A USER ACCOUNT WHEN THE USER DOES NOT HAVE ONE
 *DATE:03/025/2016

 */
public class CreateAccount extends AppCompatActivity {

    //PROPERTIES
    Button bSignup;
    Button bSignUp;
    EditText etName, etSurname, etUsername, etnumber,  etemail, etpass, etpass2;
    BiteDBHelper dBH;

    //HANDLES THE INITIALIZATION OF THE ACTIVITY
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        bSignup = (Button) findViewById(R.id.bSignup);
        dBH = new BiteDBHelper(this);

        bSignup.setOnClickListener(new View.OnClickListener() {

            //HANDLES THE CLICKS ON THE SCREEN AND CHECKS WHICH ACTION TO FOLLOW
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.bSignup)
                {
                    EditText username = (EditText) findViewById(R.id.etUsername);
                    EditText pass1 = (EditText) findViewById(R.id.etPasword);
                    EditText pass2 = (EditText) findViewById(R.id.etPasword2);

                    String strusername = username.getText().toString();
                    String strpas1 = pass1.getText().toString();
                    String strpas2 = pass2.getText().toString();

                  if (strpas1.length() < 6)
                  {
                      Toast.makeText(CreateAccount.this, "Password should include at least 6 letters", Toast.LENGTH_SHORT).show();
                  }
                  else if (!strpas1.equals(strpas2))
                  {
                      Toast.makeText(CreateAccount.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                  }
                  else if (dBH.checkUsername(strusername))
                  {
                      Toast.makeText(CreateAccount.this, "The username is already taken", Toast.LENGTH_SHORT).show();
                  }

                    else {

                      //GOES TO THE LOGIN PAGE AND INPUTS THE NEWLY REGISTERED USER AND PASSWORD AUTOMATICALLY
                        Intent goToLogin = new Intent(CreateAccount.this, SignInScreen.class);
                        goToLogin.putExtra("username", strusername);
                        goToLogin.putExtra("password", strpas1);
                        dBH.addUser(strusername, strpas1);
                        startActivity(goToLogin);
                    }

                    }
                }
            }
        );

        //CREATES ARROW IN NAVIGATIONBAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //HANDLES THE CLICKING IN THE NAVIGATIONBAR
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        return super.onOptionsItemSelected(item);
    }
}
