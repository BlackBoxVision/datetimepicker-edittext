package io.blackbox_vision.datetimepickeredittext.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Locale;

import io.blackbox_vision.datetimepickeredittext.internal.DatePickerFragment;


public final class DatePickerInputEditText extends TextInputEditText implements View.OnFocusChangeListener, DatePickerDialog.OnDateSetListener {
    private static final String TAG = DatePickerInputEditText.class.getSimpleName();

    private View.OnFocusChangeListener onFocusChangedListener;
    private FragmentManager manager;
    private Calendar date;

    public DatePickerInputEditText(Context context) {
        super(context);
        init();
    }

    public DatePickerInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DatePickerInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnFocusChangeListener(this);
    }

    private void initDatePickerFragment() {
        final DatePickerFragment datePickerFragment = new DatePickerFragment();

        if (null != date) {
            datePickerFragment.setDate(date);
        }

        datePickerFragment.setOnDateSetListener(this);
        datePickerFragment.show(manager, TAG);
    }

    @Override
    public void onFocusChange(View view, boolean isFocused) {
        if (isFocused) {
            initDatePickerFragment();
        }

        if (null != onFocusChangedListener) {
            onFocusChangedListener.onFocusChange(view, isFocused);
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        final Calendar date = Calendar.getInstance(Locale.getDefault());

        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, monthOfYear);
        date.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        this.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        this.date = date;
    }

    public DatePickerInputEditText setManager(@NonNull FragmentManager manager) {
        this.manager = manager;
        return this;
    }

    public DatePickerInputEditText setDate(@NonNull Calendar date) {
        this.date = date;
        return this;
    }

    public DatePickerInputEditText setOnFocusChangedListener(View.OnFocusChangeListener onFocusChangedListener) {
        this.onFocusChangedListener = onFocusChangedListener;
        return this;
    }
}