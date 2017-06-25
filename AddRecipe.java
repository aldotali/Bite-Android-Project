package app.com.redi.redidemo1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
/*

 *CREATED BY: aLDO TALI && REDI MUHARREMI
 *DESCRIPTION: ADDS A RECIPE , FROM A USER INPUT TO THE DATABASE
 *DATE:04/01/2016

 */
public class AddRecipe extends AppCompatActivity {

    //PROPERTIES
    EditText ed1,ed2,ed3;
    Button bt1;

    //HANDLES THE INITIALIZATION OF PROPERTIES
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText3);
        ed3 = (EditText)findViewById(R.id.editText4);
        bt1 = (Button) findViewById(R.id.button5);

        //CREATES AN ARROW ITEM IN THE NAVIGATION BAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //WHEN THE ACTIONBAR IS CLICKED GO BACK
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        return super.onOptionsItemSelected(item);
    }
}
