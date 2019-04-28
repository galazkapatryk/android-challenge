package pl.branchdev.eventdomain

import junit.framework.Assert
import org.junit.Test
import pl.branchdev.eventdomain.domain.mapper.EventDtoToEventMapper
import pl.branchdev.eventdomain.domain.utils.EventDateConverter
import java.text.SimpleDateFormat
import java.util.*

class EventDateConverterTest {
    @Test
    fun `when called eventDate converter with passed correct today 4pm date it should convert to "Today, 16 00"`() {
        val todayDate =
            SimpleDateFormat(EventDtoToEventMapper.API_DATE_FORMAT, Locale.GERMAN).parse("2019-04-25T01:39:44.970Z")
        val convertDate = SimpleDateFormat(EventDtoToEventMapper.API_DATE_FORMAT, Locale.GERMAN).parse("2019-04-25T16:00:00.970Z")
        val dateInformation = EventDateConverter.convertDateToDateInformation(todayDate, convertDate)
        Assert.assertTrue(dateInformation == "Today, 16:00")
    }

    @Test
    fun `when called eventDate converter with passed correct yesterday 4pm date it should convert to "Yesterday, 16 00"`() {
        val todayDate =
            SimpleDateFormat(EventDtoToEventMapper.API_DATE_FORMAT, Locale.GERMAN).parse("2019-04-25T01:39:44.970Z")
        val convertDate = SimpleDateFormat(EventDtoToEventMapper.API_DATE_FORMAT, Locale.GERMAN).parse("2019-04-24T16:00:00.970Z")
        val dateInformation = EventDateConverter.convertDateToDateInformation(todayDate, convertDate)
        Assert.assertTrue(dateInformation == "Yesterday, 16:00")
    }

    @Test
    fun `when called eventDate converter with passed correct date other than today and yesterday it should return correct formatted date"`() {
        val todayDate =
            SimpleDateFormat(EventDtoToEventMapper.API_DATE_FORMAT, Locale.GERMAN).parse("2019-04-27T01:39:44.970Z")
        val convertDate = SimpleDateFormat(EventDtoToEventMapper.API_DATE_FORMAT, Locale.GERMAN).parse("2019-03-25T16:00:00.970Z")
        val dateInformation = EventDateConverter.convertDateToDateInformation(todayDate, convertDate)
        Assert.assertTrue(dateInformation == "25.03.2019")
    }
}