package app.com.redi.redidemo1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES A SCREEN WHICH DISPLAYS THE FEEDBACK FOR THE APP
 *DATE:04/30/2016

 */

public class Feedback extends AppCompatActivity implements View.OnClickListener {

    //PROPERTIES
    Button liker;
    int count;

    //HANDLES THE INITIALIZATION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        count = 0;

        liker = (Button) findViewById(R.id.like);
        liker.setOnClickListener(this);

        //CREATES AN ARROW IN THE NAVIGATION BAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    //HANDLES THE CLICKING ON THE NAVIGATION BAR
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        return super.onOptionsItemSelected(item);
    }

    //HANDLES CLICKING ON THE VIEW
    @Override
    public void onClick(View v) {
        if (v.getId() == liker.getId())
        {
            count++;
            if (count < 5 )
                Toast.makeText(this, "Only " + count + " ? :'(", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Thank you for giving us " + count + " likes", Toast.LENGTH_SHORT).show();
        }
    }
}
