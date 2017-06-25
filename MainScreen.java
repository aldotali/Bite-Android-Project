package app.com.redi.redidemo1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES THE FIRST PAGE ON THE WELCOME SCREEN
 *DATE:05/01/2016

 */

public class MainScreen extends Fragment {

    public MainScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen, container, false);
    }

}
