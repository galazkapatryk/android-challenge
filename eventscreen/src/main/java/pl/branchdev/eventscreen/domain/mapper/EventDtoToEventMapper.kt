package pl.branchdev.eventscreen.domain.mapper

import pl.branchdev.data.EventDto
import pl.branchdev.eventscreen.model.Event
import java.text.SimpleDateFormat
import java.util.*

object EventDtoToEventMapper {
    const val API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val HOUR_MINUTES_FORMAT = "HH:mm"
    const val MONTH_DAY_YEAR_FORMAT = "dd.MM.yyyy"
    fun mapToEvent(eventDto: EventDto): Event {
        return Event(
            title = eventDto.title ?: "",
            subtitle = eventDto.subtitle ?: "",
            thumbnailUrl = eventDto.imageUrl ?: "",
            dateInformation = eventDto.date?.let { convertDateToDateInformation(it) } ?: ""
        )
    }

    private fun convertDateToDateInformation(date: String): String {
        return try {
            val parsedDate = SimpleDateFormat(API_DATE_FORMAT, Locale.GERMAN).parse(date)

            val currentDate = Date()
            when {
                isSameDay(parsedDate, currentDate) -> createTodayDateString(parsedDate)
                isOneDayBefore(parsedDate, currentDate) -> createYesterdayDateString(parsedDate)
                else -> formatDateToString(parsedDate, MONTH_DAY_YEAR_FORMAT)
            }
        } catch (exception: Exception) {
            ""
        }
    }

    private fun formatDateToString(date: Date, format: String): String =
        SimpleDateFormat(format, Locale.GERMAN).format(date)

    private fun createTodayDateString(date: Date) =
        "Today, ${formatDateToString(date, HOUR_MINUTES_FORMAT)}"

    private fun createYesterdayDateString(date: Date) =
        "Yesterday, ${formatDateToString(date, HOUR_MINUTES_FORMAT)}"


    private fun isOneDayBefore(firstDate: Date, secondDate: Date): Boolean {
        SimpleDateFormat("yyyyMMdd").run {
            return secondDate.day - firstDate.day == 1
        }
    }

    private fun isSameDay(firstDate: Date, secondDate: Date): Boolean {
        SimpleDateFormat("yyyyMMdd").run {
            return this.format(firstDate) == this.format(secondDate)
        }
    }
}