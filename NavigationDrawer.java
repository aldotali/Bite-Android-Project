package app.com.redi.redidemo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: HANDLES NAVIGATION DRAWER ON THE WELCOME PAGE
 *DATE:05/1/2016

 */

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //PROPERTIES
    NavigationView navigationView = null;
    Toolbar toolbar = null;

    //HANDLES THE INITIALIZATION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        //CREATES THE FRAGMENT WHICH IS USED IN THE SAME PAGE
        MainScreen fragment = new MainScreen();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //CREATES THE DRAWER OF THE NAVIGATION
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //HANDLES THE CLICKS IN THE DRAWER AND DETERMINE WHEN TO OPES OR CLOSE
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //HANDLES THE ACTION BAR ITEM CLICKS
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            Intent intent1 = new Intent(this,SettingsActivity.class);
            startActivity(intent1);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            MainScreen fragment = new MainScreen();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_categories) {
            Intent in = new Intent(this, Categories.class);
            startActivity(in);

        } else if (id == R.id.nav_inventory) {
            Intent in = new Intent(this, Invetory.class);
            startActivity(in);
        } else if (id == R.id.nav_logout) {
            finish();

        } else if (id == R.id.nav_settings) {
            Intent in = new Intent(this, SettingsActivity.class);
            startActivity(in);

        } else if (id == R.id.nav_feedback) {
            Intent in = new Intent(this, Feedback.class);
            startActivity(in);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
