package app.com.redi.redidemo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES A FRAGMENT WHICH DIPLAYS A LISTVIEW OF THE INGRIDIENTS
 *DATE:05/1/2016

 */

//CREATES A LIST OF INGRIDIENTS UNDER THE NAVIGATION BAR AS A FRAGMENT
public class InventoryListFragment extends android.support.v4.app.ListFragment {
    //HANDLES THE CREATION OF THE VIEW
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate the fragment layout file
        final ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_list_inventory, container, false);

        //Create datasources
        String[] datasource = getResources().getStringArray(R.array.ingridients);

        //create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.inventory_row_layout, R.id.inventorytxtitem, datasource);

        //Bind adapter to the listFragment
        setListAdapter(adapter);
        //Retain listFragment instance acccros configuration changes
        setRetainInstance(true);

        return rootview;
    }

    // HANDLES THE CLICKING IN THE LISTVIEW
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (position == 1) {
            Intent in = new Intent(getActivity(), IngridientAddInfo.class);
            startActivity(in);
        }
    }
}