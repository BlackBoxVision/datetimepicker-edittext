package io.blackbox_vision.datetimepickeredittext.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

import io.blackbox_vision.datetimepickeredittext.R;
import io.blackbox_vision.datetimepickeredittext.internal.fragment.TimePickerFragment;
import io.blackbox_vision.datetimepickeredittext.internal.utils.DateUtils;

import static android.view.View.OnFocusChangeListener;
import static android.app.TimePickerDialog.OnTimeSetListener;


public final class TimePickerInputEditText extends TextInputEditText implements OnFocusChangeListener, OnTimeSetListener {
    private static final String TAG = TimePickerInputEditText.class.getSimpleName();

    private OnFocusChangeListener onFocusChangedListener;
    private FragmentManager manager;
    private boolean is24HourView;
    private String timeFormat;
    private Calendar time;

    public TimePickerInputEditText(Context context) {
        super(context);
        init();
    }

    public TimePickerInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        handleAttributes(attrs);
        init();
    }

    public TimePickerInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleAttributes(attrs);
        init();
    }

    private void init() {
        setOnFocusChangeListener(this);
    }

    private void handleAttributes(@NonNull AttributeSet attributeSet) {
        try {
            final TypedArray array = getContext().obtainStyledAttributes(attributeSet, R.styleable.TimePickerEditText);

            timeFormat = array.getString(R.styleable.TimePickerEditText_timeFormat);
            is24HourView = array.getBoolean(R.styleable.TimePickerEditText_is24HourView, false);

            array.recycle();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFocusChange(View view, boolean isFocused) {
        final InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);

        if (isFocused) {
            final TimePickerFragment timePickerFragment = new TimePickerFragment();

            if (null != time) {
                timePickerFragment.setTime(time);
            }

            timePickerFragment.setOnTimeSetListener(this);
            timePickerFragment.setIs24HourView(is24HourView);
            timePickerFragment.show(manager, TAG);
        }

        if (null != onFocusChangedListener) {
            onFocusChangedListener.onFocusChange(view, isFocused);
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());

        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);

        setText(DateUtils.toTime(calendar.getTime(), timeFormat));
        time = calendar;
    }

    public FragmentManager getManager() {
        return manager;
    }

    public TimePickerInputEditText setManager(@NonNull FragmentManager manager) {
        this.manager = manager;
        return this;
    }

    public Calendar getTime() {
        return time;
    }

    public TimePickerInputEditText setTime(@NonNull Calendar time) {
        this.time = time;
        return this;
    }

    public OnFocusChangeListener getOnFocusChangedListener() {
        return onFocusChangedListener;
    }

    public TimePickerInputEditText setOnFocusChangedListener(OnFocusChangeListener onFocusChangedListener) {
        this.onFocusChangedListener = onFocusChangedListener;
        return this;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public TimePickerInputEditText setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
        return this;
    }

    public boolean is24HourView() {
        return is24HourView;
    }

    public TimePickerInputEditText setIs24HourView(boolean is24HourView) {
        this.is24HourView = is24HourView;
        return this;
    }
}