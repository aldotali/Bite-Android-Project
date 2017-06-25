package app.com.redi.redidemo1;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/*

 *CREATED BY: REDI MUHARREMI && ALDO TALI
 *DESCRIPTION: CREATES A CLASS TO DISPLAY THE LIST OF INGRIDIENTS
 *DATE:04/30/2016

 */

//CREATES THE INVENTORY LIST BY USING THE INVENTORYLISTFRAGMENT AND AN ACTIONBAR
public class Invetory extends ActionBarActivity {

    //PROPERTIES
    String [] ingridients;

    //HANDLES THE INITIALIZATION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invetory);

        InventoryListFragment inventoryListFragment = (InventoryListFragment) getSupportFragmentManager().findFragmentByTag("inventoryListFragment");

        //CREATES THE ARROW ON THE NAVIGATION BAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        if(inventoryListFragment == null)
        {
            inventoryListFragment = new InventoryListFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(android.R.id.content, inventoryListFragment,"recipeListFragment");
            transaction.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    //HANDLES THE CLICK ON THE ACTIONBAR
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        return super.onOptionsItemSelected(item);
    }


}
