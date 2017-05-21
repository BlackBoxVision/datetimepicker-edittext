package io.blackbox_vision.datetimepickeredittext.internal.fragment

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment

import java.util.Calendar

import android.app.TimePickerDialog.OnTimeSetListener


class TimePickerFragment : DialogFragment() {
    var onTimeSetListener: OnTimeSetListener? = null
        set

    var is24HourView: Boolean? = null
        set

    var themeId: Int? = null
        set

    var time: Calendar? = null
        set

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val hourOfDay: Int
        val minute: Int

        if (null != time) {
            hourOfDay = time!!.get(Calendar.HOUR_OF_DAY)
            minute = time!!.get(Calendar.MINUTE)
        } else {
            val c = Calendar.getInstance()

            hourOfDay = c.get(Calendar.HOUR_OF_DAY)
            minute = c.get(Calendar.MINUTE)
        }

        if (null == is24HourView) {
            is24HourView = true
        }

        if (null != themeId && themeId != 0) {
            return TimePickerDialog(activity, themeId!!, onTimeSetListener, hourOfDay, minute, is24HourView!!)
        }

        return TimePickerDialog(activity, onTimeSetListener, hourOfDay, minute, is24HourView!!)
    }

    fun setOnTimeSetListener(onTimeSetListener: OnTimeSetListener): TimePickerFragment {
        this.onTimeSetListener = onTimeSetListener
        return this
    }

    fun setIs24HourView(is24HourView: Boolean): TimePickerFragment {
        this.is24HourView = is24HourView
        return this
    }

    fun setTime(time: Calendar): TimePickerFragment {
        this.time = time
        return this
    }

    fun setThemeId(themeId: Int?): TimePickerFragment {
        this.themeId = themeId
        return this
    }
}