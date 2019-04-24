package pl.branchdev.eventscreen

import junit.framework.Assert.assertTrue
import org.junit.Test
import pl.branchdev.data.EventDto
import pl.branchdev.eventscreen.domain.mapper.EventDtoToEventMapper


class EventDtoToEventMapperTest {

    @Test
    fun `when EventDto with title xyz passed to mapper it should return Event object with xyz title`() {
        val eventDto = EventDto(title = "xyz", id = "", subtitle = "", date = "", imageUrl = "")
        val eventDtoMapper = EventDtoToEventMapper()
        val event = eventDtoMapper.mapToEvent(eventDto)
        assertTrue(event.title == eventDto.title)
    }
}