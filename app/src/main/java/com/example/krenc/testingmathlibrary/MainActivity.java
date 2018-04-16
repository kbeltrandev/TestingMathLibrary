package com.example.krenc.testingmathlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mathutil.mathOperations;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerMathOptions = (Spinner) findViewById(R.id.mathOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMathOptions.setAdapter(adapter);

        spinnerMathOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                mathOperation(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub

            }
        });

    }

    public void mathOperation(int position)
    {
        final EditText valOne  = (EditText) findViewById(R.id.valUno);
        final EditText valTwo = (EditText) findViewById(R.id.valDos);
        TextView resultTxt = (TextView)findViewById(R.id.resultText);
        
        String firstValue = valOne.getText().toString();
        String secondValue = valTwo.getText().toString();

        int result = 0;
        if(!firstValue.isEmpty() && !secondValue.isEmpty()){
            switch(position) {
                case 1:
                    result  = mathOperations.restas(Integer.parseInt(firstValue),Integer.parseInt(secondValue));
                    resultTxt.setText(Integer.toString(result));
                    break;
                case 2:
                    result = mathOperations.multiplicar(Integer.parseInt(firstValue),Integer.parseInt(secondValue));
                    resultTxt.setText(Integer.toString(result));
                    break;
                default:
                    result= mathOperations.sumar(Integer.parseInt(firstValue),Integer.parseInt(secondValue));
                    resultTxt.setText(Integer.toString(result));
            }
        }
    }
}
