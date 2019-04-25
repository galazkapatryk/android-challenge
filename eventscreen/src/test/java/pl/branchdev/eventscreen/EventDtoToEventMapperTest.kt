package pl.branchdev.eventscreen

import junit.framework.Assert.assertTrue
import org.junit.Test
import pl.branchdev.data.EventDto
import pl.branchdev.eventscreen.domain.mapper.EventDtoToEventMapper
import java.text.SimpleDateFormat
import java.util.*


class EventDtoToEventMapperTest {

    @Test
    fun `when EventDto with title xyz passed to mapper it should return Event object with xyz title`() {
        val eventDto = EventDto(title = "xyz", id = "", subtitle = "", date = "", imageUrl = "", videoUrl = "")
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.title == eventDto.title)
    }

    @Test
    fun `when EventDto with title null passed to mapper it should return Event object with empty title`() {
        val eventDto = EventDto(title = null, id = "", subtitle = "", date = "", imageUrl = "", videoUrl = "")
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.title == "")
    }

    @Test
    fun `when EventDto with subtitle null passed to mapper it should return Event object with empty subtitle`() {
        val eventDto = EventDto(subtitle = null, id = "", title = "", date = "", imageUrl = "", videoUrl = "")
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.subtitle == "")
    }

    @Test
    fun `when EventDto with subtitle xyz passed to mapper it should return Event object with xyz subtitle`() {
        val eventDto = EventDto(subtitle = "xyz", id = "", title = "", date = "", imageUrl = "", videoUrl = "")
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.subtitle == "xyz")
    }

    @Test
    fun `when EventDto with date null passed to mapper it should return Event object with empty dateInformation`() {
        val eventDto = EventDto(date = null, subtitle = "", title = "", id = "", imageUrl = "", videoUrl = "")
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.dateInformation == "")
    }

    @Test
    fun `when EventDto with date incorrect passed to mapper it should return Event object with empty dateInformation`() {
        val eventDto = EventDto(date = "19 june 2019", subtitle = "", title = "", id = "", imageUrl = "", videoUrl = "")
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.dateInformation == "")
    }

    @Test
    fun `when EventDto with passed correct today 4pm date it should convert to "Today, 16 00"`() {
        val todayDate = SimpleDateFormat(API_DATE_FORMAT, Locale.GERMAN).parse("2019-04-25T01:39:44.970Z")
        val eventDto = EventDto(
            date = "2019-04-25T16:00:00.970Z",
            subtitle = "",
            title = "",
            id = "",
            imageUrl = "",
            videoUrl = ""
        )
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.dateInformation == "Today, 16:00")
    }

    @Test
    fun `when EventDto with passed correct yesterday 4pm date it should convert to "Yesterday, 16 00"`() {
        val todayDate = SimpleDateFormat(API_DATE_FORMAT, Locale.GERMAN).parse("2019-04-25T01:39:44.970Z")
        val eventDto = EventDto(
            date = "2019-03-25T16:00:00.970Z",
            subtitle = "",
            title = "",
            id = "",
            imageUrl = "",
            videoUrl = ""
        )
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.dateInformation == "Yesterday, 16:00")
    }

    @Test
    fun `when EventDto with passed correct date other than today and yesterday it should return correct formatted date"`() {
        val todayDate = SimpleDateFormat(API_DATE_FORMAT, Locale.GERMAN).parse("2019-04-27T01:39:44.970Z")
        val eventDto = EventDto(
            date = "2019-03-25T16:00:00.970Z",
            subtitle = "",
            title = "",
            id = "",
            imageUrl = "",
            videoUrl = ""
        )
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.dateInformation == "25.03.2019")
    }

    @Test
    fun `when EventDto with imageurl xyz passed to mapper it should return Event object with xyz thumbnailUrl`() {
        val eventDto = EventDto(id = "", subtitle = "", title = "", date = "", imageUrl = "xyz", videoUrl = "")
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.thumbnailUrl == "xyz")
    }

    @Test
    fun `when EventDto with imageurl null passed to mapper it should return Event object with empty thumbnailUrl`() {
        val eventDto = EventDto(id = "", subtitle = "", title = "", date = "", imageUrl = null, videoUrl = "")
        val event = EventDtoToEventMapper.mapToEvent(eventDto)
        assertTrue(event.thumbnailUrl == "")
    }
}