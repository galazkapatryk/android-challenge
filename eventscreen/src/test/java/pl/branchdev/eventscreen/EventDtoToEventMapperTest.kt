package pl.branchdev.eventscreen

import junit.framework.Assert.assertTrue
import org.junit.Test
import pl.branchdev.data.EventDto
import pl.branchdev.eventscreen.domain.mapper.EventDtoToEventMapper


class EventDtoToEventMapperTest {

    @Test
    fun `when EventDto with title xyz passed to mapper it should return Event object with xyz title`() {
        val eventDto = EventDto(title = "xyz", id = "", subtitle = "", date = "", imageUrl = "", videoUrl = "")
        val eventDtoMapper = EventDtoToEventMapper()
        val event = eventDtoMapper.mapToEvent(eventDto)
        assertTrue(event.title == eventDto.title)
    }

    @Test
    fun `when EventDto with title null passed to mapper it should return Event object with empty title`() {
        val eventDto = EventDto(title = null, id = "", subtitle = "", date = "", imageUrl = "", videoUrl = "")
        val eventDtoMapper = EventDtoToEventMapper()
        val event = eventDtoMapper.mapToEvent(eventDto)
        assertTrue(event.title == "")
    }

    @Test
    fun `when EventDto with subtitle null passed to mapper it should return Event object with empty subtitle`() {
        val eventDto = EventDto(subtitle = null, id = "", title = "", date = "", imageUrl = "", videoUrl = "")
        val eventDtoMapper = EventDtoToEventMapper()
        val event = eventDtoMapper.mapToEvent(eventDto)
        assertTrue(event.subtitle == "")
    }

    @Test
    fun `when EventDto with subtitle xyz passed to mapper it should return Event object with xyz subtitle`() {
        val eventDto = EventDto(subtitle = "xyz", id = "", title = "", date = "", imageUrl = "", videoUrl = "")
        val eventDtoMapper = EventDtoToEventMapper()
        val event = eventDtoMapper.mapToEvent(eventDto)
        assertTrue(event.subtitle == "xyz")
    }

    @Test
    fun `when EventDto with date null passed to mapper it should return Event object with empty dateInformation`() {
        val eventDto = EventDto(date = null, subtitle = "", title = "", id = "", imageUrl = "", videoUrl = "")
        val eventDtoMapper = EventDtoToEventMapper()
        val event = eventDtoMapper.mapToEvent(eventDto)
        assertTrue(event.dateInformation == "")
    }

    @Test
    fun `when EventDto with imageurl xyz passed to mapper it should return Event object with xyz thumbnailUrl`() {
        val eventDto = EventDto(id = "", subtitle = "", title = "", date = "", imageUrl = "xyz", videoUrl = "")
        val eventDtoMapper = EventDtoToEventMapper()
        val event = eventDtoMapper.mapToEvent(eventDto)
        assertTrue(event.thumbnailUrl == "xyz")
    }

    @Test
    fun `when EventDto with imageurl null passed to mapper it should return Event object with empty thumbnailUrl`() {
        val eventDto = EventDto(id = "", subtitle = "", title = "", date = "", imageUrl = null, videoUrl = "")
        val eventDtoMapper = EventDtoToEventMapper()
        val event = eventDtoMapper.mapToEvent(eventDto)
        assertTrue(event.thumbnailUrl == "")
    }
}