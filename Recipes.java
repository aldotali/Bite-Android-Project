package app.com.redi.redidemo1;

import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATE A SINGLE CLASS TO DISPLAY THE LSIT OF RECIPES
 *DATE:05/1/2016

 */

public class Recipes extends ActionBarActivity {

    String [] recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        RecipeListFragment recipeListFragment = (RecipeListFragment) getSupportFragmentManager().findFragmentByTag("recipeListFragment");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        if(recipeListFragment == null)
        {
            recipeListFragment = new RecipeListFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(android.R.id.content, recipeListFragment,"recipeListFragment");
            transaction.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        return super.onOptionsItemSelected(item);
    }


    protected void onListItemClick(ListView l, View v, int position, long id) {

        if(position == 1) {
            Intent intent = new Intent(this, SingleRecipe.class);

            startActivity(intent);
        }
    }



}
