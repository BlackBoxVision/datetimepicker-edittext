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
    private Calendar date;

    private Long minDate;
    private Long maxDate;

    private Integer themeId;

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

        DatePickerDialog datePickerDialog;

        if (null != themeId && themeId != 0) {
            datePickerDialog = new DatePickerDialog(getActivity(), themeId, onDateSetListener, year, month, day);
        } else {
            datePickerDialog = new DatePickerDialog(getActivity(), onDateSetListener, year, month, day);
        }

        datePickerDialog.getDatePicker().setMinDate(minDate);
        datePickerDialog.getDatePicker().setMaxDate(maxDate);

        return datePickerDialog;
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

    public Long getMaxDate() {
        return maxDate;
    }

    public DatePickerFragment setMaxDate(Long maxDate) {
        this.maxDate = maxDate;
        return this;
    }

    public Long getMinDate() {
        return minDate;
    }

    public DatePickerFragment setMinDate(Long minDate) {
        this.minDate = minDate;
        return this;
    }
}