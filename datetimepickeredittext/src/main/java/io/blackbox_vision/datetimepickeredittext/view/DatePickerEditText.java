package io.blackbox_vision.datetimepickeredittext.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Locale;

import io.blackbox_vision.datetimepickeredittext.R;
import io.blackbox_vision.datetimepickeredittext.internal.fragment.DatePickerFragment;
import io.blackbox_vision.datetimepickeredittext.internal.utils.DateUtils;

import static android.view.View.OnFocusChangeListener;
import static android.app.DatePickerDialog.OnDateSetListener;


public final class DatePickerEditText extends EditText implements OnFocusChangeListener, OnDateSetListener {
    private static final String TAG = DatePickerEditText.class.getSimpleName();

    private OnFocusChangeListener onFocusChangedListener;
    private FragmentManager manager;
    private String dateFormat;
    private Integer themeId;
    private Calendar date;

    public DatePickerEditText(Context context) {
        super(context);
        init();
    }

    public DatePickerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        handleAttributes(attrs);
        init();
    }

    public DatePickerEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleAttributes(attrs);
        init();
    }

    private void init() {
        setOnFocusChangeListener(this);
    }

    private void handleAttributes(@NonNull AttributeSet attributeSet) {
        try {
            final TypedArray array = getContext().obtainStyledAttributes(attributeSet, R.styleable.DateTimePickerEditText);

            dateFormat = array.getString(R.styleable.DateTimePickerEditText_dateFormat);
            themeId = array.getResourceId(R.styleable.DateTimePickerEditText_theme, 0);

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
            new DatePickerFragment()
                    .setDate(date)
                    .setThemeId(themeId)
                    .setOnDateSetListener(this)
                    .show(manager, TAG);
        }

        if (null != onFocusChangedListener) {
            onFocusChangedListener.onFocusChange(view, isFocused);
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthOfYear);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        setText(DateUtils.toDate(calendar.getTime(), dateFormat));
        date = calendar;
    }

    public FragmentManager getManager() {
        return manager;
    }

    public DatePickerEditText setManager(@NonNull FragmentManager manager) {
        this.manager = manager;
        return this;
    }

    public Calendar getDate() {
        return date;
    }

    public DatePickerEditText setDate(@NonNull Calendar date) {
        this.date = date;
        return this;
    }

    public OnFocusChangeListener getOnFocusChangedListener() {
        return onFocusChangedListener;
    }

    public DatePickerEditText setOnFocusChangedListener(OnFocusChangeListener onFocusChangedListener) {
        this.onFocusChangedListener = onFocusChangedListener;
        return this;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public DatePickerEditText setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public DatePickerEditText setThemeId(Integer themeId) {
        this.themeId = themeId;
        return this;
    }
}