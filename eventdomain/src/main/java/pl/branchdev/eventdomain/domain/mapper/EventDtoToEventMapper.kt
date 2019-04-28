package pl.branchdev.eventdomain.domain.mapper

import pl.branchdev.data.EventDto
import pl.branchdev.eventdomain.model.Event
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
            dateInformation = eventDto.date?.let { convertDateToDateInformation(it) } ?: "",
            videoUrl = eventDto.videoUrl ?: ""
        )
    }

    private fun convertDateToDateInformation(date: String): String {
        return try {
            val parsedDate = SimpleDateFormat(API_DATE_FORMAT, Locale.GERMAN).parse(date)
            val currentDate = Date()
            return pl.branchdev.eventdomain.domain.utils.EventDateConverter.convertDateToDateInformation(currentDate, parsedDate)
        } catch (exception: Exception) {
            ""
        }
    }
}