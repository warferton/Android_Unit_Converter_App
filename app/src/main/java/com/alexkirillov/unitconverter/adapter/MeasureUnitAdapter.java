package com.alexkirillov.unitconverter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alexkirillov.unitconverter.R;
import com.alexkirillov.unitconverter.models.MeasureUnit;

import java.util.ArrayList;

public class MeasureUnitAdapter extends ArrayAdapter<MeasureUnit> {

    public MeasureUnitAdapter(@NonNull Context context, ArrayList<MeasureUnit> unitList) {
        super(context, 0, unitList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.unit_spinner_row, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.unitNameLabel);


        MeasureUnit currentItem = getItem(position);

        if(currentItem != null) {
            textViewName.setText(currentItem.getUnitName());

        }
        return convertView;
    }
}
