package io.blackbox_vision.datetimepickeredittext.internal.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;

import static android.app.DatePickerDialog.*;


public final class DatePickerFragment extends DialogFragment {
    private OnDateSetListener onDateSetListener;
    private Integer themeId;
    private Calendar date;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year, month, day;

        if (null != date) {
            year = date.get(Calendar.YEAR);
            month = date.get(Calendar.MONTH);
            day = date.get(Calendar.DAY_OF_MONTH);
        } else {
            final Calendar c = Calendar.getInstance();

            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }

        if (null != themeId && themeId != 0) {
            return new DatePickerDialog(getActivity(), themeId, onDateSetListener, year, month, day);
        }

        return new DatePickerDialog(getActivity(), onDateSetListener, year, month, day);
    }

    public OnDateSetListener getOnDateSetListener() {
        return onDateSetListener;
    }

    public DatePickerFragment setOnDateSetListener(@NonNull OnDateSetListener onDateSetListener) {
        this.onDateSetListener = onDateSetListener;
        return this;
    }

    public Calendar getDate() {
        return date;
    }

    public DatePickerFragment setDate(@NonNull Calendar date) {
        this.date = date;
        return this;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public DatePickerFragment setThemeId(Integer themeId) {
        this.themeId = themeId;
        return this;
    }
}