package app.com.redi.redidemo1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*

 *CREATED BY: REDI MUHARREMI && ALDO TALI
 *DESCRIPTION: CREATES A CLASS TO GET THE AMOUNT AND PRICE OF AN INGRIDIENT
 *DATE:04/30/2016

 */

//HANDLES THE AMOUNT AND AND PRICE OF THE INGRIDIENT
public class IngridientAddInfo extends AppCompatActivity implements View.OnClickListener {

    //PROPERTIES
    Button save;
    EditText amount;
    EditText price;
    double amount1;
    double price1;

    //HANDLES THE INITIALIZATION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingridient_add_info);

        save = (Button) findViewById(R.id.button4);
        amount = (EditText) findViewById(R.id.amount);
        price = (EditText) findViewById(R.id.price);

        //CREATES AN ARROW ON THE NAVIGATION BAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        save.setOnClickListener(this);
    }

    //HANDLES THE CLICKING ON THE VIEW
    public void onClick(View v) {
        if (v.getId() == save.getId())
        {
            //TRIES TO  GET THE INFORMATION
            try
            {
                amount1 = Double.parseDouble(amount.getText().toString());
                price1 = Double.parseDouble(price.getText().toString());
                 Toast.makeText(this, "The amount you put is " + amount1 + "\n The price you put is " + price1, Toast.LENGTH_SHORT).show();
             }
            catch (Exception e)
             {
                Toast.makeText(this, "Wise but please fill the fields" , Toast.LENGTH_SHORT).show();
             }
        }
    }

    //HANDLES THE CLICKING IN THE NAVIGATION BAR
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        return super.onOptionsItemSelected(item);
    }
}

