package io.blackbox_vision.datetimepickeredittext.internal.utils


import android.text.format.DateFormat
import android.util.Log

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


object DateUtils {
    private val LOG_TAG = "DateUtils"

    private val DATE_TEMPLATE = "dd/MM/yyyy"
    private val TIME_TEMPLATE = "kk:mm"

    private fun format(date: Date, template: String): CharSequence {
        return DateFormat.format(template, date)
    }

    fun toDate(date: Date, template: String?): CharSequence {
        return format(date, template ?: DATE_TEMPLATE)
    }

    fun toTime(date: Date, template: String?): CharSequence {
        return format(date, template ?: TIME_TEMPLATE)
    }

    fun parse(dateString: String?, template: String?): Date? {
        val sdf = SimpleDateFormat(template ?: DATE_TEMPLATE, Locale.getDefault())
        var date: Date? = null

        try {
            date = sdf.parse(dateString)
        } catch (ex: ParseException) {
            Log.e(LOG_TAG, ex.message, ex.cause)
        }

        return date
    }

    private fun getCurrentDateTime(): String {
        return SimpleDateFormat(DATE_TEMPLATE).format(System.currentTimeMillis())
    }

    fun gettingDate(strDate: String): String {
        return strDate?.takeIf { !it.toUpperCase().equals("CR_DATE") } ?: getCurrentDateTime()
    }
}
