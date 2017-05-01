package io.blackbox_vision.datetimepickeredittext.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import io.blackbox_vision.datetimepickeredittext.R;
import io.blackbox_vision.datetimepickeredittext.internal.fragment.DatePickerFragment;
import io.blackbox_vision.datetimepickeredittext.internal.utils.DateUtils;

import static android.view.View.OnFocusChangeListener;
import static android.view.View.OnClickListener;
import static android.app.DatePickerDialog.OnDateSetListener;


public final class DatePickerEditText extends AppCompatEditText implements OnFocusChangeListener, OnClickListener, OnDateSetListener {
    private static final String TAG = DatePickerEditText.class.getSimpleName();

    private OnFocusChangeListener onFocusChangedListener;

    private FragmentManager manager;

    private Integer themeId;

    private String dateFormat;
    private String minDate;
    private String maxDate;

    private DateFormat textDateFormat;

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
        setOnClickListener(this);
        setInputType(InputType.TYPE_NULL);
    }

    private void handleAttributes(@NonNull AttributeSet attributeSet) {
        try {
            final TypedArray array = getContext().obtainStyledAttributes(attributeSet, R.styleable.DateTimePickerEditText);

            themeId = array.getResourceId(R.styleable.DateTimePickerEditText_theme, 0);

            dateFormat = array.getString(R.styleable.DateTimePickerEditText_dateFormat);
            minDate = array.getString(R.styleable.DateTimePickerEditText_minDate);
            maxDate = array.getString(R.styleable.DateTimePickerEditText_maxDate);

            array.recycle();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFocusChange(View view, boolean isFocused) {
        final InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindowToken(), 0);

        if (isFocused) {
            showDatePicker();
        }

        if (null != onFocusChangedListener) {
            onFocusChangedListener.onFocusChange(view, isFocused);
        }
    }

    @Override
    public void onClick(View v) {
        showDatePicker();
    }

    private void showDatePicker() {
        final DatePickerFragment datePickerFragment = new DatePickerFragment()
                .setDate(date)
                .setThemeId(themeId)
                .setOnDateSetListener(this)
                .setMinDate(minDate)
                .setMaxDate(maxDate);

        datePickerFragment.show(manager, TAG);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthOfYear);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        if (textDateFormat != null) {
            setText(textDateFormat.format(calendar.getTime()));
        } else {
            setText(DateUtils.toDate(calendar.getTime(), dateFormat));
        }
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

    public DatePickerEditText setDateFormat(DateFormat format) {
        this.textDateFormat = format;
        return this;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public DatePickerEditText setThemeId(Integer themeId) {
        this.themeId = themeId;
        return this;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public DatePickerEditText setMaxDate(String maxDate) {
        this.maxDate = maxDate;
        return this;
    }

    public String getMinDate() {
        return minDate;
    }

    public DatePickerEditText setMinDate(String minDate) {
        this.minDate = minDate;
        return this;
    }

}