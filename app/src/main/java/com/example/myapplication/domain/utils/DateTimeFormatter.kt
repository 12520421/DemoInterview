package com.example.myapplication.domain.utils

import java.text.SimpleDateFormat

interface DateTimeFormatter {
    fun format(time: String): String
}

class DateTimeFormatterImpl : DateTimeFormatter {
    companion object {
        const val NETWORK_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        const val DISPLAY_FORMAT = "dd MMM yyyy"
    }

    override fun format(time: String): String {
        var spf = SimpleDateFormat(NETWORK_TIME_FORMAT)
        val newDate = spf.parse(time)
        spf = SimpleDateFormat(DISPLAY_FORMAT)
        return spf.format(newDate)
    }

}