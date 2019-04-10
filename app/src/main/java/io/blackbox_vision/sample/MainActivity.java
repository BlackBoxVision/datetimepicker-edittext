package io.blackbox_vision.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;

import java.util.Calendar;

import io.blackbox_vision.datetimepickeredittext.view.DatePickerEditText;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;
import io.blackbox_vision.datetimepickeredittext.view.TimePickerEditText;
import io.blackbox_vision.datetimepickeredittext.view.TimePickerInputEditText;

@SuppressWarnings("all")
public final class MainActivity extends AppCompatActivity {

    private DatePickerEditText datePickerEditText;
    private TimePickerEditText timePickerEditText;

    private DatePickerInputEditText datePickerInputEditText;
    private TimePickerInputEditText timePickerInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePickerEditText = (DatePickerEditText) findViewById(R.id.datePickerEditText);
        timePickerEditText = (TimePickerEditText) findViewById(R.id.timePickerEditText);

        datePickerInputEditText = (DatePickerInputEditText) findViewById(R.id.datePickerInputEditText);
        timePickerInputEditText = (TimePickerInputEditText) findViewById(R.id.timePickerInputEditText);

        /*datePickerEditText.setManager(getSupportFragmentManager());
        timePickerEditText.setManager(getSupportFragmentManager());

        datePickerInputEditText.setManager(getSupportFragmentManager());
        timePickerInputEditText.setManager(getSupportFragmentManager());*/

        // Set the date formatter with the given formatting style from device setting.
//        datePickerEditText.setDateFormat(DateFormat.getLongDateFormat(getApplicationContext()));
        timePickerEditText.setTimeFormat(DateFormat.getTimeFormat(getApplicationContext()));

        datePickerInputEditText.setDateFormat(DateFormat.getMediumDateFormat(getApplicationContext()));
        timePickerInputEditText.setTimeFormat(DateFormat.getTimeFormat(getApplicationContext()));

//        datePickerEditText.setDate(Calendar.getInstance());
        datePickerInputEditText.setDate(Calendar.getInstance());

        timePickerEditText.setTime(Calendar.getInstance());
        timePickerInputEditText.setTime(Calendar.getInstance());
    }
}
