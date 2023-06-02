package io.blackbox_vision.datetimepickeredittext.view

import android.app.Activity
import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TimePicker

import java.text.DateFormat
import java.util.Calendar
import java.util.Locale

import io.blackbox_vision.datetimepickeredittext.R
import io.blackbox_vision.datetimepickeredittext.internal.fragment.TimePickerFragment
import io.blackbox_vision.datetimepickeredittext.internal.utils.DateUtils

import android.view.View.OnFocusChangeListener
import android.view.View.OnClickListener
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.google.android.material.textfield.TextInputEditText


class TimePickerInputEditText : TextInputEditText, OnFocusChangeListener, OnClickListener, OnTimeSetListener {

    private var onFocusChangedListener: OnFocusChangeListener? = null

    private var manager: FragmentManager? = null

    var is24HourView: Boolean = false
        private set

    private var textDateFormat: DateFormat? = null

    private var timeFormat: String? = null

    private var focusCount: Int = 0
    private var themeId: Int? = null

    private var time: Calendar? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        handleAttributes(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        handleAttributes(attrs)
        init()
    }

    private fun init() {
        inputType = InputType.TYPE_NULL
        onFocusChangeListener = this
        setOnClickListener(this)

        /*Set fragment manager*/
        manager = (unwrap(context) as AppCompatActivity).supportFragmentManager
    }

    private fun handleAttributes(attributeSet: AttributeSet) {
        try {
            val array = context.obtainStyledAttributes(attributeSet, R.styleable.DateTimePickerEditText)

            timeFormat = array.getString(R.styleable.DateTimePickerEditText_timeFormat)
            is24HourView = array.getBoolean(R.styleable.DateTimePickerEditText_is24HourView, false)
            themeId = array.getResourceId(R.styleable.DateTimePickerEditText_theme, 0)

            array.recycle()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    override fun onFocusChange(view: View, isFocused: Boolean) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
        focusCount++

        if (isFocused && focusCount == 1) {
            showTimePicker()
        }

        if (null != onFocusChangedListener) {
            onFocusChangedListener!!.onFocusChange(view, isFocused)
        }
    }

    override fun onClick(v: View) {
        showTimePicker()
    }

    private fun showTimePicker() {
        val timePicker = TimePickerFragment()

        timePicker.is24HourView = is24HourView
        timePicker.onTimeSetListener = this
        timePicker.time = time

        timePicker.show(manager!!, TimePickerInputEditText.TAG)
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance(Locale.getDefault())

        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)

        if (textDateFormat != null) {
            setText(textDateFormat!!.format(calendar.time))
        } else {
            setText(DateUtils.toTime(calendar.time, timeFormat))
        }
        time = calendar
    }

    fun getManager(): FragmentManager? {
        return manager
    }

    /*fun setManager(manager: FragmentManager): TimePickerInputEditText {
        this.manager = manager
        return this
    }*/

    fun getTime(): Calendar? {
        return time
    }

    fun setTime(time: Calendar): TimePickerInputEditText {
        this.time = time
        return this
    }

    fun getOnFocusChangedListener(): OnFocusChangeListener? {
        return onFocusChangedListener
    }

    fun setOnFocusChangedListener(onFocusChangedListener: OnFocusChangeListener): TimePickerInputEditText {
        this.onFocusChangedListener = onFocusChangedListener
        return this
    }

    fun getTimeFormat(): String? {
        return timeFormat
    }

    fun setTimeFormat(timeFormat: String): TimePickerInputEditText {
        this.timeFormat = timeFormat
        return this
    }

    fun setTimeFormat(format: DateFormat): TimePickerInputEditText {
        this.textDateFormat = format
        return this
    }

    fun setIs24HourView(is24HourView: Boolean): TimePickerInputEditText {
        this.is24HourView = is24HourView
        return this
    }

    fun getThemeId(): Int? {
        return themeId
    }

    fun setThemeId(themeId: Int?): TimePickerInputEditText {
        this.themeId = themeId
        return this
    }

    private fun unwrap(context: Context): Activity? {
        var _context: Context? = context
        while (_context !is Activity && _context is ContextWrapper) {
            _context = _context.baseContext
        }
        return _context as Activity?
    }

    companion object {
        private val TAG = "TimePickerInputEditText"
    }
}