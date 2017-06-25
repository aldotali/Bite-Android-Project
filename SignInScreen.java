package app.com.redi.redidemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: HANDLES THE ACTION AND CREATES THE FIRST SCREEN OF THE APP
 *DATE:04/18/2016

 */

public class SignInScreen extends AppCompatActivity implements View.OnClickListener {

    //PROPERTIES
    Button myButton;
    Button signUp;
    BiteDBHelper bDBH;
    EditText ed1,ed2;
    CheckBox guest;
    TextView joke;
    Jokes instance;

    //HANDLES THE INITIALIZATION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        bDBH = new BiteDBHelper(this.getApplicationContext());

        signUp = (Button) findViewById((R.id.button3));
        guest = (CheckBox) findViewById(R.id.checkBox);
        myButton = (Button) findViewById(R.id.buttonLog);

        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        ed1.setText(password);
        ed2.setText(username);

        joke = (TextView) findViewById(R.id.textView);
        instance = new Jokes();
        joke.setText(instance.getJoke());

        myButton.setOnClickListener(this);
        signUp.setOnClickListener(this);
}


    //HANDLES THE CLICK ON THE VIEW
    @Override
    public void onClick(View v) {
        if (v.getId() == myButton.getId()) {
            if (!guest.isChecked()) {
                if (bDBH.checkLogin(ed1.getText().toString(), ed2.getText().toString())) {
                Intent in = new Intent(this, NavigationDrawer.class);
                    startActivity(in);
                } else {
                    Toast.makeText(SignInScreen.this, "Wroooooong on so many levels", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Intent in = new Intent(this, NavigationDrawer.class);
                startActivity(in);
            }
            }
        else
        {
            Intent in = new Intent(this, CreateAccount.class);
            startActivity(in);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.imageView)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
