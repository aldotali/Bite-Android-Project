package app.com.redi.redidemo1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: DISPLAYS A SINGLE RECIPE
 *DATE:04/29/2016

 */

public class SingleRecipe extends AppCompatActivity implements View.OnClickListener{

    //PROPERTIES
    Button suggestion;
    Button cook;

    //HANDLES THE INITIALIZATION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_recipe);

        suggestion = (Button) findViewById(R.id.button);
        cook = (Button) findViewById(R.id.button2);
        suggestion.setOnClickListener(this);
        cook.setOnClickListener(this);

        //HANDLES THE CREATION OF THE ACTION BAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //CHECKS THE CLICKS ON TEH ACTIONBAR TO RETURN BACK
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        return super.onOptionsItemSelected(item);
    }

    //HANDLES THE CLICKS ON THE VIEW
    @Override
    public void onClick(View v) {
        if (v.getId() == suggestion.getId())
        {
            Toast.makeText(this, "You are a good human", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "You are a better human", Toast.LENGTH_SHORT).show();
        }
        }
    }

