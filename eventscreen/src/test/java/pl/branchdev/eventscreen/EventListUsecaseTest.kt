package pl.branchdev.eventscreen

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import junit.framework.Assert.assertTrue
import org.junit.Test
import pl.branchdev.data.EventDto
import pl.branchdev.eventrepository.EventRepository
import pl.branchdev.eventscreen.domain.usecase.EventListUsecase

class EventListUsecaseTest {
    val mockedEventRepository = mock<EventRepository>()

    @Test
    fun `when usecase get empty list then should return empty list`() {
        val usecase = EventListUsecase(mockedEventRepository)
        val eventLists = emptyList<EventDto>()
        whenever(mockedEventRepository.getEvents()).thenReturn(Single.just(eventLists))
        val usecaseReturn = usecase.getEvents().blockingGet()
        assertTrue(usecaseReturn.isEmpty())
    }

    @Test
    fun `when usecase get EventDto list then should return sorted ascending by date list`() {
        val usecase = EventListUsecase(mockedEventRepository)
        val eventLists = List(2) {
            EventDto(
                date = "2019-03-2${9 - it}T16:00:00.970Z",
                id = null,
                imageUrl = null,
                subtitle = null,
                title = it.toString(),
                videoUrl = null
            )
        }
        whenever(mockedEventRepository.getEvents()).thenReturn(Single.just(eventLists))
        val usecaseReturn = usecase.getEvents().blockingGet()
        assertTrue(usecaseReturn.first().title == "1")
        assertTrue(usecaseReturn.get(1).title == "0")
    }
}