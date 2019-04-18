package com.kuldeep.intelligent_farming.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuldeep.intelligent_farming.Pojo_classes.mysensorsPojo;
import com.kuldeep.intelligent_farming.R;

import java.util.ArrayList;

/**
 * Created by kuldeep on 04-01-2018.
 */


public class MySensorAdapter extends ArrayAdapter{


  private ArrayList arraylist;
    Context context;
    public MySensorAdapter(Context context, ArrayList<mysensorsPojo> objects)
    {
        super(context, R.layout.grid_column, objects);
        arraylist=objects;
        this.context=context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View CustomView = layoutInflater.inflate(R.layout.grid_column, parent, false);
        mysensorsPojo sensorpojo= (mysensorsPojo) arraylist.get(position);



        ((TextView)CustomView.findViewById(R.id.sname)).setText(sensorpojo.getSensor_name());
        ((TextView)CustomView.findViewById(R.id.svalue)).setText(sensorpojo.getSensor_value());

        int imageResource = context.getResources().getIdentifier(sensorpojo.getSensor_image(), null, context.getPackageName());
        ((ImageView)CustomView.findViewById(R.id.simage)).setImageDrawable(context.getResources().getDrawable(imageResource));

        return CustomView;
    }

}