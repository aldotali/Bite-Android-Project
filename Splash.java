package app.com.redi.redidemo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES A SIMPLE SPLASH IMAGE ANIMATION FO THE OPENING SCREEN
 *DATE:04/19/2016

 */

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.splash_layout);
        Thread myThread = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    sleep(3000);
                    Intent startMainScreen = new Intent(getApplicationContext(), SignInScreen.class);
                    startActivity(startMainScreen);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        myThread.start();
    }
}
