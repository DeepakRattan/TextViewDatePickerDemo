package com.example.deepakrattan.textviewdatepickerdemo;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Communicator {
    private TextView txtDate, txtDate1;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtDate1 = (TextView) findViewById(R.id.txtDate1);

        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putInt("DATE", 1);
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.setArguments(bundle);

                newFragment.show(getSupportFragmentManager(), "datePicker");
                //txtDate.setText(date);
            }
        });

        txtDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("DATE", 2);
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.setArguments(bundle);
                newFragment.show(getSupportFragmentManager(), "datePicker");

                //txtDate1.setText(date);
            }
        });


    }


    @Override
    public void setDate(String date) {
        this.date = date;
        //txtDate.setText(date);
    }

    @Override
    public void cancel() {

    }


}
