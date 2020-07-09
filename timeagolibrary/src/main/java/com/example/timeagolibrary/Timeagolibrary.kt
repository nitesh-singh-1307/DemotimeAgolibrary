package com.example.timeagolibrary

import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

// by nitesh singh developer

class Timeagolibrary {
    companion object {

        public fun CalculateDatefromcurrentdate(put_date: String): String {
            var convTime: String? = null

            try {

                // return the indian calender with time zone
                val cal: Calendar =
                    Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"))

                val currentLocalTime: Date = cal.time
                val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy")

                dateFormat.timeZone = TimeZone.getTimeZone("GMT+1:00")
                var current_date: String = dateFormat.format(currentLocalTime)
                // chcek current time and old time
                Log.e("check_ago_date_time", "++++++++++++++++++++$put_date")
                Log.e("check_current_date_time", "++++++++++++++++++++$current_date")

                var suffix: String = "Ago"
                // change date formate
                val convert_date: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val calendar1: Calendar = Calendar.getInstance()
                // put the old calendar date
                calendar1.time = convert_date.parse(put_date)
                val calendar2: Calendar = Calendar.getInstance()
                // put the new calendar date
                calendar2.time = convert_date.parse(current_date)
                val millis1 = calendar1.timeInMillis
                val millis2 = calendar2.timeInMillis
                val diff = millis2 - millis1
                // Calculate difference in seconds
                val diffSeconds = diff / 1000
                // Calculate difference in minutes
                val diffMinutes = diff / (60 * 1000)
                // Calculate difference in hours
                val diffHours = diff / (60 * 60 * 1000)
                // Calculate difference in days
                val diffDays = diff / (24 * 60 * 60 * 1000)
                // calculate how much month in days
                val maonths = diffDays.toInt() / 30
                val reamainigdays = maonths % 30
                // Calculate the years of monthes
                val getyears = maonths / 12
                val reamainigmothe = getyears % 12
                println("In calculated: ")

                if (diffSeconds < 60) {
                    convTime = "$diffSeconds Seconds $suffix"
                } else if (diffMinutes < 60) {
                    convTime = "$diffMinutes Minutes $suffix"
                } else if (diffHours < 24) {
                    convTime = "$diffHours Hours $suffix"
                } else if (diffDays >= 7) {
                    if (reamainigmothe != 0 && reamainigmothe <= getyears % 12) {
                        convTime =
                            reamainigmothe.toString() + " Years " + getyears + "month" + suffix
                    } else if (diffDays > 30) {
                        convTime = "$maonths Months $suffix"
                    } else {
                        convTime = (diffDays / 7).toString() + " Week " + suffix
                    }
                } else if (diffDays < 7) {
                    convTime = "$diffDays Days $suffix"
                }
                println("In calculated: 222--$convTime")

            } catch (e: Exception) {
                e.printStackTrace()
            }
            // retrun finel date by string formte
            return convTime!!
        }
    }
}