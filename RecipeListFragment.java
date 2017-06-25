package app.com.redi.redidemo1;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: PROVIDES WITH A FRAGMENT OF RECIPES TO PUT IN THE LIST VIEW
 *DATE:05/1/2016

 */

//
public class RecipeListFragment extends android.support.v4.app.ListFragment  {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //inflate the fragment layout file
        final ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_list_recipes,container, false);

        //Create datasources
        String[] datasource = {"Soup","French Fries","Pasta","Cake","Japanase"};

        //create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.recipes_row_layout, R.id.txtitem,datasource);

        //Bind adapter to the listFragment
        setListAdapter(adapter);
        //Retain listFragment instance acccros configuration changes
        setRetainInstance(true);


        return rootview;
    }

    //HANDLES THE CLICKS ON THE LIST
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(position == 1)
        {
            Intent in = new Intent(getActivity(), SingleRecipe.class  );
            startActivity(in);
        }
    }


}
