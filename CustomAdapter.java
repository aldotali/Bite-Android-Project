package app.com.redi.redidemo1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES AN ADAPTER WHICH USES THE BASEADAPTER TO ADAPT THE VIEWS
                OF A SINGLE GRID ACCORDINGLY
 *DATE:03/18/2016

 */
public class CustomAdapter extends BaseAdapter {

    //PROPERTIES
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;

    //CONSTRUCTOR WHICH TAKES 4 PARAMETERS
    public CustomAdapter(Categories mainActivity, String[] prgmNameList, int[] prgmImages) {
        result = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;

        //INFLATES THE LAYOUT
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public void onCreate(Bundle savedInstanceState) {}

    //RETURNS THE LENGTH OF THE ARRAY OF STRINGS OF NAMES
    @Override
    public int getCount() {
        return result.length;
    }

    //RETURNNS THE POSITION OF THE ITEM
    @Override
    public Object getItem(int position) {
        return position;
    }

    //RETURNS THE ID OF THE ITEM
    @Override
    public long getItemId(int position) {
        return position;
    }

    //A CLASS FOR THE SINGLE GRID
    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    //RETURNS THE VIEW OF A SINGLE GRID
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //PROPERTIES
        final View rowView;
        final int a = 1;

        Holder holder=new Holder();

        rowView = inflater.inflate(R.layout.program_list_categories, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        //SETS A LISTENER TO HANDLE CLICKING ON THE VIEW
        rowView.setOnClickListener(new View.OnClickListener() {

            //HANDLE THE LISTENER
            @Override
            public void onClick(View v) {

            //GOES TO THE CATEGORIE
            if (position == a)
            {
                context.startActivity(new Intent(context, Recipes.class));
            }
                else
            {
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }

            }
        });

        return rowView;
    }



}
