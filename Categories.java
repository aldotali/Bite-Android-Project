package app.com.redi.redidemo1;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES A CATEGORY CLASS WHICH IMPLEMENTS THE GRID VIEW ADAPTED FROM THE CUSTOMADAPTER
 *DATE:05/1/2016

 */

public class Categories extends AppCompatActivity {

    //PROPERTIES
    GridView gv;

    public static String [] prgmNameList={"Italian","Chinese","Mexican","Albanian","Pakistani ","French",
            "German","Indian","Out of this world"};

    public static int [] prgmImages={R.drawable.images,R.drawable.images1,R.drawable.images2,
            R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6,R.drawable.images7,
            R.drawable.images8};


    //HANDLES THE INITIALIZATION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);

        //HANDLES THE ARROW IN THE NAVIGATIONBAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));
    }

    //HANDLES THE CLICKS IN THE ACTIONBAR
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
