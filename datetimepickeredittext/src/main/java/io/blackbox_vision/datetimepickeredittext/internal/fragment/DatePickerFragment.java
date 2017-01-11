package io.blackbox_vision.datetimepickeredittext.internal.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

import io.blackbox_vision.datetimepickeredittext.internal.utils.DateUtils;

import static android.app.DatePickerDialog.*;


public final class DatePickerFragment extends DialogFragment {
    private static final String DEFAULT_TEMPLATE = "dd/MM/yyyy";
    private static final String DEFAULT_MIN_DATE = "01/01/1980";
    private static final String DEFAULT_MAX_DATE = "01/01/2100";

    private OnDateSetListener onDateSetListener;
    private Calendar date;

    private String minDate;
    private String maxDate;

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

        final String minDateStr = null != minDate? minDate : DEFAULT_MIN_DATE;
        final String maxDateStr = null != maxDate? maxDate : DEFAULT_MAX_DATE;

        final long min = DateUtils.parse(minDateStr, DEFAULT_TEMPLATE).getTime();
        final long max = DateUtils.parse(maxDateStr, DEFAULT_TEMPLATE).getTime();

        datePickerDialog.getDatePicker().setMinDate(min);
        datePickerDialog.getDatePicker().setMaxDate(max);

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

    public String getMaxDate() {
        return maxDate;
    }

    public DatePickerFragment setMaxDate(String maxDate) {
        this.maxDate = maxDate;
        return this;
    }

    public String getMinDate() {
        return minDate;
    }

    public DatePickerFragment setMinDate(String minDate) {
        this.minDate = minDate;
        return this;
    }
}