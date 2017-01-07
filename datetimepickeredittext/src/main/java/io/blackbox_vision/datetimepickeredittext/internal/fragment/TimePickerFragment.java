package io.blackbox_vision.datetimepickeredittext.internal.fragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

import static android.app.TimePickerDialog.OnTimeSetListener;


public final class TimePickerFragment extends DialogFragment {
    private OnTimeSetListener onTimeSetListener;
    private Boolean is24HourView;
    private Calendar time;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int hourOfDay, minute;

        if (null != time) {
            hourOfDay = time.get(Calendar.HOUR_OF_DAY);
            minute = time.get(Calendar.MINUTE);
        } else {
            final Calendar c = Calendar.getInstance();

            hourOfDay = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);
        }

        if (null == is24HourView) {
            is24HourView = true;
        }

        return new TimePickerDialog(getActivity(), onTimeSetListener, hourOfDay, minute, is24HourView);
    }

    public TimePickerFragment setOnTimeSetListener(@NonNull OnTimeSetListener onTimeSetListener) {
        this.onTimeSetListener = onTimeSetListener;
        return this;
    }

    public TimePickerFragment setIs24HourView(boolean is24HourView) {
        this.is24HourView = is24HourView;
        return this;
    }

    public TimePickerFragment setTime(@NonNull Calendar time) {
        this.time = time;
        return this;
    }
}