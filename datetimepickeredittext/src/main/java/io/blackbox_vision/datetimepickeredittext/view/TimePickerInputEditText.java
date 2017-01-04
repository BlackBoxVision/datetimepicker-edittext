package io.blackbox_vision.datetimepickeredittext.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

import io.blackbox_vision.datetimepickeredittext.internal.TimePickerFragment;

import static android.view.View.OnFocusChangeListener;
import static android.app.TimePickerDialog.OnTimeSetListener;


public final class TimePickerInputEditText extends TextInputEditText implements OnFocusChangeListener, OnTimeSetListener {
    private static final String TAG = TimePickerInputEditText.class.getSimpleName();

    private OnFocusChangeListener onFocusChangedListener;
    private FragmentManager manager;
    private Calendar time;

    public TimePickerInputEditText(Context context) {
        super(context);
        init();
    }

    public TimePickerInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimePickerInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnFocusChangeListener(this);
    }

    private void initTimePickerFragment() {
        final TimePickerFragment timePickerFragment = new TimePickerFragment();

        if (null != time) {
            timePickerFragment.setTime(time);
        }

        timePickerFragment.setOnTimeSetListener(this);
        timePickerFragment.show(manager, TAG);
    }

    @Override
    public void onFocusChange(View view, boolean isFocused) {
        if (isFocused) {
            initTimePickerFragment();
        }

        if (null != onFocusChangedListener) {
            onFocusChangedListener.onFocusChange(view, isFocused);
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        final Calendar date = Calendar.getInstance(Locale.getDefault());

        date.set(Calendar.HOUR_OF_DAY, hourOfDay);
        date.set(Calendar.MINUTE, minute);

        this.setText(hourOfDay + ":" + minute);
        this.time = date;
    }

    public TimePickerInputEditText setManager(@NonNull FragmentManager manager) {
        this.manager = manager;
        return this;
    }

    public TimePickerInputEditText setTime(@NonNull Calendar time) {
        this.time = time;
        return this;
    }

    public TimePickerInputEditText setOnFocusChangedListener(OnFocusChangeListener onFocusChangedListener) {
        this.onFocusChangedListener = onFocusChangedListener;
        return this;
    }
}