package io.blackbox_vision.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

        datePickerEditText.setManager(getSupportFragmentManager());
        timePickerEditText.setManager(getSupportFragmentManager());

        datePickerInputEditText.setManager(getSupportFragmentManager());
        timePickerInputEditText.setManager(getSupportFragmentManager());
    }
}
