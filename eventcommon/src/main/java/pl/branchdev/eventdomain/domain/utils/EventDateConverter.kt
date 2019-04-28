package pl.branchdev.eventdomain.domain.utils

import pl.branchdev.eventdomain.domain.mapper.EventDtoToEventMapper
import java.text.SimpleDateFormat
import java.util.*

object EventDateConverter {
    fun convertDateToDateInformation(currentDate: Date, convertDate: Date): String {
        return when {
            isSameDay(
                convertDate,
                currentDate
            ) -> createTodayDateString(convertDate)
            isOneDayBefore(
                convertDate,
                currentDate
            ) -> createYesterdayDateString(convertDate)
            else -> formatDateToString(
                convertDate,
                EventDtoToEventMapper.MONTH_DAY_YEAR_FORMAT
            )
        }
    }

    private fun createTodayDateString(date: Date) =
        "Today, ${formatDateToString(
            date,
            EventDtoToEventMapper.HOUR_MINUTES_FORMAT
        )}"

    private fun createYesterdayDateString(date: Date) =
        "Yesterday, ${formatDateToString(
            date,
            EventDtoToEventMapper.HOUR_MINUTES_FORMAT
        )}"


    private fun isOneDayBefore(firstDate: Date, secondDate: Date): Boolean {
        return secondDate.day - firstDate.day == 1
    }

    private fun formatDateToString(date: Date, format: String): String =
        SimpleDateFormat(format, Locale.GERMAN).format(date)


    private fun isSameDay(firstDate: Date, secondDate: Date): Boolean {
        SimpleDateFormat("yyyyMMdd").run {
            return this.format(firstDate) == this.format(secondDate)
        }
    }

}