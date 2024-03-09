package com.gdsc_vitbhopal.notegem.util.date

import android.text.format.DateUtils
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.gdsc_vitbhopal.notegem.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.formatDate(): String {
    val sdf = if (DateUtils.isToday(this))
        SimpleDateFormat("h:mm a", Locale.getDefault())
    else
        SimpleDateFormat("MMM dd,yyyy h:mm a", Locale.getDefault())
    return sdf.format(this)
}

fun Long.fullDate(): String {
    val sdf = SimpleDateFormat("MMM dd,yyyy h:mm a", Locale.getDefault())
    return sdf.format(this)
}

fun Long.formatDay(): String {
    val sdf = SimpleDateFormat("EEEE d", Locale.getDefault())
    return sdf.format(this)
}

fun Long.formatTime(): String {
    val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())
    val sdfNoMinutes = SimpleDateFormat("h a", Locale.getDefault())
    val minutes = SimpleDateFormat("mm", Locale.getDefault()).format(this)
    return if (minutes == "00") sdfNoMinutes.format(this) else sdf.format(this)
}

fun Long.monthName(): String {
    val sdf = if (this.isCurrentYear())
        SimpleDateFormat("MMMM", Locale.getDefault())
    else
        SimpleDateFormat("MMMM yyyy", Locale.getDefault())
    return sdf.format(this)
}

fun Long.sameDay(other: Long): Boolean {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(this) == sdf.format(other)
}

fun Long.isCurrentYear(): Boolean {
    val sdf = SimpleDateFormat("yyyy", Locale.getDefault())
    return sdf.format(this) == sdf.format(Date())
}

@Composable
fun formatEventStartEnd(start: Long, end: Long, location: String?, allDay: Boolean): String {
    return if (allDay)
        stringResource(R.string.all_day)
    else
        stringResource(
            id = if (!location.isNullOrBlank())
                R.string.event_time_at
            else R.string.event_time,
            start.formatTime(),
            end.formatTime(),
            location ?: ""
        )
}