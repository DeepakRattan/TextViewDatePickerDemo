package com.example.deepakrattan.textviewdatepickerdemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by deepak.rattan on 5/12/2017.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    Communicator communicator;
    static final int START_DATE = 1;
    static final int END_DATE = 2;

    private int mChosenDate;

    int cur = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            mChosenDate = bundle.getInt("DATE", 1);
        }


        switch (mChosenDate) {

            case START_DATE:
                cur = START_DATE;
                return new DatePickerDialog(getActivity(), this, year, month, day);

            case END_DATE:
                cur = END_DATE;
                return new DatePickerDialog(getActivity(), this, year, month, day);

        }
        return null;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        month = month + 1;
        String stringOfDate = day + "-" + month + "-" + year;

        if (cur == START_DATE) {
            // set selected date into textview
            TextView txtStartDate = (TextView) getActivity().findViewById(R.id.txtDate);
            txtStartDate.setText(stringOfDate);

        } else {
            TextView txtEndDate = (TextView) getActivity().findViewById(R.id.txtDate1);
            txtEndDate.setText(stringOfDate);

        }
        //communicator = (Communicator) getActivity();
        // communicator.setDate(stringOfDate);
    }


    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        communicator.cancel();
    }
}
