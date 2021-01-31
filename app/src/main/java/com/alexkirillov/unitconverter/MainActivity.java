package com.alexkirillov.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alexkirillov.unitconverter.adapter.MeasureUnitAdapter;
import com.alexkirillov.unitconverter.models.MeasureUnit;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayList<MeasureUnit> measureUnitList;
    private MeasureUnitAdapter adapter;
    private String other_unit_name;
    private MeasureUnit starting_unit;

    private TextView conversion_result_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conversion_result_label = (TextView) findViewById(R.id.resultLabel);

        initList();

        Spinner spinner_one =  findViewById(R.id.unitSpinnerOne);
        Spinner spinner_two =  findViewById(R.id.unitSpinnerTwo);
        // Create a CustomAdapter using the string array and a default spinner layout
        adapter = new MeasureUnitAdapter(this, measureUnitList);

        //Apply the adapter to the spinner
        spinner_one.setAdapter(adapter);
        spinner_two.setAdapter(adapter);

        spinner_one.setOnItemSelectedListener(this);
        spinner_two.setOnItemSelectedListener(this);

    }

    private void initList(){
        String[] unitNames = getResources().getStringArray(R.array.units_array);
        measureUnitList = new ArrayList<>();
        for(String name : unitNames) {
            measureUnitList.add(new MeasureUnit(name));
        }
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        MeasureUnit selected_item = (MeasureUnit) parent.getItemAtPosition(position);

        String unit_name = selected_item.getUnitName();

        Toast.makeText(MainActivity.this, unit_name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void convert(View view){

        EditText text = findViewById(R.id.convert_value);

        double value_to_convert = Double.parseDouble(text.getText().toString());

        Spinner spinner_1 = findViewById(R.id.unitSpinnerOne);
        starting_unit = new MeasureUnit(spinner_1.getSelectedItem().toString());
        Spinner spinner_2 = findViewById(R.id.unitSpinnerTwo);
        other_unit_name = new MeasureUnit(spinner_2.getSelectedItem().toString()).toString();

        if(starting_unit!= null && !other_unit_name.equals("")){
            Double res;//conversion result temp val

            switch (starting_unit.getUnitName()){
                case "Pounds" :
                    res = starting_unit.convertPounds(value_to_convert, other_unit_name);
                    conversion_result_label.setText(res.toString());
                    break;

                case "Ounces" :
                    res = starting_unit.convertOunces(value_to_convert, other_unit_name);
                    conversion_result_label.setText(res.toString());
                    break;

                case "Kilograms" :
                    res = starting_unit.convertKilograms(value_to_convert, other_unit_name);
                    conversion_result_label.setText(res.toString());
                    break;

                case  "Grams" :
                    res = starting_unit.convertGrams(value_to_convert, other_unit_name);
                    conversion_result_label.setText(res.toString());
                    break;
            }


        }


    }
}